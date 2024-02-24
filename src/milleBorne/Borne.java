package milleBorne;

public class Borne extends Carte {
	private int nbKilometres;
	public Borne(int nbExenplaires,int nbkilometres) {
		super(nbExenplaires);
		this.nbKilometres=nbkilometres;
	}

	public int getNbKilometres() {
		return nbKilometres;
	}

	public void setNbKilometres(int nbKilometres) {
		this.nbKilometres = nbKilometres;
	}

	@Override
	public String toString() {
		return nbKilometres+"km";
	}
}
