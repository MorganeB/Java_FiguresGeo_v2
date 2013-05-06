import java.awt.event.*;
import java.util.EventListener;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import java.lang.Object;
/**
 * classe permettant de créer des figures géométriques
 * avec les clics de souris 
 * @author Morgane
 */
public class FabricantFigures implements MouseListener, MouseMotionListener{
	
	/**
	 *  Méthodes de l'interface "MouseListener" 
	 *  et MouseMotionListener non utilisées
	 */
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}

	/**
	 * Tableau des points correspondant aux clics de souris.
	 */
	private Point[] points_cliques; 
	
	/** Cumule le nombre de points cliqués.
	 */
	private int nb_points_cliques = 0; 
	
	/**
	 * Représente la figure en cours de fabrication
	 */
	private FigureColoree figure_en_cours_de_fabrication;
	
	/**
	 * Constructeur de la classe
	 * @param fc la figure à construire 
	 */
	public FabricantFigures(FigureColoree fc){
		figure_en_cours_de_fabrication = fc; 
			nb_points_cliques = 0;
			points_cliques = new Point[fc.nbClics()]; 
	}
	
	/**
	 * Méthode implémentant la création d'une forme géométrique 
	 * avec des clics de souris sur la fenetre
	 */
	public void mousePressed(MouseEvent e){
		if (figure_en_cours_de_fabrication != null){
			if(nb_points_cliques < points_cliques.length-1){
				points_cliques[nb_points_cliques] = new Point(e.getX(), e.getY());
				nb_points_cliques++;
			}else{
				points_cliques[nb_points_cliques] = new Point(e.getX(), e.getY());
				figure_en_cours_de_fabrication.modifierPoints(points_cliques);
				((DessinFigures)e.getSource()).ajoute(figure_en_cours_de_fabrication);
				((JComponent)(e.getSource())).removeMouseListener(this);
			}
		}
	}
	
	
}
