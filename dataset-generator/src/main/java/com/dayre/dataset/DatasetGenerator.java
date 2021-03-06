package com.dayre.dataset;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dayre.beans.Hero;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DatasetGenerator {

	private static final String dataFileName = "./heroes%d02.xml";
	private Configuration cfg ;
	private Path dataDirectory;
	public DatasetGenerator(Path dataDirectory) {
		this.cfg = ConfigurationFactory.getConfiguration();
		this.dataDirectory=dataDirectory;
		
		
	}
	
	
	public void generateDatasets(int numberOfDatasets, int numberOfElementInDataset) throws IOException, TemplateException {
		
		for (int i =0; i<numberOfDatasets;i++) {
			String filename = String.format(dataFileName, i);
			generateDataset(numberOfElementInDataset,dataDirectory.resolve(filename));
		}
	}
	
	private void generateDataset(int numberOfElement, Path resultFile) throws IOException, TemplateException{
		Map<String,Object> datamodel = new HashMap<>();
		Template tpl = cfg.getTemplate("heroes.tpl");
		List<Hero> heroes = new ArrayList<>();
		for (int i =0; i<numberOfElement;i++) {
			heroes.add(HeroGenerator.getRandomHero());
		}
				
		datamodel.put("heroes", heroes);
		
		try( Writer fileWriter = new FileWriter(resultFile.toFile())) {
			tpl.process(datamodel, fileWriter);
		}			
	}




	
	
	
}
