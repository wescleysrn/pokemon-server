package br.com.pokemon.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigurationOpenApi {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Pokemon Challenge Application API").description(
                        "This is the Pokemon Challenge API documentation. The purpose of the api is to provide endpoints to "
                        + "determine the weather in a certain city and also to search for Pokemons according to the type of "
                        + "Pokemon you want, as well as retrieve the image of a certain Pokemon."));
    }
	
}
