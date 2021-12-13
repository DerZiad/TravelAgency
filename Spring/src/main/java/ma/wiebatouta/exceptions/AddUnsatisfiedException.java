package ma.wiebatouta.exceptions;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

import lombok.Data;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
public class AddUnsatisfiedException extends Exception {
	private HashMap<String, String> errors = new HashMap<String,String>();

	private static final long serialVersionUID = 1L;

	public AddUnsatisfiedException(String msg) {
		super(msg);
	}

	public AddUnsatisfiedException() {

	}

	@Override
	public String toString() {
		System.out.println(errors.toString());
		return errors.toString();
	}
	
}