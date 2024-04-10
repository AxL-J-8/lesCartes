package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Set;
import java.util.TreeSet;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Type;

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
		Carte carte = null;
		if (!sabot.isEmpty()) {
			carte = sabot.remove(0);
			main.prendre(carte);
		}
		return carte;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public void setZoneDeJeu(ZoneDeJeu zoneDeJeu) {
		this.zoneDeJeu = zoneDeJeu;
	}

	public boolean deposer(Borne borne) {

		return zoneDeJeu.deposer(borne);

	}

	public boolean deposer(Limite limite) {

		return zoneDeJeu.deposer(limite);

	}

	public boolean deposer(Bataille bataille) {

		return zoneDeJeu.deposer(bataille);

	}

	public boolean deposer(Botte botte) {

		return zoneDeJeu.deposer(botte);

	}

	public int donnerKmParcourus() {
		return zoneDeJeu.kmParcourus();
	}

	public int donnerLimitationVitesse() {

		return zoneDeJeu.donnerLimitationVitesse();

	}

	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}

	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coups = new HashSet<>();

		for (Joueur joueur : participants) {
			for (Iterator<Carte> iterMain = main.iterator(); iterMain.hasNext();) {
				Carte carte = iterMain.next();
				Coup coup = new Coup(carte, joueur);
				if (coup.estValide(joueur)) {
					coups.add(coup);
				}

			}
		}
		return coups;
	}

	public void coupsDefausse() {
		for (Iterator<Carte> iterMain = main.iterator(); iterMain.hasNext();) {
			Carte carte = iterMain.next();
			Coup coup = new Coup(carte, null);
		}
	}

}
