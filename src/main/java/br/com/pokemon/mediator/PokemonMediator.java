package br.com.pokemon.mediator;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.pokemon.dto.PokemonCapacityDTO;
import br.com.pokemon.dto.PokemonDTO;
import br.com.pokemon.dto.PokemonDetailDTO;

/**
 * Class responsible for made request to Pokemon API
 * @author wescley.sousa
 * @since 19 de mar de 2022
 */
@Service
public class PokemonMediator {

	private static final String POKEAPI_URI = "https://pokeapi.co/api/v2/type/";
	
	/**
	 * Function responsible for get the Array of Pokemons for type
	 * @param pokemonType
	 * @return
	 * @throws Exception
	 */
	public List<PokemonDTO> getPokemonByType(final String pokemonType) throws Exception {
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			final HttpEntity<?> entity = new HttpEntity<PokemonCapacityDTO>(headers);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpEntity<PokemonCapacityDTO> pokemon = restTemplate.exchange(
					POKEAPI_URI + pokemonType, HttpMethod.GET, entity, PokemonCapacityDTO.class);
			
			return pokemon.getBody().getPokemonDTOList();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * Function responsible for get the image of a pokemon for url
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public PokemonDetailDTO getPokemonImageByUrl(final String url) throws Exception {
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			final HttpEntity<?> entity = new HttpEntity<PokemonDetailDTO>(headers);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpEntity<PokemonDetailDTO> pokemon = restTemplate.exchange(
					url, HttpMethod.GET, entity, PokemonDetailDTO.class);
			return pokemon.getBody();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
