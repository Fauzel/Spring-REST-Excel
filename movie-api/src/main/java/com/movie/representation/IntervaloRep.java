package com.movie.representation;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class IntervaloRep {

	private List<ProdutorRep> min;
	private List<ProdutorRep> max;
	
	public IntervaloRep(List<ProdutorRep> minList, List<ProdutorRep> maxList) {
		this.setMin(minList);
		this.setMax(maxList);
	}
}
