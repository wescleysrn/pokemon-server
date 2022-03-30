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
@Schema(description = "The pokemon detail home model")
public class PokemonDetailHomeDTO implements Serializable {

	private static final long serialVersionUID = 1731542012443327826L;
	
	@Schema(description = "The Pokemon image.")
	@JsonProperty("front_default")
	private String pokemomImage;
	
}
