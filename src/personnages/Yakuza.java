package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;
	
	
	public Yakuza(String nom, String boissonFavorite, int capital, String clan) {
		super(nom, boissonFavorite, capital);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		reputation ++;
		parler("J’ai piqué les " + gain + " sous de " + victime.getNom() + ", ce qui me fait " + getCapital() + " sous dans ma poche. Hi ! Hi !");
	}

}
