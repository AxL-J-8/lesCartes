package cartes;

public class Botte extends Probleme  {

	public Botte(Type typeCarte, int nbExenplaires) {
		super(nbExenplaires, typeCarte);
	}

	@Override
	public String toString() {
		Type typeCarte = super.getType();
		switch (typeCarte) {
		case FEU:
			return "Vehicule Prioritaire";
		case ESSENCE:
			return "Citerne";
		case CREVAISON:
			return "Increvable";
		case ACCIDENT:
			return "As du volant";
		}
		return "";
	}


     
}
