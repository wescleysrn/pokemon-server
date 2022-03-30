package br.com.pokemon.dto.pokemon;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The pokemon model")
public class PokemonDTO implements Serializable {

	private static final long serialVersionUID = -7750174946326484179L;

	@Schema(description = "The order the Pokémon's types are listed in.")
	@JsonProperty("slot")
	private Integer pokemonOrder;
	
	@Schema(description = "The Pokémon's collection for a specific type.")
	private PokemonNameUrlDTO pokemon;

}
