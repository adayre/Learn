package com.dayre.dataset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.TemplateException;

public class Main {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args)  {
		Path tempDir;
		try {
			tempDir = Files.createTempDirectory("test_learn");
			LOGGER.debug("Datasets will be generated in the folder {}",tempDir);
			DatasetGenerator datasetGenerator = new DatasetGenerator(tempDir);
			datasetGenerator.generateDatasets(20,50);

		} catch (IOException | TemplateException e) {
			System.err.println(e);
		} finally {
			//Files.delete(tempDir);
		}
		
		
		
	}

}
