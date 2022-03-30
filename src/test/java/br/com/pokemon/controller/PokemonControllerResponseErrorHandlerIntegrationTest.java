package br.com.pokemon.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.pokemon.exception.CityNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerResponseErrorHandlerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;	

    @Test
    public void should_return_not_found() throws Exception {
        this.mockMvc.perform(get("/api/pokemonchallenge/pokemons/{city}", "DJSHDJDHJSHDSJ"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(result -> 
                    	assertTrue(result.getResolvedException() instanceof CityNotFoundException)
                    )
                    .andExpect(result -> 
                    	assertEquals("The city entered was not found in the Weather API", 
                    			result.getResponse().getErrorMessage())
                    );
    }
	
}
