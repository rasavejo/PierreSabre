package histoire;
import personnages.Humain;

public class HistoireTP4 {
	
	public static void main(String[] args) {
		Humain romain = new Humain("romain", "granite citron", 54);
		romain.direBonjour();
		romain.acheter("boisson", 12);
		romain.boire();
		romain.acheter("jeu", 2);
		romain.acheter("kimono", 50);
	}

}
