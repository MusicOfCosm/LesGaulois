package gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;
	
	public Village(String nom, Gaulois chef, final int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}
	
	public String getNom() {
		return this.nom;
	}
	public Gaulois getChef() {
		return this.chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		this.villageois[this.nbVillageois] = gaulois;
		this.nbVillageois++;
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois > this.nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		return this.villageois[numVillageois-1];
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village « " + this.nom + " » du chef " + this.chef +
				" vivent les légendaires gaulois :");
		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("- " + villageois[i]);
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		abraracourcix.setVillage(village);
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		
//		Gaulois gaulois = village.trouverVillageois(1);
//		System.out.println(gaulois);
//		gaulois = village.trouverVillageois(2);
//		System.out.println(gaulois);
		
		village.afficherVillage();
		
		asterix.sePresenter();
	}
}
