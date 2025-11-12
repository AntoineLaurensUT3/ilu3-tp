package jeu;

import java.util.ArrayList;
import java.util.Iterator;

import cartes.Carte;

public class MainJoueur {
	private ArrayList<Carte> main = new ArrayList<Carte>();
	public MainJoueur() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Carte> getMain() {
		return main;
	}

	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert !main.contains(carte) : "La main du joueur ne contient pas cette carte";
		main.remove(carte);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(Iterator<Carte> iter = main.iterator(); iter.hasNext();) {
			Carte carteCourante = iter.next();
			str.append(carteCourante.toString());
		}
		return str.toString();
	}

}
