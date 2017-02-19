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
public class Optimise3EmballageServiceTest {

	EspaceDeStockageRepository stockageRepository = new InMemoryEspaceDeStockageRepository();

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "163841689525773", "91/82/81/73/73/64/6/55", 8 },
				{ "321321654321", "64/532/3322/111", 4 },
				{ "9876541", "91/8/7/64/5", 5 },
				{ "1638416895257793218431326832", "91/91/82/82/82/82/73/73/64/64/631/55/331", 13 },
				{ "123456578998765432199999995551122377777777", "91/91/91/91/9/9/9/9/9/82/82/73/73/73/72/72/7/7/7/7/7/64/64/55/55/55", 26 },
				
		});
	}

	private String chaineArticleEnEntree;
	private String chaineArticleAttendue;
	private int nombreDeCartons;

    public Optimise3EmballageServiceTest(String chaineArticleEnEntree, String chaineArticleAttendue, int nombreDeCartons) {
        this.chaineArticleEnEntree = chaineArticleEnEntree;
        this.chaineArticleAttendue = chaineArticleAttendue;
        this.nombreDeCartons = nombreDeCartons;
    }
	
	@Test
	public void testEmballeOptimise2() {
		stockageRepository.saveEspaceDeStockage(new EspaceDeStockage());

		EmballageService optimiseEmballageService = new Optimise3EmballageService(stockageRepository);

		final Article[] articles = transformChaineDeChiffresEnChaineDArticles(chaineArticleEnEntree);

		optimiseEmballageService.emballer(articles);

		Carton[] cartonsALivrer = optimiseEmballageService.getCartonsALivrer();

		assertThat(cartonsALivrer, arrayWithSize(equalTo(nombreDeCartons)));

		String chaineDeCartonEnString = transformChaineDeCartonsEnChaineDeChiffres(cartonsALivrer);
		assertThat(chaineDeCartonEnString, equalTo(chaineArticleAttendue));
	}

}
