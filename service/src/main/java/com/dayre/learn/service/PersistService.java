package com.dayre.learn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dayre.beans.Hero;

public abstract class PersistService implements IService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistService.class);
	
	public PersistService() {
	}
	
	
	public void generateAndPersistData(int numberOfHero) {
		
		List<Hero> heroes = retrieveListHero(numberOfHero);
		
		for(Hero hero : heroes) {
			LOGGER.info(hero.toString());
		}
		
		persistData(heroes);
		
	}
	


}
