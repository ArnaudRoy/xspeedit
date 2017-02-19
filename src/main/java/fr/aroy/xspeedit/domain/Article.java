package fr.aroy.xspeedit.domain;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Value-Object carton
 * 
 * @author royar
 *
 */
public class Article {

	/** Taille du carton */
	private final int taille;

	/** Constructeur avec la taille du carton */
	public Article(int taille) {
		this.taille = taille;
	}

	/**
	 * Getter sur la taille
	 * 
	 * @return la taille de l'article
	 */
	public Integer getTaille() {
		return taille;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Article other = (Article) obj;
		return Objects.equals(this.taille, other.taille);
	}

	@Override
	public String toString() {
		return new StringJoiner("")
				.add(Class.class.getSimpleName())
				.add("[")
				.add("taille=" + taille)
				.add("]")
				.toString();
	}
}
