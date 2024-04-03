package jeu;

import java.util.ArrayList;
//import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
//import java.util.NoSuchElementException;

import cartes.Carte;

public class MainAsListe implements Main {

	private int nombreOperations = 0;
	private int nbCartes = 0;
	private List<Carte> listeMain = new ArrayList<>();

	public MainAsListe() {
		nombreOperations = 0;
		nbCartes = 0;
	}

	@Override
	public void prendre(Carte carte) {
		listeMain.add(carte);

	}

	@Override
	public void jouer(Carte carte) {
		assert listeMain.contains(carte);
		listeMain.remove(carte);

	}
	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		for (Carte carte : listeMain) {
			sb.append(carte+"\n");
		}
		return sb.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return listeMain.iterator();
	}

//	private class Iterateur implements Iterator<Carte> {
//		private int indiceIterateur = 0;
//		private boolean nextEffectue = false;
//		private int nombreOperationsReference = nombreOperations;
//
//		@Override
//		public boolean hasNext() {
//			return indiceIterateur < nbCartes;
//		}
//
//		@Override
//		public Carte next() {
//			verificationConcurrence();
//			if (hasNext()) {
//				Carte carte = listeMain[indiceIterateur];
//				indiceIterateur++;
//				nextEffectue = true;
//				return carte;
//			} else {
//				throw new NoSuchElementException();
//			}
//		}
//
//		@Override
//		public void remove() {
//			verificationConcurrence();
//			if (nbCartes < 1 || !nextEffectue) {
//				throw new IllegalStateException();
//			}
//			for (int i = indiceIterateur - 1; i < nbCartes; i++) {
//				listeMain[i] = listeMain[i + 1];
//			}
//			nextEffectue = false;
//			indiceIterateur--;
//			nbCartes--;
//			nombreOperations++;
//			nombreOperationsReference++;
//		}
//
//		private void verificationConcurrence() {
//			if (nombreOperations != nombreOperationsReference)
//				throw new ConcurrentModificationException();
//		}

	


}
