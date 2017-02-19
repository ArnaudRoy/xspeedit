package fr.aroy.xspeedit.domain;

import java.util.ArrayList;
import java.util.List;

public class EspaceDeStockage {

	private List<Carton> chaineDeCartons;
	
	public EspaceDeStockage() {
		super();
		chaineDeCartons = new ArrayList<>();
	}
	
	public void addCarton(Carton carton) {
		chaineDeCartons.add(carton);
	}
	
	public List<Carton> getChaineDeCartons() {
		return chaineDeCartons;
	}
	
}
