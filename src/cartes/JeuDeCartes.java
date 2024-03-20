package cartes;


import java.util.LinkedList;
import java.util.List;

import utils.Utils;

public class JeuDeCartes {
	private List<Carte> listeCartes = new LinkedList<>();

	private Carte[] typesDeCartes = {
			// ATTAQUES
			new Attaque(Type.ACCIDENT, 3), new Attaque(Type.CREVAISON, 3), new Attaque(Type.ESSENCE, 3),
			new DebutLimite(4), new Attaque(Type.FEU, 5),

			// PARADES
			new Parade(Type.ACCIDENT, 6), new Parade(Type.CREVAISON, 6), new Parade(Type.ESSENCE, 6), new FinLimite(6),
			new Parade(Type.FEU, 14),

			// BORNES
			new Borne(200, 4), new Borne(100, 12), new Borne(75, 10), new Borne(50, 10), new Borne(25, 10),

			// BOTTES
			new Botte(Type.ACCIDENT, 1), new Botte(Type.CREVAISON, 1), new Botte(Type.ESSENCE, 1),
			new Botte(Type.FEU, 1) };

	public JeuDeCartes() {
		ajouterFamilleCarte(typesDeCartes);
		listeCartes=Utils.melanger(listeCartes);
		//TODO 3 7
	}

	public void ajouterFamilleCarte(Carte... cartes) {
		int limite;
		for (Carte carte : cartes) {
			limite = carte.getNombre();

			for (int i = 0; i < limite; i++) {
				listeCartes.add(carte);
			}
		}
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}

	public void setListeCartes(List<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}

	private int countCard(Carte carte) {
		int count = 0;
		for (Carte carteListe:listeCartes) {
			if (carte.equals(carteListe))
				count++;
		}
		return count;
	}

	public boolean checkCount() {
		for (Carte carte : typesDeCartes) {
			if(countCard(carte) !=carte.getNombre()) {
				return false;
			}
		}
		return true;
	}
}
