package com.movie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
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
	private Integer intervalo;
	
	@Transient
	private String produtorPremiado;
	
	@Transient
	private Integer anoProximoFilme;
	
	public Movie(Integer ano, String titulo, String estudio, String produtores, Boolean vencedor) {
		this.setAno(ano);
		this.setTitulo(titulo);
		this.setEstudio(estudio);
		this.setProdutores(produtores);
		this.setVencedor(vencedor);
	}
}
