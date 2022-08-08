package com.movie.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;

@Service
public class PlanilhaService {

	public List<Movie> movieList() throws IOException {

		List<Movie> movies = new ArrayList<Movie>();

		InputStream resource = new ClassPathResource("static/movielist.csv").getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource));

		String linha = reader.readLine();

		while (linha != null) {
			linha = reader.readLine();

			if (linha != null) {
				String[] movieStr = new String[5];
				movieStr = linha.replaceAll(", ", "; ").split(",");

				movies.add(new Movie(Integer.parseInt(movieStr[0]), movieStr[1], movieStr[2].replaceAll("; ", ", "),
						movieStr[3].replaceAll("; ", ", "), (movieStr.length < 5 ? Boolean.FALSE : Boolean.TRUE)));
			}
		}

		return movies;
	}
}
