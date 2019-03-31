package com.dayre.dataset;

import com.dayre.beans.Beer;
import com.github.javafaker.Faker;

public class BeerGenerator {

	private static final Faker FAKER = Faker.instance();
	public static Beer getRandomBeer() {
		return new Beer(FAKER.beer().name(),FAKER.beer().style(),FAKER.beer().hop(),FAKER.beer().yeast(),FAKER.beer().malt());
		
	}
}
