package com.dayre.learn;

import com.dayre.learn.service.FilePersistService;
import com.dayre.learn.service.PersistService;

public class Main {

	public static void main(String[] args) {
		
		PersistService service =new FilePersistService(50);
		
		service.persistHeroFrom("Noxus");
		
		service.persistSpecificHero("Annie");
		
		
				
				
	}

}
