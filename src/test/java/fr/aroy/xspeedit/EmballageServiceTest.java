package fr.aroy.xspeedit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.service.EmballageBasique;
import fr.aroy.xspeedit.service.EmballageService;
import fr.aroy.xspeedit.service.EmballageUtils;

public class EmballageServiceTest {

	@Test
	public void test() {
		EmballageService emballageService = new EmballageBasique();
		
		Article[] articles = EmballageUtils.transformChaineDeChiffresEnChaineDArticles("163841689525773");
		
		emballageService.emballer(articles);
		Carton[] chaineDeCartons= emballageService.getCartonsALivrer();

		assertThat(chaineDeCartons, arrayWithSize(equalTo(10)));
		
		String chaineDeCartonEnString = EmballageUtils.transformChaineDeCartonsEnChaineDeChiffres(chaineDeCartons);
		assertThat(chaineDeCartonEnString, equalTo("163/8/41/6/8/9/52/5/7/73"));
	}

}
