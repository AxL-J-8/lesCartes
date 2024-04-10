package jeu;


import cartes.Carte;

public interface IMain extends Iterable<Carte> {
	public abstract void prendre(Carte carte);

	public abstract void jouer(Carte carte);

}
