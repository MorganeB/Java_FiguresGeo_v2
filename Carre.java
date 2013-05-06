/**
 * classe Carre 
 * @author Morgane
 *
 */
public class Carre extends Quadrilatere {
	
	/**
	 * constructeur vide permettant d'initialiser un carré 
	 * avec des clics de souris
	 */
	public Carre(){
		super();
	}
	
	/**
	 * Cette méthode modifie le carré conformément à un ensemble de deux points de saisie
	 */
	public void modifierPoints(Point[] tab_saisie){
		tab_mem[0] = tab_saisie[0];
		tab_mem[1] = tab_saisie[1];
		tab_mem[2] = new Point(tab_mem[1].rendreY()-tab_mem[0].rendreY()+tab_mem[1].rendreX(),(tab_mem[0].rendreX())-tab_mem[1].rendreX()+tab_mem[1].rendreY());
		tab_mem[3] = new Point(tab_mem[1].rendreY()-tab_mem[0].rendreY()+tab_mem[0].rendreX(),(tab_mem[0].rendreX())-tab_mem[1].rendreX()+tab_mem[0].rendreY());
	}

	/**
	 * Cette méthode retourne en résultat le nombre de points dont on a besoin 
	 * pour la saisie d'un carré
	 */
	public int nbClics(){
		return 2;
	}
}
