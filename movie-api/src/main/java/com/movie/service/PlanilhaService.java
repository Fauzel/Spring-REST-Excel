package com.movie.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import lombok.Cleanup;

@Service
public class PlanilhaService {

	public List<Movie> movieList() throws IOException, InvalidFormatException {

		List<Movie> movies = new ArrayList<Movie>();

		@Cleanup
		FileInputStream file = new FileInputStream("src/main/resources/static/movielist.xlsx");

//		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = new XSSFWorkbook(file).getSheetAt(0);

		@SuppressWarnings("unchecked")
		List<Row> rows = (List<Row>) toList(sheet.iterator());

		rows.remove(0);

		for (Row row : rows) {

			List<Cell> cells = (List<Cell>) toList(row.cellIterator());
			Movie movie = new Movie();

			for (Cell cell : cells) {

				movie.setAno((int) cells.get(0).getNumericCellValue());
				movie.setTitulo(cells.get(1).getStringCellValue());
				movie.setEstudio(cells.get(2).getStringCellValue());
				movie.setProdutores(cells.get(3).getStringCellValue());

				if (cells.size() != 5) {
					movie.setVencedor(Boolean.FALSE);
				} else {
					movie.setVencedor(cells.get(4).getStringCellValue().toLowerCase().equals("yes") ? Boolean.TRUE
							: Boolean.FALSE);
				}
			}

			movies.add(movie);
		}

		return movies;
	}

	public List<Movie> movieListCSV() throws IOException, InvalidFormatException {

		List<Movie> movies = new ArrayList<Movie>();

		Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/static/movielist.csv"));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

		List<String[]> moviesStr = csvReader.readAll();
		for (String[] movieStr : moviesStr) {

			movies.add(new Movie(Integer.parseInt(movieStr[0]), movieStr[1], movieStr[2], movieStr[3],
					             (movieStr[4].toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE)));

		}

		return movies;
	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
	}

	public void imprimir(List<Movie> movies) {
		movies.forEach(System.out::print);
	}
}
