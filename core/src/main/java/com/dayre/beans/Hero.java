package com.dayre.beans;

import java.util.Date;

public class Hero {

	
	private String name;
	private String quote;
	private String location;
	private Date date;
	
	public Hero() {
		
	}
	
	public Hero(String name, String quote, String location, Date date) {
		super();
		this.name = name;
		this.quote = quote;
		this.location = location;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", quote=" + quote + ", location=" + location + ", date=" + date + "]";
	}
	
	
}
