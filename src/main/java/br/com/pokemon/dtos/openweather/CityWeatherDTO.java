package br.com.pokemon.dtos.openweather;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The city weather model")
public class CityWeatherDTO implements Serializable {
	
	private static final long serialVersionUID = 5694275011893835625L;

	@Schema(description = "The id of getWeatherByCityName returd.", 
            example = "62482211", required = true)
	private Integer id;

	@Schema(description = "The city name passed as parameter.", 
            example = "London", required = true)
	@JsonProperty("name")
	private String cityName;

	@Schema(description = "The city weather description return.")
	@JsonProperty("weather")
	private List<CityWeatherDescriptionDTO> cityWeatherDescription;

	@Schema(description = "The city weather temperature return.")
	@JsonProperty("main")
	private CityWeatherTemperatureDTO cityWeatherTemperature;
	
}
