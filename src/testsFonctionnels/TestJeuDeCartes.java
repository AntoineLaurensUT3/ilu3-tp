package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println("JEU:\n" + jeu.affichageJeuCartes());
		
        if (!jeu.checkCount()) {
            System.out.println("erreur de nombre");
        }

	}
}
	//public static void main(String[] args) {
		
	//Borne a = new Borne(25);
	//Borne b = new Borne(50);
	//Borne c = new Borne(75);
	//Borne d = new Borne(100);
	//Borne e = new Borne(200);
	
	//Parade feuVert = new Parade(Type.FEU);
	//Parade essence = new Parade(Type.ESSENCE);
	//Parade reparation = new Parade(Type.ACCIDENT);
	//Parade roueDeSecours = new Parade(Type.CREVAISON);
	
	//Attaque feuRouge = new Attaque(Type.FEU);
	//Attaque panne = new Attaque(Type.ESSENCE);
	//Attaque crevaison = new Attaque(Type.CREVAISON);
	//Attaque accident = new Attaque(Type.ACCIDENT);
	
	//Botte prioritaire = new Botte(Type.FEU);
	//Botte citerne = new Botte(Type.ESSENCE);
	//Botte increvable = new Botte(Type.CREVAISON);
	//Botte asDuVolant = new Botte(Type.ACCIDENT);//

	
	}

}
