package br.com.pokemon.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokemon.dto.CityWeatherDTO;
import br.com.pokemon.mediator.OpenWeatherMediator;

@RestController
@RequestMapping("/api/openweather")
public class OpenWeatherRest {

	@Autowired
	private OpenWeatherMediator openWeatherMediator;
	
	@RequestMapping(value = "/bycity/{city}", method = RequestMethod.GET)
	public HttpEntity<CityWeatherDTO> getWeatherByCityName(@PathVariable("city") String city) throws Exception {
		try {
			CityWeatherDTO cityWeatherDTO = openWeatherMediator.getWeatherByCityName(city);
			return new ResponseEntity<CityWeatherDTO>(cityWeatherDTO, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
