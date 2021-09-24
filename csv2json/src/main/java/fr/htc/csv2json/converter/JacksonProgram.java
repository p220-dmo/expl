package fr.htc.csv2json.converter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class JacksonProgram {

	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File input = new File("data.csv");
		File output = new File("data.json");
		
		List<Map<?, ?>> csvLinesMap = readObjectsFromCsv(input);
		
		for (Map<?, ?> lineMap : csvLinesMap) {
			csvMap2Json(lineMap);
		}
		
	}

	public static void csvMap2Json(Map<?, ?> lineMap) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(lineMap));
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static List<Map<?, ?>> readObjectsFromCsv(File file) throws IOException {
		CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		MappingIterator<Map<?, ?>> mappingIterator = csvMapper.readerFor(Map.class).with(bootstrap).readValues(file);

		return mappingIterator.readAll();
	}
	
	
	

}