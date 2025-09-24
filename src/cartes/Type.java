package cartes;

public enum Type {
	FEU("Véhicule Prioritaire","Feu rouge", "Feu vert"), ESSENCE("Citerne","Panne d'essence","Essence"), CREVAISON("Increvable","Crevaison","Roue de secours"), 
	ACCIDENT("As du volant","Accident","Réparation");
	private String parade;
	private String attaque;
	private String botte;
	Type(String string, String string2, String string3) {
		string = botte;
		string2 = attaque;
		string3 = parade;
	}
	public String getParade() {
		return parade;
	}
	public String getAttaque() {
		return attaque;
	}
	public String getBotte() {
		return botte;
	}
	
	
}
