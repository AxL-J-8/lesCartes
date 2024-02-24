package milleBorne;

public abstract class Carte {
	private int nombre;
	protected Carte(int nbExenplaires) {
		this.nombre=nbExenplaires;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

}




