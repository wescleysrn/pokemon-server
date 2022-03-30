package br.com.pokemon.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PokemonAppConfig {

	@Bean(name = "appRestTemplate")
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = 
				builder.additionalMessageConverters(
						new MappingJackson2HttpMessageConverter(), new StringHttpMessageConverter()
				)
				.defaultHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
				.build();
		return restTemplate;
	}
	
}
