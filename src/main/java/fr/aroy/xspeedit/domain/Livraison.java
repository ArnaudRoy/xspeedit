package fr.aroy.xspeedit.domain;

import java.util.Arrays;

/**
 * Entité livraison pour contenir des cartons sorti de l'espace de stockage
 * @author royar
 *
 */
public class Livraison {

	final Carton[] cartonsALivrer;
	
	/**
	 * Constructeur avec les cartons à livrer
	 * @param cartonsALivrer 
	 */
	public Livraison(Carton[] cartonsALivrer) {
		this.cartonsALivrer = cartonsALivrer;
	}
	
	/**
	 * Getter sur les carton à livrer
	 * @return Carton[]
	 */
	public Carton[] getCartonsALivrer() {
		return cartonsALivrer;
	}
	
	/**
	 * Calcule le taux de remplissage du carton
	 * @return le taux de remplissage
	 */
	public Double getTauxDeRemplissage() {

		return Arrays.stream(cartonsALivrer)
				.map(Carton::getTauxDeRemplissage)
				.mapToDouble(Double::doubleValue)
				.average().getAsDouble();
	}
 }
