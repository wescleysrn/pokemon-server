package br.com.pokemon.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.pokemon.controllers.PokemonControllerMockitoTest;
import br.com.pokemon.controllers.PokemonControllerResponseErrorHandlerIntegrationTest;
import br.com.pokemon.controllers.PokemonControllerTest;
import br.com.pokemon.mediators.OpenWeatherMediatorTest;
import br.com.pokemon.mediators.PokemonMediatorTest;

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
