	import java.awt.Color;
import java.awt.Graphics;

/**
 * Cette classe abstraite représente le sommet de la hiérarchie d'héritage 
 * de n'importe quelle figure géométrique visualisable à l'écran et manipulable à la souris. 
 * Cette classe s'inspire du fonctionnement des logiciels de dessin vectoriel, où une figure est : 
 * - définie à l'aide de points de saisie (par exemple les deux extrémités d'une diagonale d'un rectangle).<br> 
 * - mémorisée comme un ensemble de points qui permettent de la manipuler (par exemple les 4 sommets d'un rectangle)<br>
 * @author Morgane
 *
 */

public abstract class FigureColoree extends Point{
	
	/**
	 * Attribut booléen indiquant si la figure est sélectionnée (son affichage est alors différent).
	 */
	private boolean selected;
	
	/**
	 * Attribut de type Color donnant la couleur de remplissage.
	 */
	protected Color couleur;
	
	/**
	 * Tableau des points de mémorisation de la figure ( = les points des sommets)
	 */
	protected Point [] tab_mem;
	

	
	/** classe abstraite mais avec un constructeur quand meme
	 * pour initialiser les attributs pour les autres classes 
	 * qui feront appel à ce constructeur 
	 */ 
	public FigureColoree(){
		super();
		tab_mem = new Point[this.nbPoints()];
		selected = false;
		couleur = Color.black;
	}
	
	/**
	 * Méthode d'accès
	 * @return la couleur de l'objet
	 */
	public Color getCouleur(){
		return couleur;
	}
	
	/**
	 * Méthode abstraite
	 * @return le nombre de points de mémorisation
	 */
	public abstract int nbPoints();
	
	/**
	 * Méthode abstraite
	 * @return le nombre de points de saisie (nombre de clics).
	 */
	public abstract int nbClics();
	
	/**
	 * Méthode abstraite qui permet de modifier les points de mémorisation à partir de points de saisie.
	 * @param ps points de saisie
	 */
	public abstract void modifierPoints(Point[] ps);
	
	
	/**
	 * Méthode d'affichage de la figure.
	 * @param g environnement graphique
	 */
	public void affiche(Graphics g){	
		if(selected){
			//g.setColor(Color.magenta);
			for(int i = 0; i < tab_mem.length; i++){
				g.fillRect(tab_mem[i].rendreX() -2, tab_mem[i].rendreY() -2, 4, 4);
				g.setColor(couleur);
			}
		}
	}
	
	/**
	 * Cette méthode sélectionne la figure.
	 */
	public void selectionne(){
		selected = true;
	}

	/**
	 * Cette méthode désélectionne la figure.
	 */
	public void deSelectionne(){
		selected = false;
	}
	
	/**
	 * Méthode permettant de changer la couleur de la figure.
	 * @param c nouvelle couleur
	 */
	public void changeCouleur(Color c){
		this.couleur = c;
	}
	
	/**
	 * Cette méthode permet d'effectuer une translation 
	 * des coordonnées des points de mémorisation de la figure.
	 * On appelle la méthode translation de la classe Point pour chaque point de la figure 
	 * @param dx, dy les nouvelles coordonnees
	 */
	 public void translation(int dx, int dy){
		 for(int i = 0; i < tab_mem.length; i++)
			tab_mem[i].translation(dx, dy);
	}
	 
	 /**
	  * méthode abstraite qui retourne vrai si le point dont les coordonnées sont passées 
	  * en paramètre se trouve à l'intérieur de la figure.
	  * @param a coordonnées
	  * @param b coordonnées 
	  * @return boolean 
	  */
	 public abstract boolean estDedans(int a, int b);
	
		
}
