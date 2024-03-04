package cartes;

public class Borne extends Carte {
	private int nbKilometres;

	public Borne( int nbkilometres,int nbExenplaires) {
		super(nbExenplaires);
		this.nbKilometres = nbkilometres;
	}

	public int getNbKilometres() {
		return nbKilometres;
	}

	public void setNbKilometres(int nbKilometres) {
		this.nbKilometres = nbKilometres;
	}

	@Override
	public String toString() {
		return nbKilometres + "km";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne carte) {
			return nbKilometres == carte.nbKilometres;
		}
		return false;
	}
}
