package ma.wiebatouta.services;

import java.util.Calendar;
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
import ma.wiebatouta.models.Reservation;
import ma.wiebatouta.services.readers.MessageReader;
import ma.wiebatouta.services.readers.ReservationReader;
import ma.wiebatouta.services.writers.MessageWriter;
import ma.wiebatouta.services.writers.ReservationWriter;

@Configuration
@EnableBatchProcessing
public class ReservationCleaner implements Runnable {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private ReservationWriter reservationWriter;
	@Autowired
	private ReservationReader reservationReader;

	private final static int DELAI_HOURS = 14;
	private final static int DELAI_MINUTES = 17;

	public Job cleanForum() {
		Step step = stepBuilderFactory.get("Steo to clean forum").<List<Reservation>, List<Reservation>>chunk(100)
				.reader(reservationReader).writer(reservationWriter).build();
		return jobBuilderFactory.get("ReservationCleaner").start(step).build();
	}

	@Override
	public void run() {
		while (true) {
			Calendar rightNow = Calendar.getInstance();
			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
			int minute = rightNow.get(Calendar.MINUTE);
			if ((hour == DELAI_HOURS && minute == DELAI_MINUTES )) {
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
