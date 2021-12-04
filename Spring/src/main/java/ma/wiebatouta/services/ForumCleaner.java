package ma.wiebatouta.services;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ma.wiebatouta.models.Message;
import ma.wiebatouta.services.readers.MessageReader;
import ma.wiebatouta.services.writers.MessageWriter;

@Configuration
@EnableBatchProcessing
public class ForumCleaner implements Runnable {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private MessageWriter messageWriter;
	@Autowired
	private MessageReader messageReader;

	private final static int DELAI_HOURS = 14;
	private final static int DELAI_MINUTES = 17;

	public Job cleanForum() {
		Step step = stepBuilderFactory.get("Steo to clean forum").<List<Message>, List<Message>>chunk(100)
				.reader(messageReader).writer(messageWriter).build();
		return jobBuilderFactory.get("Cleaner").start(step).build();
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis());
		while (true) {
			Calendar rightNow = Calendar.getInstance();
			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
			int minute = rightNow.get(Calendar.MINUTE);
			if ((hour == DELAI_HOURS && minute == DELAI_MINUTES )) {
				System.out.println("Start JOB ");
				Job cleaner = cleanForum();
				
				try {
					Map<String, JobParameter> parameters = new HashMap<String,JobParameter>();
					JobExecution jobExecution = jobLauncher.run(cleaner, new JobParameters(parameters));
					while(jobExecution.isRunning()) {
						System.out.print("...");
					}
					try {
						Thread.sleep(70*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (JobExecutionAlreadyRunningException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JobRestartException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JobInstanceAlreadyCompleteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JobParametersInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

}
