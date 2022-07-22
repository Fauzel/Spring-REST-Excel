package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;

	@GetMapping
	public List<Movie> listMovies() {
		return movieRepository.findAll();
	}
	
	public void saveAllMovies(List<Movie> movies) {
		movies.forEach(movie ->{
			
			movieRepository.save(movie);
			System.out.println(movie.getTitulo());
		});
	}
}
