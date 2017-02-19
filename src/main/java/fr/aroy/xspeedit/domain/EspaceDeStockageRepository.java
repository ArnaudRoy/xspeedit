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
	EspaceDeStockage getEspaceDeStockage();
	
	/**
	 * Enregistrer l'espace de stockage
	 * @param espaceDeStockage
	 */
	void setEspaceDeStockage(EspaceDeStockage espaceDeStockage);
}
