package personnages;
import java.util.Random;

public class Traitre extends Samourai {
	int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonFavorite, int capital) {
		super(seigneur, nom, boissonFavorite, capital);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traitrise est : " + Integer.toString(niveauTraitrise) + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3 ) {
			int argentCommercant = commercant.getCapital();
			int argentRanconner = argentCommercant * 2/10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			parler("Si tu veux ma protection contre les Yakuzas il va falloir payer. Donne moi " + Integer.toString(niveauTraitrise) + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
			niveauTraitrise ++;
	} else parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me demasquer !");
	}
	
	public void faireLeGentil() {
		if (nbConnaissance<1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}
		else {
		Random rand = new Random();
		Humain ami = memoire[rand.nextInt(nbConnaissance-1)];
		String nomAmi = ami.getNom();
		int don = getCapital()/20;
		parler(" Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
		parler(" Bonjour l'ami ! Je voudrais vous aider en vous donnant " + Integer.toString(don) + " sous.");
		ami.gagnerArgent(don);
		perdreArgent(don);
		String nom = getNom();
		ami.parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
		if (niveauTraitrise>1) niveauTraitrise-- ; 
	}
	}
}

