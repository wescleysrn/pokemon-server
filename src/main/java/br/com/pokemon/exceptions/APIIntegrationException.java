package br.com.pokemon.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class APIIntegrationException extends RuntimeException {

	private static final long serialVersionUID = -6016892846225787105L;

	public APIIntegrationException(String message) {
		super(message);
	}
	
}
