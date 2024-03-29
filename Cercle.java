import java.awt.*;
/**
 * Classe "Cercle".
 * @author Morgane
 *
 */
public class Cercle extends ConiqueCentree{
	
	private double rayon;
	
	/**
	 * Ce constructeur instancie un cercle .
	 */
	public Cercle(){
		super();
	}
	
	/**
	 * Retourne le rayon du cercle.
	 * @return le rayon du cercle
	 */
	public double rendreRayon(){
		return rayon;
	}
	
	/**
	 *  Cette m�thode retourne en r�sultat le nombre de points 
	 *  de m�morisation d'un cercle.
	 */
	public int nbPoints() {
		return 2;
	}

	/**
	 * Cette m�thode retourne en r�sultat le nombre de points dont 
	 * on a besoin pour la saisie d'un cercle.
	 */
	public int nbClics() {
		return 2;
	}

	/**
	 *  M�thode affichant un cercle (grace � fillOval de Graphics)
	 *  @param g objet Graphics 
	 */
	public void affiche(Graphics g){
		g.setColor(couleur);
		g.drawOval(centre.rendreX() - (int)(rayon), centre.rendreY() - (int)(rayon), (int)(rayon * 2), (int)(rayon * 2));
		super.affiche(g);
	}

	
	/**
	 * Cette m�thode modifie le cercle conform�ment � un ensemble de deux points de saisie.
	 */
	public void modifierPoints(Point[] ps) {
		if(ps!=null){
			if(ps.length == 2){
				tab_mem[0] = ps[0];
				tab_mem[1] = ps[1];
				centre =  new Point((int)((tab_mem[0].rendreX() + tab_mem[1].rendreX()) / 2), 
						(int)((tab_mem[0].rendreY() + tab_mem[1].rendreY()) / 2));
			}
		}
		rayon = centre.distance(tab_mem[0]);
	}
		
	
	/**
	 * Cette m�thode retourne vrai si le point dont les coordonn�es 
	 * sont pass�es en param�tre se trouve � l'int�rieur du cercle.
	 */
	public boolean estDedans(int a, int b){
		Point p = new Point(a, b);
		if(p.distance(centre) <= (int)rayon)
			return true;
		else
			return false;
	}
	

	

}
