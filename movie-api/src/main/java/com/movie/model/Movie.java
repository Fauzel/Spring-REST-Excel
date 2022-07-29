package com.movie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private Integer ano;
	private String titulo;
	private String estudio;
	private String produtores;
	private Boolean vencedor;
	
	@Transient
	private List<String> produtoresList;
	
	@Transient
	private Integer tempoEntrePremiacao;
	
	@Transient
	private String produtorPremiado;
}
