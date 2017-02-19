package fr.aroy.xspeedit.application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;

import fr.aroy.xspeedit.application.EmballageService;
import fr.aroy.xspeedit.application.EmballageServiceBasique;
import fr.aroy.xspeedit.application.EmballageUtils;
import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.infrastructure.InMemoryEspaceDeStockageRepository;

public class EmballageServiceTest {

	EspaceDeStockageRepository espaceDeStockageRepository = new InMemoryEspaceDeStockageRepository(); 
	
	@Test
	public void test() {
		espaceDeStockageRepository.setEspaceDeStockage(new EspaceDeStockage());
		
		EmballageService emballageService = new EmballageServiceBasique(espaceDeStockageRepository);
		
		Article[] articles = EmballageUtils.transformChaineDeChiffresEnChaineDArticles("163841689525773");
		
		emballageService.emballer(articles);
		Carton[] cartonsALivrer= emballageService.getCartonsALivrer();

		assertThat(cartonsALivrer, arrayWithSize(equalTo(10)));
		
		String chaineDeCartonEnString = EmballageUtils.transformChaineDeCartonsEnChaineDeChiffres(cartonsALivrer);
		assertThat(chaineDeCartonEnString, equalTo("163/8/41/6/8/9/52/5/7/73"));
	}

}
