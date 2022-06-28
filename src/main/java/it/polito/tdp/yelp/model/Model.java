package it.polito.tdp.yelp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	
	private YelpDao dao;
	private Map<String, Business> idMapVertici;
	private List<Business> listaVertici;
	private Graph<Business, DefaultWeightedEdge> grafo;
	private List<Adiacenza> listaAdiacenze;
	
	public Model() {
		dao = new YelpDao();
	}
	
	public void creaGrafo(String city) {
		this.grafo = new SimpleWeightedGraph<Business, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		this.idMapVertici = new HashMap<String, Business>();
		listaVertici = new ArrayList<Business>(this.dao.getBusinessPerCity(city));
		for(Business b : listaVertici) {
			idMapVertici.put(b.getBusinessId(), b);
		}
		
		//Aggiungo i vertici
		Graphs.addAllVertices(this.grafo, listaVertici);
		
		//Aggiungo gli archi 
		listaAdiacenze = new ArrayList<Adiacenza>(this.dao.listaArchi(city));
		for(Adiacenza a : listaAdiacenze) {
			Graphs.addEdgeWithVertices(this.grafo, idMapVertici.get(a.getB1()), idMapVertici.get(a.getB2()), a.getDistanza());
		}
		
	}
	
	public List<String> listaCity(){
		return this.dao.listaCity();
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
}
