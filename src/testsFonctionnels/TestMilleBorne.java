package testsFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class TestMilleBorne {


	public static void main(String[] args) {
		Carte maCarte;

		Attaque accident = new Attaque(Type.ACCIDENT,3);
		Parade parade= new Parade( Type.ACCIDENT,6);
		Botte botte = new Botte( Type.ACCIDENT,1);
		Sabot sabot = new Sabot(110);


		for (int choix=1;choix<4;choix++) {
			
			sabot.ajouterFamilleCarte(accident);
			sabot.ajouterFamilleCarte(parade);
			sabot.ajouterFamilleCarte(botte);

			if(choix==1)
			{
				System.out.println("TEST AVEC PIOCHER");
				while((maCarte=sabot.piocher())!=null) 
				{
					System.out.println("je pioche "+maCarte);
				}

			}
			else 
			{
				System.out.println("\nTEST AVEC ITERATEUR " + choix);

				for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) 
				{
					maCarte=iterator.next();
					iterator.remove();

					/*PARTIE 3*/
					if(choix==3) 
					{
						sabot.piocher();
						sabot.ajouterFamilleCarte(botte);
					}
					System.out.println("je pioche "+maCarte);
				}
			}


		}}
}
