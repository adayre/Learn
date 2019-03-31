package com.dayre.learn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dayre.beans.Element;

public class DataService<T extends Element> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataService.class);
	
	
	private List<T> dataList ;
	private DaoElement<T> dao;
	
	public DataService(DaoElement<T> daoElement) {
		
		this.dao=daoElement;
		this.dataList =  daoElement.selectAllElements();
	}
	

	public void addElement(T element) {
		if (!dataList.contains(element)) {
			dao.persistElement(element);
		}
		
	}

	public void addElements(List<T> elements) {
		for(T element : elements) {
			this.addElement(element);
		}
	}
	
	public void removeElement(T element) {
		if (dataList.contains(element)) {
			dao.deleteElement(element);
			dataList.remove(element);
		}
	}
	
	public void removeElements(List<T> elements) {
		for(T element : elements) {
			this.addElement(element);
		}
	}
	
	public void displayElementFromData() {
		for(T data : dataList) {
			LOGGER.info(data.toString());
		}
	}
	

	


}
