/**
 * classe Rectangle 
 * @author Morgane
 *
 */
public class Rectangle extends Quadrilatere{

	/**
	 *  Ce constructeur instancie un rectangle selon les clics de souris
	 */
	public Rectangle(){
		super();
    }
	
	/**
	 * Cette méthode retourne en résultat le nombre de points 
	 * dont on a besoin pour la saisie d'un rectangle.
	 */
	public int nbClics(){
		return 2;
	}
	
	/**
	 * Cette méthode modifie le rectangle avec deux points de saisie. Ces deux points forment une diagonale du rectangle.
	 * @param tab_saisie tableau contenant les nouveaux points de saisie.
	 */
	public void modifierPoints(Point[] tab_saisie){
		if(tab_saisie.length == 2){
			tab_mem[0] = tab_saisie[0];
			tab_mem[2] = tab_saisie[1];
			tab_mem[1] = new Point (tab_saisie[1].rendreX(),tab_saisie[0].rendreY());
			tab_mem[3] = new Point(tab_saisie[0].rendreX(), tab_saisie[1].rendreY());
		}
	}



}
