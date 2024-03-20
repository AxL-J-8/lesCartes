package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;

public class TestEgaliteCarte {

	public TestEgaliteCarte() {

	}

	public static void main(String[] args) {
		Borne borne1 = new Borne(25, 0);
		Borne borne2 = new Borne(25, 0);
		Borne borne3 = new Borne(50, 0);

		DebutLimite limite1 = new DebutLimite(50);
		DebutLimite limite2 = new DebutLimite(50);

		FinLimite limiteFin1 = new FinLimite(50);

		Botte botte1 = new Botte(Type.FEU, 0);
		Botte botte2 = new Botte(Type.FEU, 0);
		Botte botte3 = new Botte(Type.ACCIDENT, 0);

		Parade parade1 = new Parade(Type.FEU, 0);
		Parade parade2 = new Parade(Type.FEU, 0);
		Parade parade3 = new Parade(Type.ACCIDENT, 0);

		Attaque attaque1 = new Attaque(Type.FEU, 0);
		Attaque attaque2 = new Attaque(Type.FEU, 0);
		Attaque attaque3 = new Attaque(Type.ACCIDENT, 0);

		System.out.println(borne1.equals(borne2));
		System.out.println(borne1.equals(borne3));
		System.out.println(borne1.equals(limite1));
		System.out.println(borne1.equals(null));

		System.out.println(botte1.equals(botte2));
		System.out.println(botte1.equals(botte3));
		System.out.println(botte1.equals(parade1));

		System.out.println(limite1.equals(limite2));
		System.out.println(limite1.equals(limiteFin1));
		System.out.println(limite1.equals(borne1));

		System.out.println(parade1.equals(parade2));
		System.out.println(parade1.equals(parade3));

		System.out.println(attaque1.equals(attaque2));
		System.out.println(attaque1.equals(attaque3));

	}

}
