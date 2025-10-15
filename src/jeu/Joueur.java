package jeu;

import java.util.Objects;

import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zdj;
	private MainJoueur main;
	public Joueur(String nom) {
		this.nom = nom;
		zdj = new ZoneDeJeu();
		main = new MainJoueur();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "Joueur " + nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		return sabot.piocher();
	}
	
	public int donnerKmParcourus() {
		return zdj.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		zdj.deposer(c);
	}
	
}
