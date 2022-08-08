package com.movie;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.movie.service.MovieService;
import com.movie.service.PlanilhaService;

@SpringBootApplication
public class MovieApiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MovieApiApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			MovieService movieService = ctx.getBean("movieService", MovieService.class);
			PlanilhaService planilhaService = new PlanilhaService();

			movieService.saveAllMovies(planilhaService.movieList());

		};
	}

}
