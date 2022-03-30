package br.com.pokemon.dto.pokemon;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The pokemon detail other model")
public class PokemonDetailOtherDTO implements Serializable {

	private static final long serialVersionUID = 3945848454860520138L;
	
	@Schema(description = "The Pokemon detail home model.")
	private PokemonDetailHomeDTO home;
	
}
