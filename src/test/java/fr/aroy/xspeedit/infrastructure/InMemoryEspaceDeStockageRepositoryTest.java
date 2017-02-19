package fr.aroy.xspeedit.infrastructure;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

public class InMemoryEspaceDeStockageRepositoryTest {

	@Test
	public void test() {
		EspaceDeStockageRepository stockageRepository = new InMemoryEspaceDeStockageRepository();
		
		EspaceDeStockage espaceDeStockage = new EspaceDeStockage();
		
		stockageRepository.setEspaceDeStockage(espaceDeStockage);
		
		EspaceDeStockage espaceDeStockageFromRepository = stockageRepository.getEspaceDeStockage();
		
		assertThat(espaceDeStockage, equalTo(espaceDeStockageFromRepository));
		
	}

}
