package fr.aroy.xspeedit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;

public class CartonTest {

	@Test
	public void testCalculCapaciteRestanteASix() {
		Carton carton = new Carton();
		carton.addArticle(new Article(1));
		carton.addArticle(new Article(1));
		carton.addArticle(new Article(1));
		carton.addArticle(new Article(1));
		
		assertThat(carton.getCapaciteRestante(), equalTo(6));
	}
	@Test
	public void testCalculCapaciteRestanteAZero() {
		Carton carton = new Carton();
		carton.addArticle(new Article(9));
		carton.addArticle(new Article(1));
		
		assertThat(carton.getCapaciteRestante(), equalTo(0));
	}

}
