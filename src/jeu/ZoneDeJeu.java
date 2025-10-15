package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {
	
	private ArrayList<Limite> pileLimite = new ArrayList<Limite>();
	private ArrayList<Bataille> pileBataille = new ArrayList<Bataille>();
	private NavigableSet<Borne> collectionBornes = new TreeSet<Borne>();
	
	
	public ZoneDeJeu() {
		
	}

	public int donnerLimitationVitesse() {
		if(pileLimite.isEmpty() || (pileLimite.get(0).toString().equals("Fin Limite"))) {
			return 200;
		}
		else {
			return 50;
		}
	}
	
	
	public int donnerKmParcourus() {
		int km = 0;
		for(Iterator<Borne> iter = collectionBornes.iterator(); iter.hasNext();) {
			Borne borneCourante = iter.next();
			km += borneCourante.getKm(); 
		}
		return km;
	}
	
	public void deposer(Carte c) {
		if(c instanceof Borne) {
			collectionBornes.add((Borne) c);
		}
		if(c instanceof Limite) {
			pileLimite.add((Limite) c);
		}
		
		if(c instanceof Bataille) {
			pileBataille.add((Bataille) c);
		}
	}
	
	
	
	public boolean peutAvancer() {
		if(!pileBataille.isEmpty() && pileBataille.get(0).toString().equals("Feu Vert")) {
			return true;
		}
		return false;
	}
	
	public boolean estDepotFeuVertAutorise() {
		if(pileBataille.isEmpty() || pileBataille.get(0).toString().equals("Feu Rouge") || (pileBataille.get(0) instanceof Parade) ) {
			return true;
		}
		
		return false;
	}
	
	public boolean estDepotBorneAutorise(Borne borne) {
		if(peutAvancer() && (borne.getKm()< donnerLimitationVitesse()) && donnerKmParcourus()<1000 ) {
			return true;
		}
		return false;
	}
	
	public boolean estDepotLimiteAutorise(Limite limite) {
		switch(limite.toString()) {
		case("Debut Limite"):
			if(pileLimite.isEmpty() || pileLimite.get(0).toString().equals("Fin Limite")) {
				return true;
			}
		break;
		
		case("Fin Limite"):
			if(pileLimite.get(0).toString().equals("Debut Limite")) {
				return true;
			}
			
		break;	
		
		}
		return false;
		
	}
	
	
	public boolean  estDepotBatailleAutorise(Bataille bataille) {
		if(bataille instanceof Attaque) {
			return true;
		}
		else if(bataille instanceof Parade) {
			return estDepotFeuVertAutorise();
		}
		else if(!pileBataille.isEmpty() && pileBataille.get(0).getType().equals(bataille.getType())) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
