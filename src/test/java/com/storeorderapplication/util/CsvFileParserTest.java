package com.storeorderapplication.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import com.storeorderapplication.util.CsvFileParser;

@ExtendWith(SpringExtension.class)
class CsvFileParserTest {

	@Test
	@DisplayName(value = "Test parseFile Method")
	void parseFile() throws FileNotFoundException, IOException{
		MultipartFile file = new MockMultipartFile("TestCsvFile.csv", new FileInputStream(new File("src/test/resources/TestCsvFile.csv")));
		System.out.println(new CsvFileParser().parseFile(file).size());
		Assertions.assertEquals(new CsvFileParser().parseFile(file).size(),1);
	}


}
