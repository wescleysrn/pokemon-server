package br.com.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The city entered was not found in the Weather API")
public class CityNotFoundException extends OpenWeatherIntegrationException {

	private static final long serialVersionUID = -5650137028798444098L;

	public CityNotFoundException(String message) {
		super(message);
	}

}
