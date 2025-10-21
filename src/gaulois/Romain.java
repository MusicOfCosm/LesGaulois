package gaulois;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "invariant : la force d’un Romain est toujours positive";
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le Romain " + this.nom + " : ";
	}

	private boolean isInvariantVerified() {
		return this.force >= 0;
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "pré-condition : la force du coup reçu est positive";
		int forceAvantCoup = this.force;
		
		this.force -= forceCoup;
		if (this.force < 1) {
			this.force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		
		assert isInvariantVerified() : "invariant : la force d’un Romain est toujours positive";
		assert forceAvantCoup > this.force : "post-condition : la force du Romain a diminué";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}

