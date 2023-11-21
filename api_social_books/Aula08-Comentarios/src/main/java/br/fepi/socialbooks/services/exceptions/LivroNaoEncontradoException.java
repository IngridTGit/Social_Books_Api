package br.fepi.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = -5260921470114923100L;

	public LivroNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public LivroNaoEncontradoException(String message) {
		super(message);		
	}

	

}
