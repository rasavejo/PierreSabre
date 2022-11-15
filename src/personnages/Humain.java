package personnages;

public class Humain {
	static int TAILLE_MEMOIRE = 30;
	private String nom;
	private String boissonFavorite;
	private int capital;
	protected int nbConnaissance = 0;
	protected Humain[] memoire = new Humain[TAILLE_MEMOIRE] ;
	
	public Humain(String nom, String boissonFavorite, int capital) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.capital = capital;
	}
	
	
	public String getNom() {
		return nom;
	}
	public int getCapital() {
		return capital;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour, je m'apelle " + nom + " et j'aime boire du " + boissonFavorite);
	}
	
	public void boire() {
		parler("Mmmmm, un bon verre de " + boissonFavorite + " ! Gloups !");
	}
	
	protected void gagnerArgent(int gain) {
		capital += gain;
	}
	
	protected void perdreArgent(int perte) {
		capital -= perte;
	}
	
	public void acheter(String bien,int prix) {
		if (prix > capital) {
			parler("Je n'ai plus que " + capital + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous.");
		} else {
			parler("J'ai " + capital + " en poche, je vais pouvoir m'offrir un " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
	}
	
	private void memoriser(Humain humain) {
		Boolean connu = false;
		for (int i = 0;i<nbConnaissance && !connu ;i++) {
			if (memoire[i] == humain) connu = true;
		}
		if (!connu) {
			if (nbConnaissance < TAILLE_MEMOIRE) {
				memoire[nbConnaissance] = humain;
				nbConnaissance ++;
			} else {
				for (int i = 0;i<TAILLE_MEMOIRE-1;i++) {
					memoire[i] = memoire[i+1];
				}
				memoire[TAILLE_MEMOIRE-1] = humain;
			}
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String connaissances = "Je connais beaucoup de monde dont : ";
		connaissances += memoire[0].getNom();
		for (int i = 1;i<nbConnaissance;i++) {
			connaissances += ",";
			connaissances += memoire[i].getNom();
		}
		parler(connaissances);
	}
}
