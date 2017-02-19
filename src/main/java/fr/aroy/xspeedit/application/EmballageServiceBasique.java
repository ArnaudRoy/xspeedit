package fr.aroy.xspeedit.application;

import fr.aroy.xspeedit.domain.Article;
import fr.aroy.xspeedit.domain.Carton;
import fr.aroy.xspeedit.domain.EspaceDeStockage;
import fr.aroy.xspeedit.domain.EspaceDeStockageRepository;

public class EmballageServiceBasique implements EmballageService {
	
	EspaceDeStockageRepository espaceDeStockageRepository; 

	public EmballageServiceBasique() {
	}
	
	public EmballageServiceBasique(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}
	
	@Override
	public void emballer(Article[] chaineDArticles) {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.getEspaceDeStockage();
		
		Carton carton = new Carton();
		for (Article article : chaineDArticles) {
//			if (carton.)
		}
	}

	@Override
	public Carton[] getCartonsALivrer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setEspaceDeStockageRepository(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}

}
