package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements Main {
	
 List<Carte> listeCarte=new ArrayList<>();
	public MainAsListe() {
	}

	@Override
	public void prendre(Carte carte) {
		listeCarte.add(carte);

	}

	@Override
	public void jouer(Carte carte) {
		assert listeCarte.contains(carte);
		listeCarte.remove(carte);

	}


}
