package ma.wiebatouta.services.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.wiebatouta.models.Message;
import ma.wiebatouta.repositories.MessageRepository;

@Component
public class MessageWriter implements ItemWriter<List<Message>> {

	private final static long DELAI = 3600 * 1000;

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void write(List<? extends List<Message>> items) throws Exception {
		System.out.println("Woek");
		for(List<Message> list:items) {
			System.out.println("Not empty");
			list.forEach(m -> {
				System.out.print("I m here");
				long deadTime = m.getStartTime() + DELAI;
				long currentTime = System.currentTimeMillis();
				if (currentTime >= deadTime) {
					System.out.println("deleting");
					messageRepository.delete(m);
				}
			});
		}
		
	}


}
