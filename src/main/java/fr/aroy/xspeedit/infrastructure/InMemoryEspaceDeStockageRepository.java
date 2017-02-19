package fr.aroy.xspeedit.infrastructure;

import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

/**
 * Reposiotry de l'EspaceDeStockage en mémoire
 * @author royar
 *
 */
public class InMemoryEspaceDeStockageRepository implements EspaceDeStockageRepository {

	private static EspaceDeStockage espaceDeStockage;
	
	@Override
	public EspaceDeStockage getEspaceDeStockage() {
		return InMemoryEspaceDeStockageRepository.espaceDeStockage;
	}
	
	@Override
	public void setEspaceDeStockage(EspaceDeStockage espaceDeStockage) {
		InMemoryEspaceDeStockageRepository.espaceDeStockage = espaceDeStockage;
	}

}
