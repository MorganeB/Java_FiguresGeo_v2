
public abstract class ConiqueCentree extends FigureColoree {

	/**
	 * centre de la figure conique centr�e
	 */
	protected Point centre;
	
	/**
	 * constructeur 
	 */
	public ConiqueCentree(){
		super();
		centre = new Point((int)(Math.random() * 600), (int)(Math.random() * 600));
}
	
	/**
	 * m�thode d'acc�s
	 * @return le centre de la figure (Premier point de m�morisation)
	 */
	public Point rendreCentre() {
    	return this.tab_mem[0];
    }
	
	/**
	 * Cette m�thode permet d'effectuer une translation d'une conique centree.
	 * @param dx d�placement sur l'axe des abscisses.
	 * @param dy d�placement sur l'axe des ordonn�es.
	 */
	public void translation(int dx, int dy){
			super.translation(dx, dy);
			centre.translation(dx, dy);
	}


	
}
