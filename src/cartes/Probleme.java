package cartes;

import java.util.Objects;

public abstract class Probleme extends Carte {
	private Type type;

	@Override
	public int hashCode() {
		return this.hashCode()+31*type.hashCode();
	}

	

	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	

}
