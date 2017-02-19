package fr.aroy.xspeedit.domain;

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
 }
