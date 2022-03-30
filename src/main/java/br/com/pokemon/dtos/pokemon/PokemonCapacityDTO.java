package br.com.pokemon.dtos.pokemon;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The pokemon capacity model")
public class PokemonCapacityDTO implements Serializable {

	private static final long serialVersionUID = -8256331717911623521L;

	@Schema(description = "The Pokemon id.")
	private Integer id;
	
	@Schema(description = "The Pokemon name.")
	private String name;
	
	@Schema(description = "The Pokemon model.")
	private PokemonDTO[] pokemon;

	public List<PokemonDTO> getPokemonList() {
		return Arrays.asList(getPokemon());
	}
	
}
