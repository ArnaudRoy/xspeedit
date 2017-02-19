package fr.aroy.xspeedit.application;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;

/**
 * Utilitaire pour l'emballage
 * @author royar
 *
 */
public class EmballageUtils {

	/**
	 * Transforme une Chaine de chiffre [1-9] en Chaine d'articles de tailles correspondantes
	 * @param chaineDeChiffres 
	 * @return une chaine d'articles
	 */
	public static Article[] transformChaineDeChiffresEnChaineDArticles(String chaineDeChiffres) {

		Stream<Article> articlesStream= chaineDeChiffres.chars()
				.mapToObj(tailleArticle -> (char) tailleArticle)
				.map(String::valueOf)
				.filter(tailleArticle -> tailleArticle.matches("[1-9]+"))
				.map(Integer::valueOf)
				.map(Article::new);

		return articlesStream.toArray(size -> new Article[size]);
	}
	/**
	 * Transforme une chaine de cartons en chaine de chiffres séparés par des "/"
	 * @param chaineDeCartons
	 * @return une chaine de cartons sous forme d'un string
	 */
	public static String transformChaineDeCartonsEnChaineDeChiffres(Carton[] chaineDeCartons) {
		
		StringJoiner cartonsStringJoiner = new StringJoiner("/");
		
		Stream<Carton> cartonStream = Arrays.stream(chaineDeCartons);
		cartonStream.forEach(carton -> {
			StringJoiner articleStringJoiner = new StringJoiner("");
			carton.getArticles()
				.forEach(article -> 
					articleStringJoiner.add(Integer.toString(article.getTaille())));
			cartonsStringJoiner.merge(articleStringJoiner);
		}
		);
		return cartonsStringJoiner.toString();
	}

}
