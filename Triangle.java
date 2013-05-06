/**
 * classe Triangle
 * @author Morgane
 *
 */
public class Triangle extends Polygone{
	
	/**
	 * Ce constructeur instancie un triangle avec 
	 * des clics de souris (via le constructeur de Polygone).
	 */
	public Triangle(){
		super();
	}
	
	
	/**
	 * Cette méthode retourne en résultat le nombre de points de mémorisation d'un triangle.
	 */
	public int nbPoints(){
		return 3;
	}
	
	public int nbClics(){
		return 3;
	}
	

}
