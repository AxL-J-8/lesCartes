package cartes;

public class Parade extends Bataille {

	public Parade( Type typeCarte,int nbExenplaires) {
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
