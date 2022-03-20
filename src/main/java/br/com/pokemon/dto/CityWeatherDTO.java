package br.com.pokemon.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityWeatherDTO implements Serializable {
	
	private static final long serialVersionUID = 5694275011893835625L;

	private Integer id;
	
	private String name;

	private List<WeatherI> weather;
	
	private MainI main;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MainI getMain() {
		return main;
	}

	public void setMain(MainI main) {
		this.main = main;
	}

	public List<WeatherI> getWeather() {
		return weather;
	}

	public void setWeather(WeatherI[] weather) {
		this.weather = Arrays.asList(weather);
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	static class WeatherI {
		
		private Integer id;
		
		private String main;
		
		@JsonProperty("description")
		private String description;
		
		private String icon;

		public WeatherI() {}
		
		public Integer getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMain() {
			return main;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}
		
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class MainI {
		
		private Double temp;
		
		private Integer feels_like;
		
		private Double temp_min;
		
		private Double temp_max;
		
		private Double pressure;

		private Double humidity;

		public Double getTemp() {
			return temp;
		}

		public void setTemp(Double temp) {
			this.temp = temp;
		}

		public Integer getFeels_like() {
			return feels_like;
		}

		public void setFeels_like(Integer feels_like) {
			this.feels_like = feels_like;
		}

		public Double getTemp_min() {
			return temp_min;
		}

		public void setTemp_min(Double temp_min) {
			this.temp_min = temp_min;
		}

		public Double getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(Double temp_max) {
			this.temp_max = temp_max;
		}

		public Double getPressure() {
			return pressure;
		}

		public void setPressure(Double pressure) {
			this.pressure = pressure;
		}

		public Double getHumidity() {
			return humidity;
		}

		public void setHumidity(Double humidity) {
			this.humidity = humidity;
		}
		
	}
	
}
