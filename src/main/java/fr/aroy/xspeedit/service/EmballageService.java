package fr.aroy.xspeedit.service;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;

public interface EmballageService {
	
	void emballer(Article[] chaineDArticle);

	Carton[] getCartonsALivrer();
}
