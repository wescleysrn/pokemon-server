package br.com.pokemon.mediator;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pokemon.dto.CityWeatherDTO;

/**
 * Class responsible for made request to Weather API
 * @author wescley.sousa
 * @since 19 de mar de 2022
 */
@Component
public class OpenWeatherMediator {
	
	private static final String OPEN_WEATHER_API = "https://api.openweathermap.org/data/2.5/weather";
	private static final String OPEN_WEATHER_KEY = "46780699ebecf62b05ad72862f1ab492";
	
	/**
	 * Method responsible for get weather information from open weather api.
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public CityWeatherDTO getWeatherByCityName(String city) throws Exception {
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			
			final HttpEntity<?> entity = new HttpEntity<CityWeatherDTO>(headers);
			final RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(OPEN_WEATHER_API)
					.queryParam("q", city)
					.queryParam("appid", OPEN_WEATHER_KEY)
					.queryParam("units", "metric");
			
			final HttpEntity<CityWeatherDTO> pokemon = restTemplate.exchange(
					builder.toUriString(), HttpMethod.GET, entity, CityWeatherDTO.class);

			return pokemon.getBody();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
