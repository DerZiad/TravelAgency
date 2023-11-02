package ma.wiebatouta.controllers;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import ma.wiebatouta.exceptions.NotFoundException;

@ControllerAdvice
public class MessagingAdvice {
	@ExceptionHandler(MessagingException.class)
	public ModelAndView messageExcept(MessagingException exception){
		ModelAndView model = new ModelAndView("403");
		exception.printStackTrace();
		model.addObject("exception", "Erreur de notre email service, veuillez ressayer plus tard");
		return model;
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView surveillerAnonymousAcess(NotFoundException exception){
		ModelAndView model = new ModelAndView("403");
		exception.printStackTrace();
		model.addObject("exception", "Veuillez ne pas changer n'importe quel id");
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception exception){
		ModelAndView model = new ModelAndView("403");
		exception.printStackTrace();
		model.addObject("exception", "Erreur du serveur ressayer plus tard");
		return model;
	}
}
