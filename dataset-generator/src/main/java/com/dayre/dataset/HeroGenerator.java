package com.dayre.dataset;

import java.util.concurrent.TimeUnit;

import com.dayre.beans.Hero;
import com.github.javafaker.Faker;

public class HeroGenerator {

	private static final Faker FAKER = Faker.instance();

	public static Hero getRandomHero() {
		Hero hero = new Hero();
		hero.setName(FAKER.leagueOfLegends().champion());
		hero.setLocation(FAKER.leagueOfLegends().location());
		hero.setQuote(FAKER.leagueOfLegends().quote());
		hero.setDate(FAKER.date().past(50, TimeUnit.DAYS));
		return hero;
	}
}
