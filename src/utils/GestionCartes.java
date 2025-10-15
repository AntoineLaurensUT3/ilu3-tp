package utils;

import java.util.ArrayList;
import java.util.Iterator;

import cartes.Carte;
import java.util.Random;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class GestionCartes {

	public GestionCartes() {
		// TODO Auto-generated constructor stub
	}

	public static <E> ArrayList<E> extraire(ArrayList<E> l) {
		Random randomNumbers = new Random();
		int randomNum = randomNumbers.nextInt(l.size());
		l.remove(randomNum);
		return l;
	}
	
	public static <E> ArrayList<E> melanger(ArrayList<E> l){
		 ArrayList<E> melange = new  ArrayList<E>();
		for(Iterator<E> iter = l.iterator(); iter.hasNext();) {
			E elem = iter.next();
			iter.remove();
			melange.add(elem);
		}
		return melange;
	}
	
	public static <E> boolean verifierMelange(ArrayList<E> l1,ArrayList<E> l2 ) {
		
		for(Iterator<E> iter = l1.iterator(); iter.hasNext();) {
			E elem = iter.next();
			if(Collections.frequency(l1,elem) != Collections.frequency(l2,elem)) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public static <E> ArrayList<E> rassembler(ArrayList<E> l){
		ArrayList<E> consecutif = new  ArrayList<E>();
		
		for(Iterator<E> iter = l.iterator(); iter.hasNext();) {
			E elem = iter.next();
			if (consecutif.contains(elem)) {
				int index = consecutif.indexOf(elem);
				consecutif.add(index+1, elem);
			}
			else {
				consecutif.add(elem);
			}
		}
		
		return consecutif;
	}
	
	public static <E> boolean verifierRassemblement(ArrayList<E> l){
		
	}
	
	
	
	
}
