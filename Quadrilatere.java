import java.awt.*;


/**
 * Classe "Quadrilatere". Permet de faire des rectangles
 * et des quadrilatères quelconques 
 * @author Morgane
 *
 */
public class Quadrilatere  extends Polygone{
	
	
	/**
	 * Ce constructeur instancie un quadrilatère avec 
	 * des clics de souris).
	 */
	public Quadrilatere(){
		super();
	}
	
	/**
	 * Cette méthode retourne en résultat le nombre de points dont on a besoin, en général, pour la saisie d'un polygone.
	 */
	public int nbClics(){
		return 4;
	}
	
	/**
	 * Cette méthode retourne en résultat le nombre de points de mémorisation d'un quadrilatère.
	 */
	public int nbPoints(){
		return 4;
	}
	

}
