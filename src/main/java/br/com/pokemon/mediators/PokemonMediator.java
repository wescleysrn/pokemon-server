package br.com.pokemon.mediators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.pokemon.dto.pokemon.PokemonCapacityDTO;
import br.com.pokemon.dto.pokemon.PokemonDTO;
import br.com.pokemon.dto.pokemon.PokemonDetailDTO;
import br.com.pokemon.exception.PokemonAPIIntegrationException;

/**
 * Class responsible for made request to Pokemon API
 * @author wescley.sousa
 * @since 19 de mar de 2022
 */
@Component
@PropertySource("classpath:pokemon-api.properties")
public class PokemonMediator {

	@Value( "${api.pokemon.uri}" )
	private String pokemonAPI;
	
	@Autowired
	private RestTemplate appRestTemplate;
	
	/**
	 * Function responsible for get the Array of Pokemons for type
	 * @param pokemonType
	 * @return
	 * @throws Exception
	 */
	public List<PokemonDTO> getPokemonByType(final String pokemonType) {
		try {
			final HttpEntity<?> entity = new HttpEntity<PokemonCapacityDTO>(new HttpHeaders());
			final HttpEntity<PokemonCapacityDTO> pokemon = appRestTemplate.exchange(
					pokemonAPI + pokemonType, HttpMethod.GET, entity, PokemonCapacityDTO.class);
			return pokemon.getBody().getPokemonList();
		} catch (HttpClientErrorException ex) {
			throw handlePokemonAPIIntegrationException(ex);
		}
	}
	
	/**
	 * Function responsible for get the image of a pokemon for url
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public PokemonDetailDTO getPokemonImageByUrl(final String url) {
		try {
			final HttpEntity<?> entity = new HttpEntity<PokemonDetailDTO>(new HttpHeaders());
			final HttpEntity<PokemonDetailDTO> pokemon = appRestTemplate.exchange(
					url, HttpMethod.GET, entity, PokemonDetailDTO.class);
			return pokemon.getBody();
		} catch (HttpClientErrorException ex) {
			throw handlePokemonAPIIntegrationException(ex);
		}
	}
	
	/**
	 * Method responsible for exception handle
	 * @param ex
	 * @return
	 */
	private PokemonAPIIntegrationException handlePokemonAPIIntegrationException(HttpClientErrorException ex) {
		switch(ex.getStatusCode()) {
		default:
			return new PokemonAPIIntegrationException("Error in API integration");
		}
	}
	
}
