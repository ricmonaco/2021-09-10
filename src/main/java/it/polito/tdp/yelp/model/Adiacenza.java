package it.polito.tdp.yelp.model;

import com.javadocmd.simplelatlng.LatLng;

public class Adiacenza {
	
	private String b1;
	private String b2;
	private double distanza;
	public Adiacenza(String b1, String b2, double distanza) {
		super();
		this.b1 = b1;
		this.b2 = b2;
		this.distanza = distanza;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = b1;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = b2;
	}
	public double getDistanza() {
		return distanza;
	}
	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}
	

}
