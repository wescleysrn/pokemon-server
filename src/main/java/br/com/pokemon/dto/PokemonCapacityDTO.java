package br.com.pokemon.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonCapacityDTO implements Serializable {

	private static final long serialVersionUID = -8256331717911623521L;

	private Integer id;
	
	private String name;
	
	private PokemonDTO[] pokemon;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonDTO[] getPokemon() {
		return pokemon;
	}

	public List<br.com.pokemon.dto.PokemonDTO> getPokemonDTOList() {
		List<br.com.pokemon.dto.PokemonDTO> result = new ArrayList<>();
		for (PokemonDTO pokemonDTO : pokemon) {
			br.com.pokemon.dto.PokemonDTO register = new br.com.pokemon.dto.PokemonDTO();
			register.setSlot(pokemonDTO.getSlot());
			register.setPokemon(pokemonDTO.pokemon);
			result.add(register);
		}
		return result;
	}

	public void setPokemon(PokemonDTO[] pokemon) {
		this.pokemon = pokemon;
	}

	static class PokemonDTO {
		
		private Integer slot;

		private PokemonI pokemon;
		
		public Integer getSlot() {
			return slot;
		}

		public void setSlot(Integer slot) {
			this.slot = slot;
		}
		
		public PokemonI getPokemon() {
			return pokemon;
		}

		public void setPokemon(PokemonI pokemon) {
			this.pokemon = pokemon;
		}
		
		static class PokemonI {
			
			private String name;
			
			private String url;

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
	
}
