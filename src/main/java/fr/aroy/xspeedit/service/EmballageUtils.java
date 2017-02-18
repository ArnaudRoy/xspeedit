package fr.aroy.xspeedit.service;

import java.util.ArrayList;
import java.util.List;

import fr.aroy.xspeedit.domain.Article;

public class EmballageUtils {

	/**
	 * Transforme une Chaine de chiffre [1-9] en Chaine d'articles de tailles correspondantes
	 * @param chaineDeChiffres 
	 * @return une chaine d'articles
	 */
	public static Article[] transformChaineDeChiffresEnChaineDArticles(String chaineDeChiffres) {

		List<Article> chaineDArticles = new ArrayList<>(chaineDeChiffres.length());

		chaineDeChiffres.chars()
				.mapToObj(tailleArticle -> (char) tailleArticle)
				.map(String::valueOf)
				.filter(tailleArticle -> tailleArticle.matches("[1-9]+"))
				.map(Integer::valueOf)
				.forEach(tailleArticle->{
					chaineDArticles.add(new Article(tailleArticle));
				});

		return chaineDArticles.toArray(new Article[chaineDArticles.size()]);
	}

}
