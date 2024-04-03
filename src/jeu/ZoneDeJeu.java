package jeu;

import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Limite;

public class ZoneDeJeu {
	private List<Limite> pileLimit = new LinkedList<>();
	private List<Bataille> pileBataille = new LinkedList<>();
	private List<Borne> pileBorne = new LinkedList<>();
	private NavigableSet<Botte> bottes = new TreeSet<>();

	public ZoneDeJeu() {
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

	public List<Borne> getPileBorne() {
		return pileBorne;
	}

	public void setPileBorne(List<Borne> pileBorne) {
		this.pileBorne = pileBorne;
	}

	public void addBorne(Borne borne) {
		pileBorne.add(borne);
	}

	public void addBataille(Bataille bataille) {
		pileBataille.add(bataille);
	}

	public void addlimite(Limite limite) {
		pileLimit.add(limite);
	}

	public void addBotte(Botte botte) {
		bottes.add(botte);
	}

}
