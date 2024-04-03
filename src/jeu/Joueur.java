package jeu;

import java.util.List;

import cartes.Borne;
import cartes.Carte;
import cartes.Limite;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
	private MainAsListe main = new MainAsListe();

	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return nom.equals(joueur.nom);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}

	@Override
	public String toString() {
		return nom;
	}

	public MainAsListe getMain() {
		return main;
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}

	public Carte prendreCarte(List<Carte> sabot) {
		Carte result = null;
		if (!sabot.isEmpty()) {
			result = sabot.remove(0);
		}
		return result;
	}
	public void  deposer(Borne borne) {
		zoneDeJeu.addBorne(borne);
	}
	
	public int donnerKmParcourus() {
		int kmParcourus =0;
		List<Borne>bornes=zoneDeJeu.getPileBorne();
		for (Borne borne : bornes) {
			kmParcourus+= borne.getNbKilometres();
		}
		return kmParcourus;
	}


}
