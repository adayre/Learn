package com.dayre.learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dayre.beans.Hero;

public abstract class PersistService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistService.class);
	
	
	private List<Hero> heroes ;
	public PersistService(int numberOfHero) {
		heroes = retrieveListHero(numberOfHero);
	}
	
	protected abstract List<Hero>  retrieveListHero(int numberOfHero);
	
	public List<Hero> getHeroes() {
		return heroes;
	}



	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}

	
	public void displayListHero() {
		for(Hero hero : heroes) {
			LOGGER.info(hero.toString());
		}
	}
	
	
	public void persistHeroFrom(String location) {
		
	
		persistData(heroes.stream().filter(hero -> hero.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList()));
		
	}
	
	
	public void persistSpecificHero(String name) {
		
		
		persistData(heroes.stream().filter(hero -> hero.getLocation().equalsIgnoreCase(name)).collect(Collectors.toList()));
		
	}
	
	protected abstract void persistData(List<Hero> heroes);
	


}
