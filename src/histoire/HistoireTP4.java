package histoire;
import personnages.*;

public class HistoireTP4 {
	
	public static void main(String[] args) {
		Humain romain = new Humain("Romain", "granite citron", 54);
		romain.direBonjour();
		romain.acheter("boisson", 12);
		romain.boire();
		romain.acheter("jeu", 2);
		romain.acheter("kimono", 50);
		Commercant marco = new Commercant("Marco",20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoirArgent(15);
		marco.boire();
		Yakuza yaku = new Yakuza("Yaku le daltonien","whisky",30,"Warsong");
		yaku.direBonjour();
		yaku.extorquer(marco);
		Ronin roro = new Ronin("Roro","Scotch",60);
		roro.direBonjour();
		roro.donner(marco);
		roro.provoquer(yaku);
	}

}
