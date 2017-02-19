package fr.aroy.xspeedit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;

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
	/**
	 * Transforme une Chaine de carton en Chaine de chiffres séparés par des "/"
	 * @param chaineDeCartons
	 * @return une chaine de cartons sous forme d'un string
	 */
	public static String transformChaineDeCartonsEnChaineDeChiffres(Carton[] chaineDeCartons) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		Stream<Carton> cartonStream = Arrays.stream(chaineDeCartons);
		cartonStream.forEach(carton -> {
			carton.getArticles().forEach(article -> {
				stringBuilder.append(article.getTaille());
			});
			stringBuilder.append("/");
		}
		);
		return stringBuilder.toString();
	}

}
