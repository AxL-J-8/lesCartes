package cartes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JeuDeCartes {
	private Carte[] typesDeCartes = new Carte[19];
	private List<Carte> listeCartes = new ArrayList<>();

	private void initialiserTableauCarte() {
		// AJOUT ATTAQUES
		typesDeCartes[0] = new Attaque(Type.ACCIDENT, 3);// ACCIDENT
		typesDeCartes[1] = new Attaque(Type.CREVAISON, 3);// CREVAISON
		typesDeCartes[2] = new Attaque(Type.ESSENCE, 3);// PANNE D'ESSENCE
		typesDeCartes[3] = new DebutLimite(4);// DEBUT LIMITE
		typesDeCartes[4] = new Attaque(Type.FEU, 5);// FEU ROUGE

		// AJOUT PARADES
		typesDeCartes[5] = new Parade(Type.ACCIDENT, 6);// REPARATION
		typesDeCartes[6] = new Parade(Type.CREVAISON, 6);// ROUE DE SECOURS
		typesDeCartes[7] = new Parade(Type.ESSENCE, 6);// BIDON D'ESSENCE
		typesDeCartes[8] = new FinLimite(6);// DEBUT LIMITE
		typesDeCartes[9] = new Parade(Type.FEU, 14);// FEU VERT

		// AJOUT BORNES
		typesDeCartes[10] = new Borne(200, 4);
		typesDeCartes[11] = new Borne(100, 12);
		typesDeCartes[12] = new Borne(75, 10);
		typesDeCartes[13] = new Borne(50, 10);
		typesDeCartes[14] = new Borne(25, 10);

		// AJOUT BOTTES
		typesDeCartes[15] = new Botte(Type.ACCIDENT, 1);// AS DU VOLANT
		typesDeCartes[16] = new Botte(Type.CREVAISON, 1);// INCREVABLE
		typesDeCartes[17] = new Botte(Type.ESSENCE, 1);// CITERNE
		typesDeCartes[18] = new Botte(Type.FEU, 1);// VEHICULE PRIORITAIRE
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

	public JeuDeCartes() {
		initialiserTableauCarte();
		ajouterFamilleCarte(typesDeCartes);
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}

	public void setListeCartes(List<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}

	private int countCard(Carte carte) {
		int count = 0;
		for (Iterator<Carte> iterator = listeCartes.iterator(); iterator.hasNext();) {
			Carte carteListe = iterator.next();
			if (carte.equals(carteListe))
				count++;
		}
		return count;
	}

	public boolean checkCount() {
		int count;
		boolean result = true;
		for (int i = 0; i < typesDeCartes.length; i++) {
			count = countCard(typesDeCartes[i]);
			result = result && (count == typesDeCartes[i].getNombre());
		}
		return result;
	}
}
