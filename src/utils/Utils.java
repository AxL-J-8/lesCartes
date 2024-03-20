package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Utils {
	private static Random rand = new Random();

	public static <E> E extraire(List<E> liste) {

		if (!liste.isEmpty()) {
			int index = rand.nextInt(liste.size());
			return liste.remove(index);
		}

		return null;

	}

	public static <E> List<E> melanger(List<E> liste) {
		E elem;
		List<E> listeMelangee = new ArrayList<>();
		int limit = liste.size();
		for (int i = 0; i < limit; i++) {
			elem = extraire(liste);
			listeMelangee.add(elem);
		}

		return listeMelangee;
	}

	public static <E> boolean verifierMelange(List<E> listeOrigine, List<E> listeResultat) {

		if (verifierPresence(listeOrigine, listeResultat)) {
			return verifierPresence(listeResultat, listeOrigine);
		}
		return false;
	}

	private static <E> boolean verifierPresence(List<E> liste1, List<E> liste2) {
		for (E elem : liste1) {
			if ((Collections.frequency(liste1, elem) != Collections.frequency(liste2, elem))) {
				return false;
			}
		}
		return !(liste1.isEmpty());
	}

	public static <E> List<E> rassembler(List<E> liste) {
		List<E> listeTri = new ArrayList<>();
		int index;
		for (E elem : liste) {
			if (!listeTri.contains(elem)) {
				listeTri.add(elem);
			} else {
				index = listeTri.lastIndexOf(elem);
				listeTri.add(index, elem);
			}

		}
		return listeTri;
	}

	public static <E> boolean verifierRassemblement(List<E> liste) {
		E elementCourrant = liste.get(0);
		E elementSuivant = liste.get(1);
        if(liste.isEmpty())return false;
        
		for (ListIterator<E> iterator = liste.listIterator(1); iterator.hasNext();) {
			if (elementSuivant.equals(elementCourrant)) {
				elementSuivant = iterator.next();
			} else {
				if(trouverElementFinDeListe(liste,elementCourrant, elementSuivant))return false;
				elementCourrant = elementSuivant;
			}
		}
		return true;
	}

	private static <E> boolean trouverElementFinDeListe(List<E> liste, E elementCourrant, E elementSuivant) {
		int index;
		index = liste.indexOf(elementSuivant);
		for (ListIterator<E> iterator2 = liste.listIterator(index); iterator2.hasNext();) {
			E elementRecherche = iterator2.next();
			if(elementRecherche.equals(elementCourrant))
				return false;
		}
		return true;
	}
}
