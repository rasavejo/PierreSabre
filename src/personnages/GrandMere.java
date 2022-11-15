package personnages;
import java.util.Random;


public class GrandMere extends Humain {
	static int TAILLE_MEMOIRE = 5;

	public GrandMere(String nom, int capital) {
		super(nom, "tisane", capital);
	}
	
	private enum TypeHumains {HABITANT("habitant"),RONIN("ronin"),YAKUZA("yakuza"),SAMOURAI("samourai"),COMMERCANT("commercant"),GRANDMERE("Grand mere");
		private String nom;
		
		private TypeHumains(String nom) {
			this.nom = nom;
		}
		
		public String toString() {
			return(nom);
		}
		
	}
	
	private String humainHasard() {
		Random rand = new Random();
		TypeHumains[] types = TypeHumains.values();
		return types[rand.nextInt(5)].toString();
	}

	public void radoter() {
		for (int i = 0;i<nbConnaissance;i++) {
			Humain perso = memoire[i];
			if (perso instanceof Traitre) {
				parler("Je sais que " + perso.getNom() + " est un traître. Petit chenapan !"); }
				else {
					parler("Je crois que " + perso.getNom() +  " est un " + humainHasard());
				}
			}
		}
	}
