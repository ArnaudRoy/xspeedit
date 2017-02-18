package fr.aroy.xspeedit.domain;

import java.util.Objects;

public class Article {

	public final int taille;

	public Article(int taille) {
		this.taille = taille;
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
}
