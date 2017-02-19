package fr.aroy.xspeedit.application;

import static fr.aroy.xspeedit.application.EmballageUtils.transformChaineDeChiffresEnChaineDArticles;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;
import fr.aroy.xspeedit.domain.Livraison;
import fr.aroy.xspeedit.infrastructure.InMemoryEspaceDeStockageRepository;

@RunWith(value = Parameterized.class)
public class FluxDArticleEmballageServiceTest {

	EspaceDeStockageRepository stockageRepository = new InMemoryEspaceDeStockageRepository();

	// TODO utiliser le deuxieme parametre
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][][] {
				{ { "163841689525773", "163841689525773" }, { "", "" }, { 0.72, 0.79 } },
				{ { "1638", "41", "68", "952", "5773", "1", "6", "3", "84168", "9", "525773"}, { "", "" }, { 0.85, 0.87 } },
				{ { "1638416", "89525773", "163841689525773" }, { "", "" }, { 0.85, 0.77 } },
				{ { "1", "6", "3", "8", "4", "1", "6", "8", "9", "5", "2", "5", "7", "7", "3", "1", "6", "3", "8", "4", "1", "6", "8", "9", "5", "2", "5", "7", "3" }, { "", "" }, { 0.9 , 0.9 } },
				{ { "987654987", "65498321", "56873216485", "3218832889", "987321987"}, { "", "","" , "" }, { 0.77, 0.9, 0.9, 0.8 } },
		});
	}

	private String[] chainesArticleEnEntree;
	private String[] livraisonsAttendues;
	private Double[] tauxRemplissage;

	public FluxDArticleEmballageServiceTest(Object[] chainesArticleEnEntree, Object[] livraisonsAttendue,
			Object[] tauxRemplissage) {
		this.chainesArticleEnEntree = Arrays.copyOf(chainesArticleEnEntree, chainesArticleEnEntree.length,
				String[].class);
		this.livraisonsAttendues = Arrays.copyOf(livraisonsAttendue, livraisonsAttendue.length, String[].class);
		this.tauxRemplissage = Arrays.copyOf(tauxRemplissage, tauxRemplissage.length, Double[].class);
		;
	}

	@Test
	public void testEmballeOptimise2() {
		stockageRepository.saveEspaceDeStockage(new EspaceDeStockage(7));

		EmballageService optimiseEmballageService = new Optimise3EmballageService(stockageRepository);

		for (String chaineArticleEnEntree : chainesArticleEnEntree) {
			final Article[] articles = transformChaineDeChiffresEnChaineDArticles(chaineArticleEnEntree);
			optimiseEmballageService.emballer(articles);
		}

		List<Livraison> livraisons = optimiseEmballageService.getLivraison();
		System.out.println(livraisons.size() + " livraison(s)"); 
		
		assertThat(livraisons, Matchers.hasSize(livraisonsAttendues.length));

		int idx = 0;
		for (Livraison livraison : livraisons) {
			assertThat(livraison.getTauxDeRemplissage(), Matchers.greaterThanOrEqualTo(tauxRemplissage[idx]));
			System.out.println("Livraison " + idx + " : " + livraison.getTauxDeRemplissage());
			idx++;
		}
	}

}
