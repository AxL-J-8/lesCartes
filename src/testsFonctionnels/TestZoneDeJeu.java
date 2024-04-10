package testsFonctionnels;

import java.util.TreeSet;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Type;
import jeu.Cartes;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {

	public static void main(String[] args) {
		ZoneDeJeu zone = new ZoneDeJeu();
		Attaque accident=new Attaque(Type.ACCIDENT, 3);
		Botte asDuVolant=new Botte(Type.ACCIDENT, 1);
		Attaque panneDessence=new Attaque(Type.ESSENCE, 3);
		Parade essence=new Parade(Type.ESSENCE, 6);
		
		zone.deposer(Cartes.FEU_ROUGE);
		System.out.println(zone.estBloque());
		zone.deposer(Cartes.PRIORITAIRE);
		System.out.println(zone.estBloque());
		zone.deposer(accident);
		System.out.println(zone.estBloque());
		zone.deposer(asDuVolant);
		System.out.println(zone.estBloque());
		zone.deposer(panneDessence);
		System.out.println(zone.estBloque());
		zone.deposer(essence);
		System.out.println(zone.estBloque());
		zone.setBottes(new TreeSet<>());	
		System.out.println(zone.estBloque());
		zone.deposer(Cartes.FEU_VERT);
		System.out.println(zone.estBloque());
		
		
		
		
		
		
	}
}
