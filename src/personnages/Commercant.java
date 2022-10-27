package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int capital) {
		super(nom,"the", capital);
	}
	
	public int seFaireExtorquer() {
		parler("J’ai tout perdu! Le monde est trop injuste...");
		int perte = getCapital();
		perdreArgent(perte);
		return perte;
	}
	
	public void recevoirArgent(int gain) {
		parler(gain + " sous ! Je te remercie genereux donateur !");
		gagnerArgent(gain);
	}
	
}
