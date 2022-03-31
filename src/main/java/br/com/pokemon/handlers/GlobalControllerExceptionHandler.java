package br.com.pokemon.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.pokemon.exceptions.CityNotFoundException;
import br.com.pokemon.exceptions.OpenWeatherIntegrationException;
import br.com.pokemon.exceptions.PokemonAPIIntegrationException;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleCityNotFound(CityNotFoundException ex) {
    	log.error("Weather By City Name API Call don't find information or city name is not valid.");
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, ex);
    }
    
    @ExceptionHandler(OpenWeatherIntegrationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleOpenWeatherIntegration(OpenWeatherIntegrationException ex) {
    	log.error("Open Weather API Integration Error.");
    	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, null, ex);
    }
    
    @ExceptionHandler(PokemonAPIIntegrationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handlePokemonIntegration(PokemonAPIIntegrationException ex) {
    	log.error("Pokemon API Integration Error.");
    	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, null, ex);
    }
    
}
