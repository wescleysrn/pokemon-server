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
@Schema(description = "The city weather temperature model")
public class CityWeatherTemperatureDTO implements Serializable {

	private static final long serialVersionUID = -4681587996744726767L;

	@Schema(description = "The city temperature return.", 
            example = "12.5", required = true)
	@JsonProperty("temp")
	private Double temperature;
	
	@Schema(description = "The thermal sensation value.")
	@JsonProperty("feels_like")
	private Integer thermalSensation;
	
	@Schema(description = "The minimum temperature value.")
	@JsonProperty("temp_min")
	private Double temperatureMinimum;
	
	@Schema(description = "The maximum temperature value.")
	@JsonProperty("temp_max")
	private Double temperatureMaximum;
	
	@Schema(description = "The pressure value.")
	private Double pressure;

	@Schema(description = "The humidity value.")
	private Double humidity;
	
}
