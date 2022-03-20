package br.com.pokemon.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokemon.dto.PokemonDTO;
import br.com.pokemon.dto.PokemonDetailDTO;
import br.com.pokemon.mediator.PokemonMediator;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonRest {

	@Autowired
	private PokemonMediator pokemonMediator;

	@RequestMapping(value = "/bytype/{pokemonType}", method = RequestMethod.GET)
	public HttpEntity<List<PokemonDTO>> getPokemonByType(@PathVariable("pokemonType") String pokemonType) throws Exception {
		try {
			List<PokemonDTO> listPokemonDTO = pokemonMediator.getPokemonByType(pokemonType);
			return new ResponseEntity<List<PokemonDTO>>(listPokemonDTO, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value = "/imagem", method = RequestMethod.GET)
	public HttpEntity<PokemonDetailDTO> getPokemonImageByUrl(@RequestParam String url) throws Exception {
		try {
			return new ResponseEntity<PokemonDetailDTO>(pokemonMediator.getPokemonImageByUrl(url), HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
