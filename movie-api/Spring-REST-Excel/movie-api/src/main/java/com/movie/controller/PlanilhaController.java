package com.movie.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.movie.model.Movie;

import lombok.Cleanup;

public class PlanilhaController {

	public List<Movie> movieList() throws IOException, InvalidFormatException {
		
		List<Movie> movies = new ArrayList<Movie>();

		@Cleanup FileInputStream file = new FileInputStream("src/main/resources/static/movielist.xlsx");
		
		Workbook workbook = new XSSFWorkbook(file);

		Sheet sheet = workbook.getSheetAt(0);
		
		@SuppressWarnings("unchecked")
		List<Row> rows = (List<Row>) toList(sheet.iterator());
		
		rows.remove(0);
		
		rows.forEach(row -> {
			
			@SuppressWarnings("unchecked")
			List<Cell> cells = (List<Cell>) toList(row.cellIterator());
			
			Movie movie = Movie.builder()
					.ano((int) cells.get(0).getNumericCellValue())
					.titulo(cells.get(1).getStringCellValue())
					.estudio(cells.get(2).getStringCellValue())
					.produtores(cells.get(3).getStringCellValue())
					.vencedor(cells.size() < 5 ? "" : cells.get(4).getStringCellValue())
					.build();
			
			movies.add(movie);
			
		});

		return movies;
	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}
	
	public void imprimir(List<Movie> movies) {
		movies.forEach(System.out::print);
	}	

}
