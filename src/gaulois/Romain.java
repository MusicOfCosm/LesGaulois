package gaulois;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[] = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "invariant : la force d'un Romain est toujours positive";
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
		
		assert isInvariantVerified() : "invariant : la force d'un Romain est toujours positive";
		assert forceAvantCoup > this.force : "post-condition : la force du Romain a diminué";
	}
	
	
	private void metEquipement(int index, Equipement equipement) {
		System.out.println("Le soldat " + this.nom + " s'équipe avec un " +
							equipement.toString() + ".");
		this.equipements[index] = equipement;
		this.nbEquipement++;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		
		case 1:
			if (this.equipements[0].toString() == equipement.toString()) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " +
									equipement.toString() + " !");
			} else {
				metEquipement(1, equipement);
			}
			break;
			
		case 0:
			metEquipement(0, equipement);

		default:
			break;
		}
	}
	
//	public Equipement[] recevoirCoup(int forceCoup) {
//		Equipement[] equipementEjecte = null;
//		forceCoup = CalculResistanceEquipement(forceCoup);
//		force -= forceCoup;
//		switch (force) {
//			case 0:
//				parler("Aïe");
//				break;
//			default:
//				equipementEjecte = ejecterEquipement();
//				parler("J'abandonne...");
//				break;
//		}
//		return equipementEjecte;
//	}
	
//	private int CalculResistanceEquipement(int forceCoup) {
//		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
//		int resistanceEquipement = 0;
//		if (!(nbEquipement == 0)) {
//			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
//			for (int i = 0; i < nbEquipement;) {
//				if ((equipements[i] != null &&
//				equipements[i].equals(Equipement.BOUCLIER)) == true) {
//					resistanceEquipement += 8;
//				} else {
//					System.out.println("Equipement casque");
//					resistanceEquipement += 5;
//				}
//				i++;
//			}
//			texte =+ resistanceEquipement + "!";
//		}
//		parler(texte);
//		forceCoup -= resistanceEquipement;
//		return forceCoup;
//	}
	
//	private Equipement[] ejecterEquipement() {
//		Equipement[] equipementEjecte = new Equipement[nbEquipement];
//		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
//		//TODO
//		int nbEquipementEjecte = 0;
//		for (int i = 0; i < nbEquipement; i++) {
//			if (equipements[i] == null) {
//				continue;
//			} else {
//				equipementEjecte[nbEquipementEjecte] = equipements[i];
//				nbEquipementEjecte++;
//				equipements[i] = null;
//			}
//		}
//		return equipementEjecte;
//	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}

