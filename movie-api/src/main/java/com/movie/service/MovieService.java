package com.movie.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.comparator.ComparatorOrderByTempoPremiacao;
import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import com.movie.representation.ProdutorRep;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public void saveAllMovies(List<Movie> movies) {
		ajustarProdutoresList(movies);
		movieRepository.saveAll(movies);
	}

	public List<Movie> listAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		ajustarProdutoresList(movies);

		return movieRepository.findAll();
	}

	public ProdutorRep produtorMaiorIntervalo() {
		List<Movie> movies = filmesPremiados();
		Collections.sort(movies, new ComparatorOrderByTempoPremiacao());
		Movie movie = movies.get(movies.size() - 1);
		ProdutorRep produtor = new ProdutorRep(movie.getProdutorPremiado(), movie.getTempoEntrePremiacao());

		return produtor;
	}

	public ProdutorRep produtorMenorIntervalo() {
		List<Movie> movies = filmesPremiados();
		Collections.sort(movies, new ComparatorOrderByTempoPremiacao());
		Movie movie = movies.get(0);
		ProdutorRep produtor = new ProdutorRep(movie.getProdutorPremiado(), movie.getTempoEntrePremiacao());

		return produtor;
	}

	private List<Movie> filmesPremiados() {

		List<Movie> lista1 = movieRepository.findByVencedor(Boolean.TRUE);
		ajustarProdutoresList(lista1);

		List<Movie> lista2 = lista1;
		List<Movie> premiados = new ArrayList<>();

		for (Movie movie1 : lista1) {
			for (String produtor : movie1.getProdutoresList()) {

				for (Movie movie2 : lista2) {
					if (movie2.getProdutoresList().contains(produtor) && movie1.getID() != movie2.getID()
							&& !premiados.contains(movie2)) {
						movie1.setTempoEntrePremiacao(movie2.getAno() - movie1.getAno());
						movie1.setProdutorPremiado(produtor);
						premiados.add(movie1);
					}
				}
			}

		}

		return premiados;
	}

	private List<Movie> ajustarProdutoresList(List<Movie> movies) {

		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			movie.setProdutoresList(Arrays.asList(movie.getProdutores().split(", | and ")));
			movies.set(i, movie);
		}
		return movies;
	}

}
