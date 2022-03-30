package br.com.pokemon.mediator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pokemon.dto.pokemon.PokemonDTO;
import br.com.pokemon.dto.pokemon.PokemonDetailDTO;
import br.com.pokemon.mediators.PokemonMediator;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class PokemonMediatorTest {

	@Autowired
	PokemonMediator pokemonMediator;
	
	@Test
	public void getPokemonByTypeTest() {
		List<PokemonDTO> pokemonDTO;
		try {
			pokemonDTO = pokemonMediator.getPokemonByType("electric");
			assertThat(pokemonDTO.isEmpty(), is(false));
		} catch (Exception e) {
			assertThat(Boolean.TRUE, is(Boolean.FALSE));
		}
	}
	
	@Test
	public void getPokemonImageByUrlTest() {
		PokemonDetailDTO pokemonDetailDTO;
		try {
			pokemonDetailDTO = pokemonMediator.getPokemonImageByUrl("https://pokeapi.co/api/v2/pokemon/26/");			
			assertThat(pokemonDetailDTO.getName(), is("raichu"));
		} catch (Exception e) {
			assertThat(Boolean.TRUE, is(Boolean.FALSE));
		}
	}
	
}
