package com.dayre.beans;

public class Beer extends Element {

	private String name;
	private String style;
	private String hop;
	private String yeast;
	private String malt;
	
	public Beer(String name, String style, String hop, String yeast, String malt) {
		super();
		this.name = name;
		this.style = style;
		this.hop = hop;
		this.yeast = yeast;
		this.malt = malt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getHop() {
		return hop;
	}
	public void setHop(String hop) {
		this.hop = hop;
	}
	public String getYeast() {
		return yeast;
	}
	public void setYeast(String yeast) {
		this.yeast = yeast;
	}
	public String getMalt() {
		return malt;
	}
	public void setMalt(String malt) {
		this.malt = malt;
	}
	
	
}
