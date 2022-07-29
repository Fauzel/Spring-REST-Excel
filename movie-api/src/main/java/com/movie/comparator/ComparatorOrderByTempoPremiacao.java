package com.movie.comparator;

import java.util.Comparator;

import com.movie.model.Movie;

public class ComparatorOrderByTempoPremiacao implements Comparator<Movie>{

	@Override
	public int compare(Movie movie1, Movie movie2) {
		if(movie1.getTempoEntrePremiacao() > movie2.getTempoEntrePremiacao()) {
			return 1;
		}
		return -1;
	}

}
