package fr.aroy.xspeedit;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.service.EmballageUtils;

public class EmballageUtilsTest {

	@Test
	public void test15Articles() {
		Article[] articles = EmballageUtils.transformChaineDeChiffresEnChaineDArticles("163841689525773");
		assertThat(articles, arrayWithSize(equalTo(15)));
	}

	@Test
	public void test15ArticlesAvecCaracteresNonAttendus() {
		Article[] articles = EmballageUtils.transformChaineDeChiffresEnChaineDArticles("0000000163z8416!89525773");
		assertThat(articles, arrayWithSize(equalTo(15)));
	}

	@Test
	public void testAucunArticleAvecCaracteresNonAttendus() {
		Article[] articles = EmballageUtils.transformChaineDeChiffresEnChaineDArticles("aertyuiop&é\"'(-è_çà)=");
		assertThat(articles, arrayWithSize(equalTo(0)));
	}
	@Test
	public void testArticleEqulasTo() {
		Article[] articles = EmballageUtils.transformChaineDeChiffresEnChaineDArticles("1234");
		assertThat(articles, arrayWithSize(equalTo(4)));
		assertThat(articles, arrayContaining(
				equalTo(new Article(1)),
				equalTo(new Article(2)),
				equalTo(new Article(3)),
				equalTo(new Article(4))
				));		
	}
	
	@Test
	public void testCartonsToString() {
		Carton[] cartons = {new Carton(), new Carton(), new Carton(), new Carton(), new Carton()};
		for (Carton carton : cartons) {
			carton.addArticle(new Article(1));
			carton.addArticle(new Article(2));
			carton.addArticle(new Article(3));
		}
		String chaineDeCartonEnString = EmballageUtils.transformChaineDeCartonsEnChaineDeChiffres(cartons);
		assertThat(chaineDeCartonEnString, equalTo("123/123/123/123/123/"));
	}
}
