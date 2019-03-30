package com.dayre.dataset;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dayre.beans.Hero;
import com.github.javafaker.Faker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DatasetGenerator {

	private static final String dataFileName = "./heroes%d02.xml";
	private Configuration cfg ;
	private Faker faker;
	private Path dataDirectory;
	private Template tpl;
	public DatasetGenerator(Path dataDirectory) {
		this.cfg = ConfigurationFactory.getConfiguration();
		this.faker = Faker.instance();
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
			heroes.add(generateRandomHero());
		}
				
		datamodel.put("heroes", heroes);
		
		
		String datas="";
		try( Writer fileWriter = new FileWriter(resultFile.toFile())) {
			tpl.process(datamodel, fileWriter);
		}			
	}



	private Hero generateRandomHero() {
		Hero hero = new Hero();
		hero.setName(this.faker.leagueOfLegends().champion());
		hero.setLocation(this.faker.leagueOfLegends().location());
		hero.setQuote(this.faker.leagueOfLegends().quote());
		hero.setDate(this.faker.date().past(50, TimeUnit.DAYS));
		return hero;
	}
	
	
	
}
