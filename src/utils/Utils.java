package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Utils {
	private static Random rand = new Random();

	public static <E> E extraire(E[] liste) {
		int index = rand.nextInt(liste.length);
		E elem = liste[index];
		for (int i = index; i < liste.length - 1; i++) {
			liste[i] = liste[i + 1];
		}

		return elem;

	}

	public static <E> E extraire(List<E> liste) {

		int index = rand.nextInt(liste.size());
		E elem = liste.get(index);
		liste.remove(elem);

		return elem;

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

	public static <E> boolean verifierMelange(List<E> liste1, List<E> liste2) {
		boolean result = true;
		E elem;
		for (ListIterator<E> iterator = liste1.listIterator(); iterator.hasNext();) {
			elem = iterator.next();
			result = result && (Collections.frequency(liste1, elem) == Collections.frequency(liste2, elem));
		}
		return result;
	}

	public static <E> List<E> rassembler(List<E> liste) {
		List<E> listeTri = new ArrayList<>();
		E elem;
		int index;
		for (ListIterator<E> iterator = liste.listIterator(); iterator.hasNext();) {
			elem = iterator.next();
				if (!listeTri.contains(elem)) {
					listeTri.add(elem);
				}
				else {
					index=listeTri.lastIndexOf(elem);
					listeTri.add(index, elem);
				}

		}
		return listeTri;
	}

	public static <E> boolean verifierRassemblement(List<E> liste) {
		boolean result = true;
		int index;
		E elem1 = liste.get(0);
		E elem2 = liste.get(1);
		E elem3 = null;

		for (ListIterator<E> iterator = liste.listIterator(1); iterator.hasNext();) {
			if (elem2.equals(elem1)) {
				elem2 = iterator.next();
			} else {
				index = liste.indexOf(elem2);
				for (ListIterator<E> iterator2 = liste.listIterator(index); iterator2.hasNext();) {
					elem3 = iterator2.next();
					result = result && (!elem3.equals(elem1));
				}
				elem1 = elem2;
			}

		}

		return result;
	}
}
