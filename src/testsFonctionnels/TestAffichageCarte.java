package testsFonctionnels;

import java.util.Iterator;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestAffichageCarte {

	public TestAffichageCarte() {

	}

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarte = jeu.getListeCartes();
		for (Iterator<Carte> iterator = listeCarte.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			System.out.println(carte);
		}
	}

}
