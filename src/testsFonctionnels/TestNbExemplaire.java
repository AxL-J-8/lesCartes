package testsFonctionnels;

import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestNbExemplaire {

	public TestNbExemplaire() {

	}

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.checkCount());
	}
}
