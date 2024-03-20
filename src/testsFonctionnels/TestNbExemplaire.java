package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.Utils;

public class TestNbExemplaire {

	public TestNbExemplaire() {

	}

	public static void main(String[] args) {
		

		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.checkCount());

		List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? " + Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));
	}
}
