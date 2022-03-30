package br.com.pokemon.dto.pokemon;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The pokemon detail sprites model")
public class PokemonDetailSpritesDTO implements Serializable {

	private static final long serialVersionUID = 5119358371318561091L;
	
	@Schema(description = "The Pokemon detail other model.")
	private PokemonDetailOtherDTO other;
	
}
