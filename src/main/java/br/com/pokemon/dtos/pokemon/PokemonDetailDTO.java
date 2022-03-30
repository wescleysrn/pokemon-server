package br.com.pokemon.dtos.pokemon;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The pokemon detail model")
public class PokemonDetailDTO implements Serializable {

	private static final long serialVersionUID = 7617007943927870190L;

	@Schema(description = "The Pokemon detail id.")
	@JsonProperty("id")
	private Integer id;
	
	@Schema(description = "The Pokemon detail name.")
	@JsonProperty("name")
	private String name;
	
	@Schema(description = "The Pokemon detail sprites model.")
	private PokemonDetailSpritesDTO sprites;

}
