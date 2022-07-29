package com.movie.representation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ProdutorRep {

	private String produtor;
	private Integer tempoEntrePremiacao;
	
	public ProdutorRep(String produtor, Integer tempoEntrePremiacao) {
		this.setProdutor(produtor);
		this.setTempoEntrePremiacao(tempoEntrePremiacao);
	}
}
