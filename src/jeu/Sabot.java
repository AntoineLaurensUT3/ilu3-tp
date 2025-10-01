package jeu;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes = 0;
	private int nbOperations = 0;
	
	public Sabot(Carte[] tab) {
		
		cartes = tab;
		nbCartes = tab.length;
	}
	
	public boolean estVide() {
		return cartes.length==0;
			
		
	}
	
	
	public void ajouterCarte(Carte carte) {
		if(nbCartes < cartes.length) {
			cartes[nbCartes-1]=carte;
			nbOperations++;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	
	public Carte piocher() {
			Iterator<Carte> i = iterator(); 
			if(i.hasNext()) {
				Carte c= i.next();
				i.remove();
				return c;
			}
			return null;
	}
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIt=0;
		private int nbOperationsRef=nbOperations;
		private boolean nextEffectue = false;
		
		public boolean hasNext() {
			return indiceIt < nbCartes;
		}
		
		public Carte next() {
			verificationConcurrence();
			if(hasNext()) {
				Carte carte = cartes[indiceIt];
				indiceIt++;
				nextEffectue = true;
				return carte;
			}
			else {
				throw new NoSuchElementException();
			}
			
		}
		
		public void remove() {
			verificationConcurrence();
			if(nbCartes<1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			
			for(int i = indiceIt - 1; i < nbCartes - 1; i++) {
				cartes[i]=cartes[i+1];
			}
			nextEffectue=false;
			indiceIt--;
			nbCartes--;
			nbOperations++;
			nbOperationsRef++;
			
		}
		
		private void verificationConcurrence() {
			if(nbOperations != nbOperationsRef) {
				throw new ConcurrentModificationException();
			}
		}
		
		
		
		
		
	}
}

