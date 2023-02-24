package ma.wiebatouta.services.readers;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.wiebatouta.models.Message;
import ma.wiebatouta.repositories.MessageRepository;
@Component
public class MessageReader implements ItemReader<List<Message>> {

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public List<Message> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return messageRepository.findAll();
	}

}
