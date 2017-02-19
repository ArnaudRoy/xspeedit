package fr.aroy.xspeedit.application;

import java.util.List;

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
		
		Carton carton;
		
		List<Carton> chaineDeCartons = espaceDeStockage.getChaineDeCartons();
		if (chaineDeCartons.size() > 0) {
			carton = chaineDeCartons.get(chaineDeCartons.size() - 1);
		} else {
			carton = new Carton();
			chaineDeCartons.add(carton);
		}
		for (Article article : chaineDArticles) {
			if (carton.getCapaciteRestante() < article.taille) {
				carton = new Carton();
				chaineDeCartons.add(carton);
			}
			carton.addArticle(article);
		}
	}

	@Override
	public Carton[] getCartonsALivrer() {
		EspaceDeStockage espaceDeStockage = espaceDeStockageRepository.getEspaceDeStockage();
		return espaceDeStockage.getChaineDeCartons().stream().toArray(size -> new Carton[size]);
	}
	
	public void setEspaceDeStockageRepository(EspaceDeStockageRepository espaceDeStockageRepository) {
		this.espaceDeStockageRepository = espaceDeStockageRepository;
	}

}
