package ma.wiebatouta;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import ma.wiebatoute.repositories.MessageRepository;

@Service
public class ForumCleaner implements Runnable{
	
	/*@Autowired
	private MessageRepository messageRepository;
	*/
	/*@Bean
	public Job cleanForum() {
		return null;
	}*/
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
