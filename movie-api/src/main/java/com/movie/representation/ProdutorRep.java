package com.movie.representation;

import com.movie.model.Movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ProdutorRep {

	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;

	public ProdutorRep(Movie movie) {
		this.setProducer(movie.getProdutorPremiado());
		this.setInterval(movie.getIntervalo());
		this.setPreviousWin(movie.getAno());
		this.setFollowingWin(movie.getAnoProximoFilme());
	}

}
