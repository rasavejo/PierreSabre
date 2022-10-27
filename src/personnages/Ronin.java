package personnages;

public class Ronin extends Humain{
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int capital) {
		super(nom, boissonFavorite, capital);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = getCapital() / 10;
		perdreArgent(don);
		parler(beneficiaire.getNom() + " prend ces " + don + " sous." );
		beneficiaire.recevoirArgent(don);
	}
	
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouve vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		if (honneur*2 >= adversaire.getReputation()) {
			parler("Je t’ai eu petit yakusa!");
			int gain = adversaire.perdre();
			gagnerArgent(gain);
			honneur++;
		} else {
			parler(" J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			int perte = getCapital();
			perdreArgent(perte);
			adversaire.gagner(perte);
			honneur--;
		}
	}
}
