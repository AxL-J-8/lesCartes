package cartes;

public abstract class Bataille extends Probleme {

	protected Bataille(int nbExenplaires, Type typeCarte) {
		super(nbExenplaires, typeCarte);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj.getClass() == getClass()) {
			Carte carte = (Bataille) obj;
			return toString().equals(carte.toString());
		}
		return false;
	}
}
