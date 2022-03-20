package br.com.pokemon.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pokemon.dto.PokemonDTO;
import br.com.pokemon.dto.PokemonDetailDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PokemonRestTest {

	@Autowired
	private PokemonRest pokemonRest;
	
	@Test
	public void getPokemonByTypeTest() {
		ResponseEntity<List<PokemonDTO>> result;
		try {
			result = (ResponseEntity<List<PokemonDTO>>) pokemonRest.getPokemonByType("electric");
			assertThat(result.getStatusCode(), is(HttpStatus.OK));
			assertThat(result.getBody().isEmpty(), is(false));
		} catch (Exception e) {
			assertThat(Boolean.TRUE, is(Boolean.FALSE));
		}
	}
	
	@Test
	public void getPokemonImageByUrlTest() {
		ResponseEntity<PokemonDetailDTO> result;
		try {
			result = (ResponseEntity<PokemonDetailDTO>) 
					pokemonRest.getPokemonImageByUrl("https://pokeapi.co/api/v2/pokemon/26/");
			assertThat(result.getStatusCode(), is(HttpStatus.OK));
			assertThat(result.getBody().getName(), is("raichu"));
		} catch (Exception e) {
			assertThat(Boolean.TRUE, is(Boolean.FALSE));
		}
	}
	
}
