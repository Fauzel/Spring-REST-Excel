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
		
		System.out.println("Step 1");
		PlanilhaController planilhaController = new PlanilhaController();
		System.out.println("Step 2");
		MovieController movieController = new MovieController();
		System.out.println("Step 3");
//		movieController.saveAllMovies(planilhaController.movieList());
		
		planilhaController.imprimir(planilhaController.movieList());
		System.out.println("Step 4");
		
	}

}
