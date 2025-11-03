package gaulois;

import java.util.Objects;

public class Druide {
	private String nom;
	private int force;
    private Chaudron chaudron = new Chaudron();

    public Druide(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }


    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		this.chaudron.remplirChaudron(quantite, forcePotion);
		
		parler("J'ai concocté " + quantite + " doses de potion magique. " +
			   "Elle a une force de " + forcePotion + ".");
	}

	public void booster(Gaulois gaulois) {
		boolean contientPotion = this.chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();
		
		if (contientPotion) {
			if (Objects.equals(nomGaulois, "Obélix")) {
				parler("Non " + nomGaulois + ". Non !... Et tu le sais très bien !");
			} else {
                int forcePotion = this.chaudron.prendreLouche();
                gaulois.boirePotion(forcePotion);
                parler("Tiens " + nomGaulois + " un peu de potion magique.");
            }
		} else {
			parler("Désolé " + nomGaulois + " il n'y a plus une seule goutte de potion.");
		}
	}

	public String getNom() {
		return this.nom;
	}
}
