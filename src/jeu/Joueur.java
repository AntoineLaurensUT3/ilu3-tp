package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

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

	public ZoneDeJeu getZdj() {
		return zdj;
	}

	public MainJoueur getMain() {
		return main;
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
	
	public Set<Coup> coupsPossibles(Set<Joueur> Participants){
		Set<Coup> coups = new HashSet<>();
		
		for(Iterator<Joueur> iter = Participants.iterator();iter.hasNext();) {
			Joueur joueurCourant = iter.next();
			 ArrayList<Carte> mainJoueur = joueurCourant.getMain().getMain();
			for(Iterator<Carte> iterCarte = mainJoueur.iterator(); iterCarte.hasNext();) {
				Carte carteCourante = iterCarte.next();
				Coup coup = new Coup(joueurCourant, joueurCourant, carteCourante);
				if(coup.estValide()) {
					coups.add(coup);
				}
			}
		}
		
		
		
		
		
		return coups;
	}
	
}
