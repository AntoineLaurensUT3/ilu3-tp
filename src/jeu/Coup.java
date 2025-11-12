package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	
	private Joueur joueurCourant;
	private Joueur joueurCible;
	private Carte carteJouee;
	
	public Coup(Joueur joueurCourant, Joueur joueurCible, Carte carteJouee) {
		this.joueurCourant = joueurCourant;
		this.joueurCible = joueurCible;
		this.carteJouee = carteJouee;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}

	public Carte getCarteJouee() {
		return carteJouee;
	}
	
	@Override
	public int hashCode() {
		return this.hashCode()+31*carteJouee.hashCode()+31*joueurCible.hashCode()+31*joueurCourant.hashCode();
	}
	
	public boolean estValide() {
		if(carteJouee instanceof Attaque || carteJouee instanceof Limite) {
			if(!joueurCourant.equals(joueurCible)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(joueurCourant.equals(joueurCible)) {
			return true;
		}
			return false;
		
	}
	

}
