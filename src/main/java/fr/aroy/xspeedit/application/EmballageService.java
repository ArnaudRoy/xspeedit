package fr.aroy.xspeedit.application;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;

/**
 * Service d'emballage d'articles dans des cartons
 * @author royar
 *
 */
public interface EmballageService {
	
	/**
	 * Emballe les articles dans des cartons
	 * @param chaineDArticle a emballer
	 */
	void emballer(Article[] chaineDArticle);

	/**
	 * Retourne les cartons à livrer
	 * @return Carton[] cartons a livrer
	 */
	Carton[] getCartonsALivrer();

}
