package com.movie;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.movie.controller.MovieController;
import com.movie.controller.PlanilhaController;
import com.movie.model.Movie;
import com.movie.repository.MovieRepository;

@SpringBootApplication
public class MovieApiApplication {
	
	public static void main(String[] args) throws IOException, InvalidFormatException {
		SpringApplication.run(MovieApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			MovieController movieController = ctx.getBean("movieController", MovieController.class);
			PlanilhaController planilhaController = new PlanilhaController();
			System.out.println("Teste");
			
			movieController.saveAllMovies(planilhaController.movieList());
		};
	}

}
