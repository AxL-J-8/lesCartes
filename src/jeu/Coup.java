package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	private Carte carte;
	private Joueur cible;

	public Coup(Carte carte, Joueur joueur) {
		this.carte = carte;
		this.cible = joueur;
	}

	public Joueur getCible() {
		return cible;
	}

	public void setCible(Joueur cible) {
		this.cible = cible;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public boolean estValide(Joueur joueur) {
		if (cible.estDepotAutorise(carte)) {
			if (joueur.equals(cible)) {
				return !((carte instanceof Limite) || (carte instanceof Attaque));
			} else {
				return true;
			}
		}
		return false;
	}

}