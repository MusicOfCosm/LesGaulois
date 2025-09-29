package gaulois;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion() {
		return (this.quantitePotion > 0);
	}

	public int prendreLouche() {
		if (this.quantitePotion > 0) {
			this.quantitePotion--;
			return this.forcePotion;
		}
		return 0;
	}
}
