package jeu;

import java.util.HashSet;
import java.util.List;

import java.util.Set;
import java.util.TreeSet;

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
		Carte result = null;
		if (!sabot.isEmpty()) {
			result = sabot.remove(0);
		}
		return result;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public void setZoneDeJeu(ZoneDeJeu zoneDeJeu) {
		this.zoneDeJeu = zoneDeJeu;
	}

	public void deposer(Borne borne) {
		zoneDeJeu.addBorne(borne);
	}

	public int donnerKmParcourus() {
		int kmParcourus = 0;
		return kmParcourus;
	}

	public int donnerLimitationVitesse() {
		int result = 200;
		List<Limite> pileLimite = zoneDeJeu.getPileLimit();
		Set<Botte> bottes = new TreeSet<>();
		if (!pileLimite.isEmpty()) {
			Limite limite = pileLimite.get(0);
			if (!(limite instanceof FinLimite || ((!bottes.isEmpty()) && ((TreeSet<Botte>) bottes).last().getType() == Type.FEU))) {
				result = 50;
			}
		}
		return result;

	}

	public boolean estDepotAutorise(Carte carte) {
	
		return zoneDeJeu.estDepotAutorise(carte);
	}
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coups= new HashSet<>();
		for(Joueur joueur : participants) {
			
		}
		return coups;
	}

}
