package milleBorne;

public class Attaque extends Bataille {

	public Attaque(int nbExenplaires, Type typeCarte) {
		super(nbExenplaires, typeCarte);

	}
	   @Override
	   public String toString() {
	     Type typeCarte=super.getType();
	     switch(typeCarte){
	     case FEU:
	    	 return "Feu Rouge";
	     case ESSENCE :
	    	 return "Panne d'essence";
	     case CREVAISON:
	    	 return "Crevaison";
	     case ACCIDENT:
	    	 return "Accident";
	     }
		return "";
	   }
}
