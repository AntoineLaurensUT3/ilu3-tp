package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getType().getParade();
			
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme pb) {
			return (getType().getParade()).equals(pb.getType().getParade());
		}
		return false;
	}

}
