package fr.aroy.xspeedit.application;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

/**
 * Implémentation optimisée du service d'emballage
 * TODO détailler le mode de fonctionnement
 * @author royar
 *
 */
public class OptimiseEmballageService implements EmballageService {
	
	/** Repo de l'espace de stockage */
	EspaceDeStockageRepository espaceDeStockageRepository; 

	/** Constructeur */
	public OptimiseEmballageService() {
	}
	
	/** Constructeur avec le repo */
	public OptimiseEmballageService(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}
	
	@Override
	public void emballer(Article[] chaineDArticles) {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
	}

	@Override
	public Carton[] getCartonsALivrer() {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.loadEspaceDeStockage();
		return espaceDeStockage.getChaineDeCartons().stream().toArray(size -> new Carton[size]);
	}
	
	/**
	 * Setter du repo
	 * @param espaceDeStockageRepository
	 */
	public void setEspaceDeStockageRepository(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}

}
