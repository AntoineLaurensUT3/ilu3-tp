package cartes;

import java.util.Objects;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Borne "+ km + " km" ;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return km==(borne.km);
		}
		return false;
	}
	
	

}
