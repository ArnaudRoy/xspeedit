package fr.aroy.xspeedit.application;

import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeCartonsEnChaineDeChiffres;
import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeChiffresEnChaineDArticles;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.equalTo;

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
public class Optimise2EmballageServiceTest {

	EspaceDeStockageRepository stockageRepositoryOptimise1 = new InMemoryEspaceDeStockageRepository();
	EspaceDeStockageRepository stockageRepositoryOptimise2 = new InMemoryEspaceDeStockageRepository();

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "163841689525773", "163/81/46/82/9/55/73/7", 8 },
				{ "321321654321", "32131/262/541/3", 4 },
				{ "9876541", "91/8/7/64/5", 5 },
				{ "1638416895257793218431326832", "163/811/46/82/91/55/73/72/9/82/433/63/82", 13 },
				{ "123456578998765432199999995551122377777777", "1234/55/64/73/82/91/91/82/72/63/55/91/9/9/9/9/9/9/55/7/7/7/7/7/7/7/7", 27 },
				
		});
	}

	private String chaineArticleEnEntree;
	private String chaineArticleAttendue;
	private int nombreDeCartons;

    public Optimise2EmballageServiceTest(String chaineArticleEnEntree, String chaineArticleAttendue, int nombreDeCartons) {
        this.chaineArticleEnEntree = chaineArticleEnEntree;
        this.chaineArticleAttendue = chaineArticleAttendue;
        this.nombreDeCartons = nombreDeCartons;
    }
	
	@Test
	public void testEmballeOptimise2() {
		stockageRepositoryOptimise2.saveEspaceDeStockage(new EspaceDeStockage());

		EmballageService optimiseEmballageService = new Optimise2EmballageService(stockageRepositoryOptimise2);

		final Article[] articles = transformChaineDeChiffresEnChaineDArticles(chaineArticleEnEntree);

		optimiseEmballageService.emballer(articles);

		Carton[] cartonsALivrer = optimiseEmballageService.getCartonsALivrer();

		assertThat(cartonsALivrer, arrayWithSize(equalTo(nombreDeCartons)));

		String chaineDeCartonEnString = transformChaineDeCartonsEnChaineDeChiffres(cartonsALivrer);
		assertThat(chaineDeCartonEnString, equalTo(chaineArticleAttendue));
	}

}
