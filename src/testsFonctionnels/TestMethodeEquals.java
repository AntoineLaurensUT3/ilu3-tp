package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	public TestMethodeEquals() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Borne b1 = new Borne(25);
		Borne b2 = new Borne(25);
		System.out.println(b1.equals(b2));
		Attaque a1 = new Attaque(Type.FEU);
		Attaque a2 = new Attaque(Type.FEU);
		System.out.println(a1.equals(a2));
		Parade p = new Parade(Type.FEU);
		System.out.println(p.equals(a1));
	}

}
