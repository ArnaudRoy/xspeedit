package fr.aroy.xspeedit.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Entité espace de stockage pour contenir les cartons 
 * @author royar
 *
 */
/**
 * @author royar
 *
 */
public class EspaceDeStockage implements Collection<Carton> {

	/** Nombre maximum de cartons dans l'espace avant une livraison */
	public final static int TAILLE_DE_LESPACE = 10;
	
	/** Cartons stockés */
	private Collection<Carton> chaineDeCartons;
	
	/** Livraisons effectuées */
	private List<Livraison> livraisons;
	
	/**
	 * Constructeur
	 */
	public EspaceDeStockage() {
		super();
		chaineDeCartons = new ArrayList<>();
	}
	
	/**
	 * @return le nombre de carton dans l'espace de stockage
	 */
	public int size() {
		return chaineDeCartons.size();
	}

	/**
	 * Ajoute un carton
	 * @param carton a ajouter
	 */
	public boolean add(Carton carton) {
		return chaineDeCartons.add(carton);
	}

	@Override
	public Iterator<Carton> iterator() {
		return chaineDeCartons.iterator();
	}

	/**
	 * @return
	 * @see java.util.Collection#isEmpty()
	 */
	public boolean isEmpty() {
		return chaineDeCartons.isEmpty();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return chaineDeCartons.contains(o);
	}

	/**
	 * @return
	 * @see java.util.Collection#toArray()
	 */
	public Object[] toArray() {
		return chaineDeCartons.toArray();
	}

	/**
	 * @param a
	 * @return
	 * @see java.util.Collection#toArray(java.lang.Object[])
	 */
	public <T> T[] toArray(T[] a) {
		return chaineDeCartons.toArray(a);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return chaineDeCartons.remove(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return chaineDeCartons.containsAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends Carton> c) {
		return chaineDeCartons.addAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return chaineDeCartons.removeAll(c);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return chaineDeCartons.retainAll(c);
	}

	/**
	 * 
	 * @see java.util.Collection#clear()
	 */
	public void clear() {
		chaineDeCartons.clear();
	}
}
