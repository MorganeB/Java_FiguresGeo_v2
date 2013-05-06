import java.awt.*;

/**
 * Cette classe abstraite est la super classe de tous les polygones.
 * @author Morgane
 *
 */
public abstract class Polygone extends FigureColoree{

	private Polygon p;
	
	/**
	 * Constructeur vide : fabrique un polygone aux sommets aléatoires.
	 */
	public Polygone(){
		super();
	}
	
	/**
	 * Cette méthode retourne vrai si le point 
	 * dont les coordonnées sont passées en paramètre se trouve à l'intérieur du polygone.
	 */
	public boolean estDedans(int a, int b){
		
		if(p.contains(a, b)){
			return true;
		}
		else
			return false;
	} 
	
	/**
	 * Méthode affichant un polygone (fait appel à drawPolygon de la classe Java Polygon).
	 * @param g - contexte graphique.
	 */
	public void affiche(Graphics g){
		p = new Polygon();
			for(int i = 0; i < tab_mem.length; i++){
				p.addPoint(tab_mem[i].rendreX(), tab_mem[i].rendreY());
			}
			g.setColor(this.getCouleur());
			g.drawPolygon(p);
			super.affiche(g);
	}
	
	/**
	 * Cette méthode modifie le polygone conformément à un ensemble 
	 * de points de saisie (ses nouveaux sommets).
	 */
	 public void modifierPoints(Point[] tab_saisie){
		 if(tab_saisie!=null){
			 for(int i = 0; i < tab_mem.length; i++)
				 this.tab_mem = tab_saisie;
		 }
	 }
	 
	 
}
