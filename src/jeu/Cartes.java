package jeu;


import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Type;

public interface Cartes {
	final static Botte  PRIORITAIRE = new Botte(Type.FEU);
	final static Attaque FEU_ROUGE = new Attaque(Type.FEU);
	final static Parade FEU_VERT = new Parade(Type.FEU);
}
