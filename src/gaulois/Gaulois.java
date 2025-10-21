package gaulois;

import java.util.Objects;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le Gaulois " + this.nom + " : ";
	}
	
	public String toString() {
		return this.nom;
	}
	
	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
		
		int forceCoup = force * this.effetPotion / 3;
		romain.recevoirCoup(forceCoup);
		if (effetPotion > 1)
			effetPotion--;
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	public void sePresenter() {
		String intro = "Bonjour, je m'appelle ";
		if (this.village == null) {
			parler(intro + this.nom + ". Je voyage de villages en villages.");
		} else if (Objects.equals(this.village.getChef(), this)) {
			parler(intro + this.nom + ". Je suis le chef du village " + this.village.getNom() + ".");
		} else {
			parler(intro + this.nom + ". J'habite le village " + this.village.getNom() + ".");
		}
	}
	
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}	
}
