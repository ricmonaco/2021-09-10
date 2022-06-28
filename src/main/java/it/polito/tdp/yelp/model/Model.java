package it.polito.tdp.yelp.model;

import java.util.List;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	
	private YelpDao dao;
	
	public Model() {
		dao = new YelpDao();
	}
	
	public List<String> listaCity(){
		return this.dao.listaCity();
	}
	
}
