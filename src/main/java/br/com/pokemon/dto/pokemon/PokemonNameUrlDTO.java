package br.com.pokemon.dto.pokemon;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The pokemon name and url model")
public class PokemonNameUrlDTO implements Serializable {

	private static final long serialVersionUID = -1388692998525440254L;

	@Schema(description = "The Pokemon name.")
	private String name;
	
	@Schema(description = "The Pokemon URL.")
	private String url;
	
}
