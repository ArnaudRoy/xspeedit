package fr.aroy.xspeedit.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class CartonTest {

	@Test
	public void testCalculCapaciteRestanteSurCartonVide() {
		Carton carton = new Carton();
		assertThat(carton.getCapaciteRestante(), equalTo(Carton.CAPACITE_MAX));
	}
	@Test
	public void testCalculCapaciteRestanteASix() {
		Carton carton = new Carton();
		carton.addArticle(new Article(1));
		carton.addArticle(new Article(1));
		carton.addArticle(new Article(1));
		carton.addArticle(new Article(1));
		
		assertThat(carton.getCapaciteRestante(), equalTo(6));
		assertThat(carton.getTauxDeRemplissage(), equalTo(0.4));
	}
	@Test
	public void testCalculCapaciteRestanteAZero() {
		Carton carton = new Carton();
		carton.addArticle(new Article(9));
		carton.addArticle(new Article(1));
		
		assertThat(carton.getCapaciteRestante(), equalTo(0));
		assertThat(carton.getTauxDeRemplissage(), equalTo(1.0));
	}
	
	

}
