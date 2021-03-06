package fr.aroy.xspeedit.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Entité Carton.
 * Peut contenir des aarticles jusqu'a la capacité max 
 * @author royar
 *
 */
public class Carton {
	
	/** Capacité d'un carton*/
	public final static int CAPACITE_MAX = 10;

	/** Articles contenus dans le carton*/
	List<Article> articles = new ArrayList<>();
	
	/**
	 * @return les articles du carton
	 */
	public List<Article> getArticles() {
		return articles;
	}
	
	/**
	 * Ajoute un article au carton
	 * @param article a ajouter
	 */
	//TODO controler la capacité maximum du carton
	public void addArticle(Article article) {
		articles.add(article);
	}
	
	/**
	 * Retourne la capacité restante dans la carton
	 * @return la capacité restante dans le carton
	 */
	public int getCapaciteRestante() {
		int tailleOccupee = articles.stream()
				.map(Article::getTaille)
				.mapToInt(Integer::intValue)
				.sum();
		return CAPACITE_MAX - tailleOccupee;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("")
				.add(Class.class.getSimpleName())
				.add("[")
				.add("articles=");
		
		StringJoiner articlesSJ = new StringJoiner(",");
		this.articles.stream().forEach(article -> 
			articlesSJ.add(Integer.toString(article.getTaille())));
		
		sj.merge(articlesSJ);
		sj.add("]");
		return sj.toString();
	}
}
