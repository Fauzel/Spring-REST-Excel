package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.representation.IntervaloRep;
import com.movie.service.MovieService;

@RestController
//@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieService = new MovieService();

	@GetMapping("/movies/intervaloDePremios")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public IntervaloRep intervaloDePremios() {
		return movieService.intervaloDePremios();
	}
}
