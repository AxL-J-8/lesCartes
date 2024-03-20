package jeu;


import cartes.Carte;

public interface Main extends Iterable<Carte> {
	public abstract void prendre(Carte carte);

	public abstract void jouer(Carte carte);

}
