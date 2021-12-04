package ma.wiebatouta.services;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ma.wiebatouta.repositories.MessageRepository;

@Component
public class ForumCleaner {
	
	@Autowired
	private MessageRepository messageRepository;
	
	/*@Bean
	public Job cleanForum() {
		return null;
	}*/
	
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
