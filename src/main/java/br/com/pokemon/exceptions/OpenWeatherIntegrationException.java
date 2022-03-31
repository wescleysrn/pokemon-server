package br.com.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "An Open Weather API Integration Error Occurred")
public class OpenWeatherIntegrationException extends APIIntegrationException {

	private static final long serialVersionUID = 695225381205650108L;

	public OpenWeatherIntegrationException(String message) {
		super(message);
	}
	
}
