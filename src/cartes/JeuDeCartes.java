package cartes;

public class JeuDeCartes {
	
	private Configuration[] typeDeCartes = new Configuration[19];
	
	public JeuDeCartes() {
		// TODO Auto-generated constructor stub
	}

	
	public String affichageJeuDeCartes() {
		StringBuilder affichage = new StringBuilder();
		for(int i=0; i< typeDeCartes.length; i++) {
			
			 affichage.append(typeDeCartes[i].getNbExemplaires() + " " + typeDeCartes[i].getCarte() + "\n");
		}
		return affichage.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] Tab = new Carte[110]; 
		int x = 0;
		for(int i=0; i< typeDeCartes.length; i++) {
			for(int y=0; y < typeDeCartes[i].getNbExemplaires();y++) {
				Carte carte = typeDeCartes[i].getCarte();
				Tab[x] = carte;
				x++;
			}
		}
		return Tab;
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
