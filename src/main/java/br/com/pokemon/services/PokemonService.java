package br.com.pokemon.services;

import br.com.pokemon.dtos.PokemonByCityDTO;
import br.com.pokemon.dtos.pokemon.PokemonDetailDTO;

public interface PokemonService {

	/**
	 * Method responsible for get Pokemons by city name
	 * @param cityName
	 * @return
	 */
	PokemonByCityDTO getPokemonsByCityName(String cityName);

	/**
	 * Method responsible for get Pokemon image by pokemon url 
	 * @param url
	 * @return
	 */
	PokemonDetailDTO getPokemonImageByUrl(String url);
	
}
