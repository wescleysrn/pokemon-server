package br.com.pokemon.dto.openweather;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The city weather description model")
public class CityWeatherDescriptionDTO implements Serializable {

	private static final long serialVersionUID = 3325849852212455609L;

	@Schema(description = "The id of city weather description.")
	private Integer id;
	
	@Schema(description = "The weather situation of city weather description.")
	@JsonProperty("main")
	private String weatherSituation;
	
	@Schema(description = "The city weather description.")
	private String description;
	
	@Schema(description = "The icon of city weather description.")
	private String icon;
	
}
