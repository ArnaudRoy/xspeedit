package fr.aroy.xspeedit.infrastructure;

import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

/**
 * Reposiotry de l'EspaceDeStockage en mémoire
 * @author royar
 *
 */
public class InMemoryEspaceDeStockageRepository implements EspaceDeStockageRepository {

	/** l'esapce de stockage enregistré en static */
	private EspaceDeStockage espaceDeStockage;
	
	@Override
	public EspaceDeStockage loadEspaceDeStockage() {
		return this.espaceDeStockage;
	}
	
	@Override
	public void saveEspaceDeStockage(EspaceDeStockage espaceDeStockage) {
		this.espaceDeStockage = espaceDeStockage;
	}

}
