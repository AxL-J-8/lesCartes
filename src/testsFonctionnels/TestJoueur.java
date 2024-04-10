package testsFonctionnels;

import cartes.Borne;
import jeu.Joueur;

public class TestJoueur {
public static void main(String[] args) {
	Joueur joueur = new Joueur("milo");
	Borne borne25=new Borne(25, 1);
	Borne borne50=new Borne(50, 1);
	Borne borne100=new Borne(100, 1);
	
	joueur.deposer(borne25);
	System.out.println("Km parcouru : "+joueur.donnerKmParcourus()+" (Resultat attendu 25)");
	joueur.deposer(borne50);
	System.out.println("Km parcouru : "+joueur.donnerKmParcourus()+" (Resultat attendu 75)");
	joueur.deposer(borne100);
	System.out.println("Km parcouru : "+joueur.donnerKmParcourus()+" (Resultat attendu 175)");
}
}
