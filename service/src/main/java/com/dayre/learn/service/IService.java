package com.dayre.learn.service;

import java.util.List;

import com.dayre.beans.Hero;

public interface IService {

	public List<Hero> retrieveListHero(int numberOfHero);
	
	public void persistData(List<Hero> heroes);
}
