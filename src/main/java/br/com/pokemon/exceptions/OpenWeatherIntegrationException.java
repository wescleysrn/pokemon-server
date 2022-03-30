package br.com.pokemon.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OpenWeatherIntegrationException extends APIIntegrationException {

	private static final long serialVersionUID = 695225381205650108L;

	public OpenWeatherIntegrationException(String message) {
		super(message);
	}
	
}
