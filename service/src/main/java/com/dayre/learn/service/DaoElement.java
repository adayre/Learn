package com.dayre.learn.service;

import java.util.List;

import com.dayre.beans.Element;

public interface DaoElement<T extends Element> {

	
	List<T> selectAllElements();
	
	T selectSpecificElement();
	
	void persistElement(T element);
	
	
	void deleteElement(T element);
	
	
	void updateElement(T element);

}
