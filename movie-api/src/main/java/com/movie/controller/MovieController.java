package com.movie.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.representation.ProdutorRep;
import com.movie.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieService = new MovieService();
	
	@GetMapping
	public List<Movie> listMovies() throws InvalidFormatException, IOException {
		return movieService.listAllMovies();
	}

	@GetMapping(path = "/maiorIntervalo")
	public ProdutorRep maiorIntervalo() {
		return movieService.produtorMaiorIntervalo();
	}
	
	@GetMapping(path = "/menorIntervalo")
	public ProdutorRep menorIntervalo() {
		return movieService.produtorMenorIntervalo();
	}
}
