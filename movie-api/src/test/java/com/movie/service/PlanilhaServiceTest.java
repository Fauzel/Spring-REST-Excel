package com.movie.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.MovieApiApplicationTests;
import com.movie.model.Movie;

import org.junit.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class PlanilhaServiceTest extends MovieApiApplicationTests {

	private List<Movie> movies = new ArrayList<>();
	
	@Autowired
	PlanilhaService planilhaService = new PlanilhaService();
	
	@BeforeAll
	public void iniciar() throws IOException {		
		movies.addAll(planilhaService.movieList());
	}
	
	@Test
	public void validarLeituraEmPlanilha_retornarUmaListaNotEmpty() {
		Assert.assertFalse(movies.isEmpty());	
		
	}
	
	@Test
	public void carregarPlanilhaParaBancoDadosH2_retornarPrimeiroRegistroDoBancoH2() throws IOException {
		MovieService movieService = new MovieService();
		movieService.saveAllMovies(planilhaService.movieList());
		
		Assert.assertFalse(movieService.listAllMovies().isEmpty());

	}
}
