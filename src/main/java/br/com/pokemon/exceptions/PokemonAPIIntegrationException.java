package br.com.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "An Pokemon API Integration Error Occurred")
public class PokemonAPIIntegrationException extends APIIntegrationException {

	private static final long serialVersionUID = -4284697425008880250L;

	public PokemonAPIIntegrationException(String message) {
		super(message);
	}
	
}
