package fr.aroy.xspeedit.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Entité espace de stockage pour contenir les cartons 
 * @author royar
 *
 */
public class EspaceDeStockage {

	/** Cartons stockés */
	private List<Carton> chaineDeCartons;
	
	/**
	 * Constructeur
	 */
	public EspaceDeStockage() {
		super();
		chaineDeCartons = new ArrayList<>();
	}
	
	/**
	 * Ajoute un carton
	 * @param carton a ajouter
	 */
	public void addCarton(Carton carton) {
		chaineDeCartons.add(carton);
	}
	
	/**
	 * Getter sur la chaine de cartons
	 * @return la chaine de cartons
	 */
	public List<Carton> getChaineDeCartons() {
		return chaineDeCartons;
	}
	
}
