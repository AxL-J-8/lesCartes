package jeu;

import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import cartes.Bataille;
import cartes.Botte;
import cartes.Limite;

public class Joueur {
	private String nom;
	private List<Limite> pileLimit = new LinkedList<>();
	private List<Bataille> pileBataille = new LinkedList<>();
	private NavigableSet<Botte> bottes = new TreeSet<>();

	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Limite> getPileLimit() {
		return pileLimit;
	}

	public void setPileLimit(List<Limite> pileLimit) {
		this.pileLimit = pileLimit;
	}

	public List<Bataille> getPileBataille() {
		return pileBataille;
	}

	public void setPileBataille(List<Bataille> pileBataille) {
		this.pileBataille = pileBataille;
	}
	

	public NavigableSet<Botte> getBottes() {
		return bottes;
	}

	public void setBottes(NavigableSet<Botte> bottes) {
		this.bottes = bottes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return nom.equals(joueur.nom);
		}
		return false;
	}
	 
	@Override
	public String toString() {
		return nom;
	}
}
