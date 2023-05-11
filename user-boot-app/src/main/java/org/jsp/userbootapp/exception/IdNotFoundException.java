package org.jsp.userbootapp.exception;

public class IdNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "id is not present";
		
	}

}
