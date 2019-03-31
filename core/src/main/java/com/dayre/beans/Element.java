package com.dayre.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Element {
	
	private static AtomicInteger idGen = new AtomicInteger();
	private int id;
	private Date creationDate;
	
	
	public Element() {
		this.id=idGen.getAndIncrement();
		this.creationDate = new Date();
	}
	
	public Element(int id, Date date) {
		this.id = id;
		this.creationDate = date;
	}


	public int getId() {
		return id;
	}


	protected void setId(int id) {
		this.id = id;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	protected void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public String toString() {
		String date = new SimpleDateFormat().format(this.creationDate);
		return "Element [id=" + id + ", creationDate=" + date + "]";
	}
	
	
	
	
}
