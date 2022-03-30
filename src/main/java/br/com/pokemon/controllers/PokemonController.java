package br.com.pokemon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokemon.dtos.PokemonByCityDTO;
import br.com.pokemon.dtos.openweather.CityWeatherDTO;
import br.com.pokemon.dtos.pokemon.PokemonDetailDTO;
import br.com.pokemon.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

/**
 * Class responsible for provide Pokemon API functionality
 * @author wescley.sousa
 * @since 19 de mar de 2022
 */
@RestController
@RequestMapping("/api/pokemonchallenge")
@Tag(name = "Pokemon Challenge API", description = "The Pokemon API Call")
@Log4j2
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;
	
	/**
	 * Method responsible for get Pokemons by city name
	 * @param cityName
	 * @return
	 */
	@GetMapping(value = "/pokemons/{city}")
	@Operation(summary = "Get the weather of a city by name")
	@ApiResponses(value = { 
		@ApiResponse(responseCode = "200", description = "Found the pokemons information by city name", 
			    	 content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, 
			    	 schema = @Schema(implementation = CityWeatherDTO.class)) }),
		@ApiResponse(responseCode = "404", description = "Pokemons not found", 
	    			 content = @Content)
	})
	public HttpEntity<PokemonByCityDTO> getPokemonsByCityName(@Parameter(description="The city name parameter.", required=true) 
														   	  @PathVariable("city") String cityName) {
		log.info("Pokemons By City Name API Call for " + cityName);
		PokemonByCityDTO pokemons = pokemonService.getPokemonsByCityName(cityName);
		return new ResponseEntity<PokemonByCityDTO>(pokemons, HttpStatus.OK);			
	}
	
	/**
	 * Method responsible for get Pokemon image by pokemon url 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/imagem")
	@Operation(summary = "Get the Pokemon image by url")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Found the Pokemon image by url", 
				    	 content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, 
				    	 schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "404", description = "Pokemon image not found", 
			   			 content = @Content)
	})
	public HttpEntity<PokemonDetailDTO> getPokemonImageByUrl(
			@RequestParam String url) throws Exception {
		log.info("Get pokemon image API Call for url " + url);
		return new ResponseEntity<PokemonDetailDTO>(pokemonService.getPokemonImageByUrl(url), HttpStatus.OK);
	}
	
}
