package fr.aroy.xspeedit.domain;

import java.util.Set;

public class EspaceDeStockage {

	public Set<Carton> chaineDeCartons;
	
	public EspaceDeStockage() {
		super();
	}
	
	public void addCarton(Carton carton) {
		chaineDeCartons.add(carton);
	}
	
	public Set<Carton> getChaineDeCartons() {
		return chaineDeCartons;
	}
	
}
