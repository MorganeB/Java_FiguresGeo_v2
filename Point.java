/**
 * classe Point
 * @author Morgane
 *
 */
public class Point {
	
	/**
	 * abscisse et ordonnee
	 */
	private int x, y;
	
	
	/**
	 *  Constructeur de la classe "Point".
	 */
	public Point(){
		x = 0;
		y = 0;
	}
	
	/**
	 *  Constructeur de la classe "Point" 
	 *  avec des coordonnees donnees.
	 * @param a abscisse
	 * @param b ordonnee
	 */
	public Point(int a, int b){
		x=a;
		y=b;
	}
	
	
	/**
	 *  Méthode calculant la distance entre deux points.
	 * @param p2 le 2eme point
	 * @return la distance
	 */
	public double distance(Point p2){
		int abs, ord;
		abs = (this.x - p2.x);
		ord = (this.y - p2.y);
		abs = abs*abs;
		ord = ord*ord;
	return Math.sqrt(abs+ord);
  	
	}
	
	/**
	 *  Méthode renvoyant l'abscisse du point.
	 * @return abscisse 
	 */
	public int rendreX(){
    	return x;
    }
	
	/**
	 * Méthode renvoyant l'ordonnée du point
	 * @return ordonnee
	 */
	 public int rendreY() {
    	return y;
   }
	 
	 /**
	  * Méthode translatant le point.
	  * @param dx ajout a l'abscisse
	  * @param dy ajout à l'ordonnee
	  */
	 public void translation(int dx, int dy){
			x = x + dx;
			y = y + dy;
	}
		
	
	 
	 
	 
}
