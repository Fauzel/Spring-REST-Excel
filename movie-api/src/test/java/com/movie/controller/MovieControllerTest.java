package com.movie.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.movie.MovieApiApplicationTests;

public class MovieControllerTest extends MovieApiApplicationTests{

	private MockMvc mockMvc;
	
	@Autowired
	private MovieController movieController;
	
	@Before
	public void setUp() {
		this.mockMvc =MockMvcBuilders.standaloneSetup(movieController).build();
	}
	
	@Test
	public void mostrarProdutorComMenorIntevaloPremiacao_RetornarStatus202() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/intervaloDePremios")
				                 .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isAccepted());
	}
}
