package jeu;

import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

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

	public void setPileBataille(List<Bataille> pileBataille) {
		this.pileBataille = pileBataille;
	}

	public void setBottes(NavigableSet<Botte> bottes) {
		this.bottes = bottes;
	}

	public void setPileBorne(List<Borne> pileBorne) {
		this.pileBorne = pileBorne;
	}

	public boolean deposer(Carte carte) {
		if (!estDepotAutorise(carte)) {
			return false;
		}

		if (carte instanceof Borne borne) {
			pileBorne.add(0, borne);
		}
		if (carte instanceof Botte botte) {
			bottes.add(botte);
		}
		return true;
	}

	public boolean deposer(Borne borne) {
		pileBorne.add(0, borne);
		return true;
	}

	public boolean deposer(Bataille bataille) {
		pileBataille.add(0, bataille);
		return true;
	}

	public boolean deposer(Limite limite) {
		pileLimit.add(0, limite);
		return true;
	}

	public boolean deposer(Botte botte) {
		bottes.add(botte);
		return true;
	}

	public int kmParcourus() {
		int kmTotal = 0;
		for (Borne borne : pileBorne) {
			kmTotal += borne.getNbKilometres();
		}
		return kmTotal;
	}

	private boolean estPrioritaire() {
		return (bottes.contains(Cartes.PRIORITAIRE));
	}

	public int donnerLimitationVitesse() {
		int result = 200;

		if (!pileLimit.isEmpty()) {
			Limite sommetlimite = pileLimit.get(0);
			if (!(sommetlimite instanceof FinLimite || estPrioritaire())) {

				result = 50;
			}
		}
		return result;

	}

	private boolean contientBotte(Bataille attaque) {
		Type type = attaque.getType();
		boolean result = false;
		for (Botte botte : bottes) {
			if (botte.getType().equals(type)) {
				result = true;
			}
		}
		return result;
	}

	public boolean estBloque() {
		if (!pileBataille.isEmpty()) {
			Bataille sommet = pileBataille.get(0);
			return !((estPrioritaire() && (sommet instanceof Parade || sommet.equals(Cartes.FEU_ROUGE)
					|| ((sommet instanceof Attaque attaque) && contientBotte(attaque))))
					|| sommet.equals(Cartes.FEU_VERT));
		}
		return !(pileBataille.isEmpty() && estPrioritaire());
	}

	private boolean estDepotLimiteAutorise(Limite carte) {
		if (carte instanceof FinLimite) {
			return pileLimit.get(0) instanceof DebutLimite;
		}
		return pileLimit.isEmpty() || (pileLimit.get(0) instanceof FinLimite);
	}

	private boolean estDepotBatailleAutorise(Bataille carte) {
		if (!contientBotte(carte)) {
			if (carte instanceof Attaque) {
				return !estBloque();
			} else if (carte.equals(Cartes.FEU_VERT)) {
				return verifFeuVert(carte);
			} else {
				return !pileBataille.isEmpty();
			}
		}
		return false;
	}

	private boolean verifFeuVert(Bataille carte) {
		if (!pileBataille.isEmpty()) {
			Bataille sommet = pileBataille.get(0);
			return sommet.equals(Cartes.FEU_ROUGE) || sommet instanceof Parade && (!sommet.equals(carte));
		}
		return true;
	}

	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Botte) {
			return true;
		} else if (carte instanceof Borne borne) {
			return (!estBloque()) && borne.getNbKilometres() < 50 && kmParcourus() <= 1000;
		} else if (carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		} else if (carte instanceof Bataille bataille) {

			return estDepotBatailleAutorise(bataille);
		}
		return true;
	}

}
