package jeu;

import java.util.ArrayList;
import java.util.Collections;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	JeuDeCartes jdc = new JeuDeCartes();
	
	public Jeu() {
		Carte[] jeu = jdc.donnerCartes();
		ArrayList<Carte> listeCartes = new ArrayList<Carte>();
		Collections.addAll(listeCartes, jeu);
		GestionCartes melangeCartes = new GestionCartes();
		listeCartes = melangeCartes.melanger(listeCartes);
		sabot = new Sabot(listeCartes.toArray(jeu));
	}

}
