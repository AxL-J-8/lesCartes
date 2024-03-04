package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] jeuDeCarte;
	private final int NB_CARTE_MAX;
	private int nbCartes = 0;
	private int nombreOperations = 0;

	public Sabot(int capacite) {
		this.jeuDeCarte = new Carte[capacite];
		this.NB_CARTE_MAX = capacite;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	private void ajouterCarte(Carte carte) throws ArrayIndexOutOfBoundsException {
		if (nbCartes > NB_CARTE_MAX) {
			throw new ArrayIndexOutOfBoundsException("Limite du sabot depasee");
		} else {
			jeuDeCarte[nbCartes] = carte;
			nbCartes++;
			nombreOperations++;
		}
	}

	public void ajouterFamilleCarte(Carte carte) {
		int limite = carte.getNombre();

		for (int i = 0; i < limite; i++) {

			try {
				ajouterCarte(carte);
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}

		}
	}

	public void ajouterFamilleCarte(Carte... cartes) {
		for (Carte carte : cartes) {

			try {
				ajouterFamilleCarte(carte);
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}

		}
	}

	public Carte piocher() {
		Iterator<Carte> monIterateur = iterator();
		Carte maCarte = null;
		if (monIterateur.hasNext()) {
			maCarte = monIterateur.next();
			monIterateur.remove();
		}
		return maCarte;
	}

	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationsReference = nombreOperations;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = jeuDeCarte[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur - 1; i < nbCartes; i++) {
				jeuDeCarte[i] = jeuDeCarte[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nombreOperations++;
			nombreOperationsReference++;
		}

		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference)
				throw new ConcurrentModificationException();
		}

	}

}
