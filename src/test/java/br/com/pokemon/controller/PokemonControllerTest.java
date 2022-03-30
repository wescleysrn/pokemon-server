package br.com.pokemon.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pokemon.controllers.PokemonController;
import br.com.pokemon.dto.PokemonByCityDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PokemonControllerTest {

	@Autowired
	private PokemonController pokemonController;
	
	@Test
	public void getWeatherByCityNameTest() {
		try {
			ResponseEntity<PokemonByCityDTO> result = 
					(ResponseEntity<PokemonByCityDTO>) pokemonController.getPokemonsByCityName("Lisbon");
			assertThat(result.getStatusCode(), is(HttpStatus.OK));
		} catch (Exception e) {
			assertThat(Boolean.TRUE, is(Boolean.FALSE));
		}		
	}
	
}
