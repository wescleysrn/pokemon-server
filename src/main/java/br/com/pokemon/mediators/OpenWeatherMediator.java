package br.com.pokemon.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pokemon.dto.openweather.CityWeatherDTO;
import br.com.pokemon.exception.CityNotFoundException;
import br.com.pokemon.exception.OpenWeatherIntegrationException;

/**
 * Class responsible for made request to Weather API
 * @author wescley.sousa
 * @since 19 de mar de 2022
 */
@Component
@PropertySource("classpath:openweather.properties")
public class OpenWeatherMediator {
	
	@Value( "${open.weather.api}" )
	private String openWeatherAPI;
	
	@Value( "${open.weather.key}" )
	private String openWeatherKey;
	
	@Autowired
	private RestTemplate appRestTemplate;
	
	/**
	 * Method responsible for get weather information from open weather api.
	 * @param city
	 * @return
	 * @throws CityNotFoundException 
	 * @throws Exception
	 */
	public CityWeatherDTO getWeatherByCityName(String city) {
		try {
			final HttpEntity<?> entity = new HttpEntity<CityWeatherDTO>(new HttpHeaders());
			final HttpEntity<CityWeatherDTO> pokemon = appRestTemplate.exchange(
					generateURIParameter(city).toUriString(), HttpMethod.GET, entity, CityWeatherDTO.class);
			return pokemon.getBody();
		} catch (HttpClientErrorException ex) {
			throw handleOpenWeatherIntegrationException(ex);
		}
	}

	/**
	 * Method responsible for generate URI parameter
	 * @param city
	 * @return
	 */
	private UriComponentsBuilder generateURIParameter(String city) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openWeatherAPI)
				.queryParam("q", city)
				.queryParam("appid", openWeatherKey)
				.queryParam("units", "metric");
		return builder;
	}

	/**
	 * Method responsible for exception handle
	 * @param ex
	 * @return
	 */
	private OpenWeatherIntegrationException handleOpenWeatherIntegrationException(HttpClientErrorException ex) {
		switch(ex.getStatusCode()) {
		case NOT_FOUND:
			return new CityNotFoundException();
		default:
			return new OpenWeatherIntegrationException("Error in Open Weather API integration");
		}
	}
	
}
