package cartes;

public abstract class Probleme extends Carte {
	private Type type;

	protected Probleme(int nbExenplaires, Type typeCarte) {
		super(nbExenplaires);
		this.setType(typeCarte);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj.getClass() == getClass()) {
			Probleme carte = (Probleme) obj;
			return type.equals(carte.type);
		}
		return false;
	}
}
