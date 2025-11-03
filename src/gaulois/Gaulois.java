package gaulois;

import java.util.Objects;
import objets.Equipement;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private Village village;
	
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
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
		return "Le gaulois " + nom + " : ";
	}
	
	public String toString() {
		return this.nom;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " +
		romain.getNom());
		Equipement[] tropheesRecu = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRecu != null && i < tropheesRecu.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRecu[i];
		}
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
