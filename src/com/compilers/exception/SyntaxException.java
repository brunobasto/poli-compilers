package com.compilers.exception;

public class SyntaxException extends Exception {

	public SyntaxException(String message) {
		_message = message;
	}

	@Override
	public String getMessage() {
		return _message;
	}

	private final String _message;

}