package milleBorne;

public class Parade extends Bataille {

	public Parade(int nbExenplaires, Type typeCarte) {
		super(nbExenplaires, typeCarte);
	}
	@Override
	public String toString() {
		Type typeCarte=super.getType();
		switch(typeCarte){
		case FEU:
			return "Feu Vert";
		case ESSENCE :
			return "Bidon d'essence";
		case CREVAISON:
			return "Roue de secours";
		case ACCIDENT:
			return "Reparations";
		}
		return "";
	}
}
