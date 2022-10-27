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
	
}
