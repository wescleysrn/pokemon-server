package br.com.pokemon.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.pokemon.controller.PokemonControllerMockitoTest;
import br.com.pokemon.controller.PokemonControllerResponseErrorHandlerIntegrationTest;
import br.com.pokemon.controller.PokemonControllerTest;
import br.com.pokemon.mediator.OpenWeatherMediatorTest;
import br.com.pokemon.mediator.PokemonMediatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	OpenWeatherMediatorTest.class,
	PokemonMediatorTest.class,
	PokemonControllerMockitoTest.class,
	PokemonControllerResponseErrorHandlerIntegrationTest.class,
	PokemonControllerTest.class
})
public class PokemonTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
	
}
