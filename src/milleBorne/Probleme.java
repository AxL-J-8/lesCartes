package milleBorne;

public abstract class Probleme extends Carte {
	private Type type;
	protected Probleme(int nbExenplaires,Type typeCarte) {
		super(nbExenplaires);
		this.setType(typeCarte);
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
