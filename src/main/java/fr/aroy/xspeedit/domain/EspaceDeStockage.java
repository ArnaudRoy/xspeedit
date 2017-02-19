package fr.aroy.xspeedit.domain;

import java.util.List;

public class EspaceDeStockage {

	private List<Carton> chaineDeCartons;
	
	public EspaceDeStockage() {
		super();
	}
	
	public void addCarton(Carton carton) {
		chaineDeCartons.add(carton);
	}
	
	public List<Carton> getChaineDeCartons() {
		return chaineDeCartons;
	}
	
}
