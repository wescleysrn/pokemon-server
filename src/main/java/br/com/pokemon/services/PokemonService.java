package br.com.pokemon.services;

import br.com.pokemon.dto.PokemonByCityDTO;
import br.com.pokemon.dto.pokemon.PokemonDetailDTO;

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
