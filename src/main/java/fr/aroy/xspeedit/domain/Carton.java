package fr.aroy.xspeedit.domain;

import java.util.ArrayList;
import java.util.List;

public class Carton {
	
	public final static int CAPACITE_MAX = 10;

	List<Article> articles = new ArrayList<>();
	
	public List<Article> getArticles() {
		return articles;
	}
	
	//TODO controler la capacité maximum du carton
	public void addArticle(Article article) {
		articles.add(article);
	}
	
	public int getCapaciteRestante() {
		int tailleOccupee = articles.stream()
				.map(Article::getTaille)
				.mapToInt(Integer::intValue)
				.sum();
		return CAPACITE_MAX - tailleOccupee;
	}
}
