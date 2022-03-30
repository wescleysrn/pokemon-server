package br.com.pokemon.mediator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.pokemon.dto.openweather.CityWeatherDTO;
import br.com.pokemon.mediators.OpenWeatherMediator;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OpenWeatherMediatorTest {

	@Autowired
	OpenWeatherMediator openWeatherMediator;
	
	@Test
	public void getWeatherByCityNameTest() {
		CityWeatherDTO cityWeatherDTO;
		try {
			cityWeatherDTO = openWeatherMediator.getWeatherByCityName("London");
			assertThat(cityWeatherDTO.getCityName(), is("London"));
		} catch (Exception e) {
			assertThat(Boolean.TRUE, is(Boolean.FALSE));
		}		
	}
	
}
