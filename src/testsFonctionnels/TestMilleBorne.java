package testsFonctionnels;
import java.util.Scanner;
import java.util.Iterator;

import jeu.Sabot;
import milleBorne.Attaque;
import milleBorne.Botte;
import milleBorne.Carte;
import milleBorne.Parade;
import milleBorne.Type;

public class TestMilleBorne {


	public static void main(String[] args) {
		Carte maCarte;
		
		Attaque accident = new Attaque(3,Type.ACCIDENT);
		Parade parade= new Parade(6, Type.ACCIDENT);
		Botte botte = new Botte(1, Type.ACCIDENT);
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
				Iterator<Carte> monIterateur =sabot.iterator();
				while(monIterateur.hasNext()) 
				{
					maCarte=monIterateur.next();
					monIterateur.remove();

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
