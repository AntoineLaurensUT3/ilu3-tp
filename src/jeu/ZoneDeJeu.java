package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	
	private ArrayList<Limite> pileLimite = new ArrayList<Limite>();
	private ArrayList<Bataille> pileBataille = new ArrayList<Bataille>();
	private NavigableSet<Borne> collectionBornes = new TreeSet<Borne>();
	private Set<Botte> bottes = new HashSet<>();
	
	public ZoneDeJeu() {
		
	}

	public int donnerLimitationVitesse() {
		if(pileLimite.isEmpty() || (pileLimite.get(0).toString().equals("Fin Limite")) || (bottes.contains(new Botte(Type.FEU)))) {
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
		if(c instanceof Botte) {
			bottes.add((Botte) c);
		}
	}
	
	
	
	public boolean peutAvancer() {
		if((!pileBataille.isEmpty() && pileBataille.get(0).toString().equals("Feu Vert")) ||
			(pileBataille.isEmpty() && estPrioritaire()) ||
			((pileBataille.get(0) instanceof Parade) && estPrioritaire()) ||
			((pileBataille.get(0) instanceof Attaque) && pileBataille.get(0).getType().equals(Type.FEU) && estPrioritaire()) ||
			((pileBataille.get(0) instanceof Attaque) && (bottes.contains(new Botte(pileBataille.get(0).getType()))) && estPrioritaire())
			) {
			return true;
		}
		return false;
	}
	
	public boolean estDepotFeuVertAutorise() {
		
		if(estPrioritaire()) {
			return false;
		}
		
		if(pileBataille.isEmpty() || pileBataille.get(0).toString().equals("Feu Rouge") || ((pileBataille.get(0) instanceof Parade) && !pileBataille.get(0).toString().equals("Feu Vert"))
				|| ((pileBataille.get(0) instanceof Attaque) && (bottes.contains(new Botte(pileBataille.get(0).getType()))))
				)
				 {
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
		if(estPrioritaire()) {
			return false;
		}
		
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
		if(bottes.contains(new Botte(bataille.getType()))) {
			return false;
		}
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
	
	public boolean estDepotAutorise(Carte carte) {
		if(carte instanceof Bataille) {
			return estDepotBatailleAutorise((Bataille) carte);
		}
		else if(carte instanceof Borne) {
			return estDepotBorneAutorise((Borne) carte);
		}
		
		else if(carte instanceof Limite) {
			return  estDepotLimiteAutorise((Limite) carte);
		}
		else if (carte instanceof Botte) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean estPrioritaire() {
		Botte vehicule = new Botte(Type.FEU);  
		if(bottes.contains(vehicule)) {
			return true;
		}
		return false;

	
	}
	
	
}
