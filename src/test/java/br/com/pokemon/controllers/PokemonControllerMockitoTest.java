package br.com.pokemon.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pokemon.dtos.PokemonByCityDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;	

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void should_return_default_lisbon_weather() throws Exception {
    	ResultActions resultActions = 
	        this.mockMvc.perform(get("/api/pokemonchallenge/pokemons/{city}", "Lisbon"))
	                    .andDo(print())
	                    .andExpect(status().isOk());
    	MvcResult result = resultActions.andReturn();
    	String contentAsString = result.getResponse().getContentAsString();
    	PokemonByCityDTO response = objectMapper.readValue(contentAsString, PokemonByCityDTO.class);
    	assertThat(response.getCityWeather().getCityName(), is("Lisbon"));
    }    
    
}
