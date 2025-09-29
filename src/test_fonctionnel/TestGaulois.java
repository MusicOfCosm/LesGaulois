package test_fonctionnel;

import gaulois.Gaulois;
import gaulois.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Gaulois obelix = new Gaulois("Ob�lix", 16);
		Romain minus = new Romain("Minus", 6);
		
		asterix.parler("Bonjour Ob�lix.");
		obelix.parler("Bonjour Ast�rix. �a te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui, tr�s bonne id�e.");
		
		System.out.println("Dans la for�t, " + asterix.getNom() + " et " + obelix.getNom()
		+ " tombent nez � nez sur le romain " + minus.getNom() + ".");
		
		
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		
		System.out.println("\n---------------\n");
		
		
	}
}
