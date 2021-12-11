package ma.wiebatouta.exceptions;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
}