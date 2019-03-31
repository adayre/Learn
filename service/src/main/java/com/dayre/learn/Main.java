package com.dayre.learn;

import com.dayre.beans.Hero;
import com.dayre.dataset.HeroGenerator;
import com.dayre.learn.service.DaoElement;
import com.dayre.learn.service.DataService;
import com.dayre.learn.service.FileDaoElement;

public class Main {

	public static void main(String[] args) {

		DaoElement<Hero> fileDaoElement = new FileDaoElement();
		DataService<Hero> heroService = new DataService<>(fileDaoElement);
		
		heroService.addElement(HeroGenerator.getRandomHero());
		heroService.addElement(HeroGenerator.getRandomHero());
		
		
		
		

	}

}
