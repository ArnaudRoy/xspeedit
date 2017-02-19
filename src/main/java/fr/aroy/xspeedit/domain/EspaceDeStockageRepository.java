package fr.aroy.xspeedit.domain;

/**
 * Interface du reposiotry de l'EspaceDeStockage
 * @author royar
 *
 */
public interface EspaceDeStockageRepository {

	/**
	 * Recupere l'espace de stockage
	 * @return EspaceDeStockage
	 */
	EspaceDeStockage loadEspaceDeStockage();
	
	/**
	 * Enregistrer l'espace de stockage
	 * @param espaceDeStockage
	 */
	void saveEspaceDeStockage(EspaceDeStockage espaceDeStockage);
}
