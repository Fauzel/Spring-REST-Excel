package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByVencedor(Boolean isVencedor);
	
}
