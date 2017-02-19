package fr.aroy.xspeedit.application;

import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeCartonsEnChaineDeChiffres;
import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeChiffresEnChaineDArticles;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.infrastructure.InMemoryEspaceDeStockageRepository;

public class Optimise1EmballageServiceTest {

	EspaceDeStockageRepository stockageRepositoryBasique = new InMemoryEspaceDeStockageRepository(); 
	EspaceDeStockageRepository stockageRepositoryOptimise = new InMemoryEspaceDeStockageRepository(); 
	
	@Test
	public void testEmballageOptimiseEstMeilleQueEmballageBasique() {
		stockageRepositoryBasique.saveEspaceDeStockage(new EspaceDeStockage());
		stockageRepositoryOptimise.saveEspaceDeStockage(new EspaceDeStockage());
		
		EmballageService basiqueEmballageService = new BasiqueEmballageService(stockageRepositoryBasique);
		EmballageService optimiseEmballageService = new OptimiseEmballageService(stockageRepositoryOptimise);
		
		final Article[] articles = transformChaineDeChiffresEnChaineDArticles("163841689525773");
		
		basiqueEmballageService.emballer(articles);
		optimiseEmballageService.emballer(articles);

		Carton[] cartonsALivrer = basiqueEmballageService.getCartonsALivrer();
		Carton[] cartonsALivrerOpitimise= optimiseEmballageService.getCartonsALivrer();

		assertThat(cartonsALivrerOpitimise.length, lessThan(cartonsALivrer.length));
	}

	@Test
	public void testEmballeOptimise() {
		stockageRepositoryOptimise.saveEspaceDeStockage(new EspaceDeStockage());
		
		EmballageService optimiseEmballageService = new OptimiseEmballageService(stockageRepositoryOptimise);
		
		final Article[] articles = transformChaineDeChiffresEnChaineDArticles("163841689525773");
		
		optimiseEmballageService.emballer(articles);
		
		Carton[] cartonsALivrer = optimiseEmballageService.getCartonsALivrer();
		
		assertThat(cartonsALivrer, arrayWithSize(equalTo(8)));
		
		String chaineDeCartonEnString = transformChaineDeCartonsEnChaineDeChiffres(cartonsALivrer);
		assertThat(chaineDeCartonEnString, equalTo("163/81/46/82/9/55/73/7"));
	}

}
