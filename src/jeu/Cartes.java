package jeu;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Type;

public interface Cartes {

	// FEU
	Botte PRIORITAIRE = new Botte(Type.FEU, 1);
	Attaque FEU_ROUGE = new Attaque(Type.FEU, 5);
	Parade FEU_VERT = new Parade(Type.FEU, 14);

	/*
	 * //ESSENCE Botte CITERNE =new Botte(Type.ESSENCE, 1); Attaque
	 * PANNE_DESSENCE=new Attaque(Type.ESSENCE, 3); Parade ESSENCE=new
	 * Parade(Type.ESSENCE, 6);
	 * 
	 * // CREVAISON Botte INCREVABLE= new Botte(Type.CREVAISON, 1); Attaque
	 * CREVAISON=new Attaque(Type.CREVAISON, 3); Parade ROUE_DE_SECOURS=new
	 * Parade(Type.CREVAISON, 6);
	 * 
	 * //ACCIDENT Botte AS_DU_VOLANT=new Botte(Type.ACCIDENT, 1); Attaque
	 * ACCIDENT=new Attaque(Type.ACCIDENT, 3); Parade REPARATIONS=new
	 * Parade(Type.ACCIDENT, 6);
	 */

}
