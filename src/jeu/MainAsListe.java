package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import cartes.Carte;

public class MainAsListe implements Main {

	private List<Carte> listeMain = new ArrayList<>();

	public MainAsListe() {
	}

	@Override
	public void prendre(Carte carte) {
		listeMain.add(carte);

	}

	@Override
	public void jouer(Carte carte) {
		assert listeMain.contains(carte);
		listeMain.remove(carte);

	}
	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		for (Carte carte : listeMain) {
			sb.append(carte+"\n");
		}
		return sb.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return listeMain.iterator();
	}


	


}
