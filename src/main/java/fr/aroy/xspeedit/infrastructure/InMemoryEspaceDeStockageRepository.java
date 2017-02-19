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
	public EspaceDeStockage loadEspaceDeStockage() {
		return InMemoryEspaceDeStockageRepository.espaceDeStockage;
	}
	
	@Override
	public void saveEspaceDeStockage(EspaceDeStockage espaceDeStockage) {
		InMemoryEspaceDeStockageRepository.espaceDeStockage = espaceDeStockage;
	}

}
