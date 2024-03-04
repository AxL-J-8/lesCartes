package cartes;

public class Attaque extends Bataille {

	public Attaque( Type typeCarte,int nbExenplaires) {
		super(nbExenplaires, typeCarte);

	}
	@Override
	public String toString() {
		Type typeCarte=super.getType();
		switch(typeCarte){
		case FEU:
			return "Feu Rouge";
		case ESSENCE :
			return "Panne d'essence";
		case CREVAISON:
			return "Crevaison";
		case ACCIDENT:
			return "Accident";
		}
		return "";
	}


}
