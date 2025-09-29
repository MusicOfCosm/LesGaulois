package gaulois;

public class Druide {
	private String nom;
	private int force;
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + " �");
	}
	
	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		Chaudron chaudron = new Chaudron();
		chaudron.remplirChaudron(quantite, forcePotion);
		
		parler("J'ai concoct� " + quantite + " doses de potion magique. " +
			   "Elle a une force de " + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois) {
		Chaudron chaudron = new Chaudron();
		boolean contientPotion = chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();
		
		if (contientPotion) {
			if (nomGaulois == "Ob�lix") {
				parler("Non " + nomGaulois + ". Non !... Et tu le sais tr�s bien !");
			}
			int forcePotion = chaudron.prendreLouche();
			gaulois.boirePotion(forcePotion);
			parler("Tiens " + nomGaulois + " un peu de potion magique.");
		} else {
			parler("D�sol� " + nomGaulois + " il n'y a plus une seule goutte de potion.");
		}
	}

	public String getNom() {
		return nom;
	}
}
