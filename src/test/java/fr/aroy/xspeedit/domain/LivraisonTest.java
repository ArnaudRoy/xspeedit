package fr.aroy.xspeedit.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class LivraisonTest {

	@Test
	public void testCalculTauxRemplissage() {
		
		Article[][] articles = new Article[][] {
			{new Article(1), new Article(1), new Article(3)},
			{new Article(2), new Article(2), new Article(1)},
			{new Article(4), new Article(1)}
		};
		
		Carton[] cartons = new Carton[] {
				new Carton(articles[0]),
				new Carton(articles[1]),
				new Carton(articles[2])};
		
		Livraison livraison = new Livraison(cartons);
		
		assertThat(livraison.getTauxDeRemplissage(), equalTo(0.5));
	}
	@Test
	public void testCalculTauxRemplissage2() {
		
		Article[][] articles = new Article[][] {
			{new Article(8), new Article(1), new Article(1)},
			{new Article(5), new Article(2), new Article(1)},
			{}
		};
		
		Carton[] cartons = new Carton[] {
				new Carton(articles[0]),
				new Carton(articles[1]),
				new Carton(articles[2])};
		
		Livraison livraison = new Livraison(cartons);
				
		assertThat(livraison.getTauxDeRemplissage(), equalTo(0.6));
	}

}
