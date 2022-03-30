package br.com.pokemon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pokemon.dtos.PokemonByCityDTO;
import br.com.pokemon.dtos.openweather.CityWeatherDTO;
import br.com.pokemon.dtos.pokemon.PokemonDetailDTO;
import br.com.pokemon.mediators.OpenWeatherMediator;
import br.com.pokemon.mediators.PokemonMediator;
import br.com.pokemon.mediators.PokemonTypeMediator;

/**
 * Class responsible for provide find pokemon and pokemon image
 * @author wescley.sousa
 * @since 30 de mar de 2022
 */
@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private OpenWeatherMediator openWeatherMediator;
	
	@Autowired
	private PokemonMediator pokemonMediator;
	
	@Autowired
	private PokemonTypeMediator pokemonTypeMediator;

	/**
	 * Method responsible for get Pokemons by city name
	 * @param cityName
	 * @return
	 */	
	@Override
	public PokemonByCityDTO getPokemonsByCityName(String cityName) {
		CityWeatherDTO cityWeather = openWeatherMediator.getWeatherByCityName(cityName);
		PokemonByCityDTO pokemons = 
			PokemonByCityDTO.builder()
						    .cityWeather(cityWeather)
						    .pokemons(
								pokemonMediator.getPokemonByType(
									pokemonTypeMediator.getPokemonTypeByTemperature(
										cityWeather.getCityWeatherTemperature().getTemperature()
									)
								)
							 )
						    .build();
		return pokemons;
	}

	/**
	 * Method responsible for get Pokemon image by pokemon url 
	 * @param url
	 * @return
	 */	
	@Override
	public PokemonDetailDTO getPokemonImageByUrl(String url) {
		return pokemonMediator.getPokemonImageByUrl(url);
	}
	
}
