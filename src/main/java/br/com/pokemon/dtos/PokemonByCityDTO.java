package br.com.pokemon.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.pokemon.dtos.openweather.CityWeatherDTO;
import br.com.pokemon.dtos.pokemon.PokemonDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Builder
@Schema(description = "The city weather model")
public class PokemonByCityDTO implements Serializable {

	private static final long serialVersionUID = -3405320587143273177L;

	@Schema(description = "The city weather model.")
	@JsonProperty("cityWeather")
	@Getter
	private CityWeatherDTO cityWeather;
	
	@Schema(description = "The pokemon model.")
	@JsonProperty("pokemon")
	@Getter
	private List<PokemonDTO> pokemons;
	
}
