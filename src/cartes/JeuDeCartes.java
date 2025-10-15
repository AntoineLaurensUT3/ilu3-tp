package cartes;

public class JeuDeCartes {
	
	private Configuration[] typeDeCartes = {new Configuration(new Borne(25),10),new Configuration(new Borne(50),10),new Configuration(new Borne(75),10),
			new Configuration(new Borne(100),12),new Configuration(new Borne(200),4), new Configuration(new Parade(Type.FEU),14), new Configuration(new Parade(Type.CREVAISON),6),
			new Configuration(new Parade(Type.ESSENCE),6),new Configuration(new Parade(Type.ACCIDENT),6), new Configuration(new DebutLimite(),4), new Configuration(new FinLimite(),4),
			new Configuration(new Attaque(Type.FEU),5),new Configuration(new Attaque(Type.CREVAISON),3),new Configuration(new Attaque(Type.ESSENCE),3), new Configuration(new Attaque(Type.ACCIDENT),3),
			new Configuration(new Botte(Type.FEU),1),new Configuration(new Botte(Type.ACCIDENT),1),new Configuration(new Botte(Type.ESSENCE),1),new Configuration(new Botte(Type.ACCIDENT),1)
			};
	
	public JeuDeCartes() {
		
	}

	
	public String affichageJeuDeCartes() {
		StringBuilder affichage = new StringBuilder();
		for(int i=0; i< typeDeCartes.length; i++) {
			
			 affichage.append(typeDeCartes[i].getNbExemplaires() + " " + typeDeCartes[i].getCarte() + "\n");
		}
		return affichage.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] tab = new Carte[typeDeCartes.length]; 
		int x = 0;
		for(int i=0; i< typeDeCartes.length; i++) {
			for(int y=0; y < typeDeCartes[i].getNbExemplaires();y++) {
				Carte carte = typeDeCartes[i].getCarte();
				tab[x] = carte;
				x++;
			}
		}
		return tab;
	}
	
	public boolean checkCount() {
		Carte[] tab = donnerCartes();
		for(int i =0;i<tab.length;i++) {
			for(int j=0;j<typeDeCartes.length;j++) {
				if (tab[i].equals(typeDeCartes[j].getCarte())) {
					return false;
				}
				//rajouter verif nbexemplaires
			}
		}
		return true;
	}
	
	private class Configuration {
		private int nbExemplaires;
		private Carte carte;
		
		public Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
		
		public int getNbExemplaires() {
			return nbExemplaires;
		}
		public Carte getCarte() {
			return carte;
		}
		
	}
}
