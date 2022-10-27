package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public int getReputation() {
		return reputation;
	}

	public Yakuza(String nom, String boissonFavorite, int capital, String clan) {
		super(nom, boissonFavorite, capital);
		this.clan = clan;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		reputation++;
		parler("J’ai piqué les " + gain + " sous de " + victime.getNom() + ", ce qui me fait " + getCapital()
				+ " sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		reputation--;
		int argent = getCapital();
		perdreArgent(argent);
		parler("J'ai perdu mon duel et mes " + argent + " sous, snif... J'ai deshonore le clan de " + clan);
		return argent;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + "? Je l'ai dépouillé de ses "
				+ gain + " sous.");
	}

}
