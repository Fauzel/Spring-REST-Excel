package com.movie;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movie.controller.MovieController;
import com.movie.controller.PlanilhaController;
import com.movie.model.Movie;

@SpringBootApplication
public class MovieApiApplication {
	
	public static void main(String[] args) throws IOException, InvalidFormatException {
		SpringApplication.run(MovieApiApplication.class, args);
		
		PlanilhaController planilhaController = new PlanilhaController();
		MovieController movieController = new MovieController();
		
		movieController.saveAllMovies(planilhaController.movieList());
				
		
	}

}
