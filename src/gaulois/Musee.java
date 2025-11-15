package gaulois;

import objets.Equipement;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[this.nbTrophee] = new Trophee(gaulois, equipement);
		this.nbTrophee++;
	}
	
	public void extraireInstructionsOCaml() {
		String texte = "let musee = [";
		for (int i = 0; i < this.nbTrophee; ++i) {
			String nom = this.trophees[i].donnerNom();
			Equipement equipement = this.trophees[i].getEquipement();
			texte += "\n    \"" + nom + "\", \"" + equipement + "\"" + (i != this.nbTrophee - 1 ? ";" : "");
		}
		texte += "\n]";
		System.out.println(texte);
	}
}
