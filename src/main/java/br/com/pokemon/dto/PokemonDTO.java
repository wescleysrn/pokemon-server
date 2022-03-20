package br.com.pokemon.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDTO implements Serializable {

	private static final long serialVersionUID = -7750174946326484179L;

	private Integer slot;
	
	private List<PokemonI> pokemon;

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public List<PokemonI> getPokemon() {
		return pokemon;
	}
	
	public void setPokemon(br.com.pokemon.dto.PokemonCapacityDTO.PokemonDTO.PokemonI pokemon2) {
		List<PokemonI> listPokemonI = Arrays.asList(pokemon2).stream()
				.map(pokemon -> new PokemonI(pokemon.getName(), pokemon.getUrl()))
				.collect(Collectors.toList());
		this.pokemon = listPokemonI;
	}

	static class PokemonI {
		
		private String name;
		
		private String url;

		public PokemonI() {}

		public PokemonI(String name, String url) {
			super();
			this.name = name;
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
		
	}

}
