package fr.aroy.xspeedit.application;

import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeCartonsEnChaineDeChiffres;
import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeCartonsEnChaineDeChiffresFlat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.infrastructure.InMemoryEspaceDeStockageRepository;

public class BasiqueEmballageServiceTest {

	EspaceDeStockageRepository espaceDeStockageRepository = new InMemoryEspaceDeStockageRepository(); 
	
	@Test
	public void test() {
		espaceDeStockageRepository.saveEspaceDeStockage(new EspaceDeStockage());
		
		EmballageService emballageService = new BasiqueEmballageService(espaceDeStockageRepository);
		
		Article[] articles = EmballageUtils.transformChaineDeChiffresEnChaineDArticles("163841689525773");
		
		emballageService.emballer(articles);
		Carton[] cartonsALivrer= emballageService.getCartonsALivrer();

		assertThat(cartonsALivrer, arrayWithSize(equalTo(10)));
		
		String chaineDeCartonEnString = transformChaineDeCartonsEnChaineDeChiffres(cartonsALivrer);
		assertThat(chaineDeCartonEnString, equalTo("163/8/41/6/8/9/52/5/7/73"));

		String chaineDeCartonFlatEnString = transformChaineDeCartonsEnChaineDeChiffresFlat(cartonsALivrer);
		assertThat(chaineDeCartonFlatEnString, equalTo("163841689525773"));
	}

}
