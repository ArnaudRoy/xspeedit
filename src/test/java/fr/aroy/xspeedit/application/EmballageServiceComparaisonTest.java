package fr.aroy.xspeedit.application;

import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeChiffresEnChaineDArticles;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.infrastructure.InMemoryEspaceDeStockageRepository;

@RunWith(value = Parameterized.class)
public class EmballageServiceComparaisonTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "163841689525773"},
				{ "321321654321"},
				{ "9876541"},
				{ "1638416895257793218431326832" },
				{ "123456578998765432199999995551122377777777" },
				
		});
	}

	private String chaineArticleEnEntree;

    public EmballageServiceComparaisonTest(String chaineArticleEnEntree) {
        this.chaineArticleEnEntree = chaineArticleEnEntree;

    }
	
	@Test
	public void testEmballageOptimise2EstMeilleQueEmballageOptimise2() {
		EmballageService service1 = new BasiqueEmballageService();
		EmballageService service2 = new OptimiseEmballageService();
		EmballageService service3 = new Optimise2EmballageService();
		EmballageService service4 = new Optimise3EmballageService();
		
		Article[] articlesEnEntree = transformChaineDeChiffresEnChaineDArticles(chaineArticleEnEntree);
		
		Carton[] result1 = testService(service1, articlesEnEntree);
		Carton[] result2 = testService(service2, articlesEnEntree);
		Carton[] result3 = testService(service3, articlesEnEntree);
		Carton[] result4 = testService(service4, articlesEnEntree);
		
		assertThat(result2.length, lessThanOrEqualTo(result1.length));
		assertThat(result3.length, lessThanOrEqualTo(result2.length));
		assertThat(result4.length, lessThanOrEqualTo(result3.length));

	}
	
	private Carton[] testService(EmballageService emballageService, final Article[] articles) {
		EspaceDeStockageRepository stockageRepository = new InMemoryEspaceDeStockageRepository();
		stockageRepository.saveEspaceDeStockage(new EspaceDeStockage(100));

		emballageService.setEspaceDeStockageRepository(stockageRepository);

		emballageService.emballer(articles);

		Carton[] cartonsALivrer = emballageService.getCartonsEnStock();

		return cartonsALivrer;
	}

}
