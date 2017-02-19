package fr.aroy.xspeedit.application;

import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeCartonsEnChaineDeChiffres;
import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeChiffresEnChaineDArticles;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matchers;
import org.junit.Test;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.infrastructure.InMemoryEspaceDeStockageRepository;

public class OptimiseEmballageServiceTest {

	EspaceDeStockageRepository espaceDeStockageRepository = new InMemoryEspaceDeStockageRepository(); 
	
	@Test
	public void testEmballageOptimiseEstMeilleQueEmballageBasique() {
		espaceDeStockageRepository.saveEspaceDeStockage(new EspaceDeStockage());
		
		EmballageService basiqueEmballageService = new BasiqueEmballageService(espaceDeStockageRepository);
		EmballageService optimiseEmballageService = new OptimiseEmballageService(espaceDeStockageRepository);
		
		final Article[] articles = transformChaineDeChiffresEnChaineDArticles("163841689525773");
		
		basiqueEmballageService.emballer(articles);
		optimiseEmballageService.emballer(articles);

		Carton[] cartonsALivrer= basiqueEmballageService.getCartonsALivrer();
		Carton[] cartonsALivrerOpitimise= optimiseEmballageService.getCartonsALivrer();

		assertThat(cartonsALivrerOpitimise.length, lessThan(cartonsALivrer.length));
		
		String chaineDeCartonEnString = transformChaineDeCartonsEnChaineDeChiffres(cartonsALivrer);
		assertThat(chaineDeCartonEnString, equalTo("163/8/41/6/8/9/52/5/7/73"));
	}
	@Test
	public void testEmballeoptimise() {
		espaceDeStockageRepository.saveEspaceDeStockage(new EspaceDeStockage());
		
		EmballageService optimiseEmballageService = new OptimiseEmballageService(espaceDeStockageRepository);
		
		final Article[] articles = transformChaineDeChiffresEnChaineDArticles("163841689525773");
		
		optimiseEmballageService.emballer(articles);
		
		Carton[] cartonsALivrer = optimiseEmballageService.getCartonsALivrer();
		
		assertThat(cartonsALivrer, arrayWithSize(equalTo(10)));
		
		String chaineDeCartonEnString = transformChaineDeCartonsEnChaineDeChiffres(cartonsALivrer);
		assertThat(chaineDeCartonEnString, equalTo("163/82/46/19/8/55/73/7"));
	}

}
