package fr.aroy.xspeedit.infrastructure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

public class InMemoryEspaceDeStockageRepositoryTest {

	@Test
	public void test() {
		EspaceDeStockageRepository stockageRepository = new InMemoryEspaceDeStockageRepository();
		
		EspaceDeStockage espaceDeStockage = new EspaceDeStockage();
		
		stockageRepository.saveEspaceDeStockage(espaceDeStockage);
		
		EspaceDeStockage espaceDeStockageFromRepository = stockageRepository.loadEspaceDeStockage();
		
		assertThat(espaceDeStockage, equalTo(espaceDeStockageFromRepository));
		
	}

}
