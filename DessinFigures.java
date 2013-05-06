import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

/**
 * Chaque instance de cette classe est un dessin 
 * comportant plusieurs figures colorées visualisables à l'écran dont une seule est sélectionnée.
 * @author Morgane
 *
 */

public class DessinFigures extends JPanel{

	/**
	 *  Nombre effectif de figures apparaissant dans ce dessin.
	 */
	private int nbf;
	
	/**
	 * Indice de la figure actuellement sélectionnée (-1 si aucune figure n'est sélectionnée).
	 */
	private int sel;
	
	/**
	 * Tableau pouvant contenir jusqu'à 100 figures à visualiser et manipuler
	 */
	private FigureColoree[] figures;
	
	
	/**
	 * Constructeur vide : dessin ne contenant aucune figure
	 */
	public DessinFigures(){
		figures = new FigureColoree[100]; 
		nbf = 0;
		sel = -1 ;
	}
	
	/**
	 *  Cette méthode permet d'ajouter une nouvelle figure au dessin.
	 * @param fc une nouvelle figure passee en parametre
	 */
	public void ajoute(FigureColoree fc){
		if(fc != null){
		// on met la figure dans le tableau = operation d'ajout
			figures[nbf] = fc;
			if(sel != -1) 
				figures[sel].deSelectionne();
				sel = nbf;
				fc.selectionne();
				nbf ++;
			}
		//provoque l'execution de paintComponent
		repaint();
	}
	

	/**
	 * Cette méthode redessine toutes les figures du dessin.
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < nbf; i++)
			figures[i].affiche(g);
	}
	
	/**
	 *  Cette méthode retourne la figure actuellement sélectionnée.
	 * @return figure sélectionnée (ou null) si aucune figure n'est sélectionnée.
	 */
	public FigureColoree figureSelection(){
		if(sel != -1)
			return figures[sel];
		else
			return null;
	}
	
	/**
	 * méthode d'accès 
	 * @return Nombre effectif de figures du le dessin
	 */
	public int nbFigures(){
		return nbf;
	}
	
	
	/**
	 * Cette méthode selectionne la prochaine figure dans le tableau des figures
	 */
	public void selectionProchaineFigure(){
		figures[sel ++].deSelectionne();
		this.sel ++;
		if(sel == nbf)
			sel = 0;
		figures[sel].selectionne();
	}

	
	/**
	 * Cette méthode permet d'initier le mécanisme événementiel d'un tracé quelconque à la souris
	 * @param c la couleur du trait 
	 */
	public void trace(Color c){
		Graphics cg =  this.getGraphics();
			cg.setColor(c);
			TraceurForme tf = new TraceurForme(cg);
			this.addMouseListener(tf);
			this.addMouseMotionListener(tf);
	}
	
	/**
	 * Cette méthode permet d'initier le mécanisme événementiel de fabrication des figures à la souris (ajout du listener).
	 * @param f la figure 
	 */
	public void construit(FigureColoree f){
		FabricantFigures fc = new FabricantFigures(f);
		addMouseListener(fc);
	}
	
	/**
	 *  Cette méthode active les manipulations d'une figure géométrique avec la souris.
	 */
	public void activeManipulationsSouris(){
		ManipulateurFormes mf = new ManipulateurFormes();
		addMouseListener(mf);
		addMouseMotionListener(mf);
	}

	
	/* ***********************************************************************
	 * ******** classe interne ***********************************************
	 ********************************************************************** */
	
	private class ManipulateurFormes implements MouseListener, MouseMotionListener {
		
		/**
		 * abscisse d'un clic de souris
		 */
		private int last_x;
		
		/**
		 * ordonnée d'un clic de souris
		 */
		private int last_y;
		
		/**
		 * constructeur 
		 */
		public ManipulateurFormes(){
			last_x = 0;
			last_y = 0;
		}
		

		/**
		 * Redéfinition des méthodes des interfaces
		 */
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
		
		/**
		 * Méthode implémentant la construction et la sélection 
		 * d'une forme géométrique avec des clics de souris.
		 */
		public void mousePressed(MouseEvent e){
			if(SwingUtilities.isLeftMouseButton(e)){
				last_x = e.getX();
				last_y = e.getY();
				if(sel != -1){
					FigureColoree fc = figures[sel];
					fc.deSelectionne();
					sel = -1;
				}
				for(int i = 0; i < nbf; i++){
					FigureColoree fc =  figures[i];
					if (fc.estDedans(e.getX(), e.getY())) {
						fc.selectionne();
						sel = i;
						i = nbf; 
					}
				}
			}
			if (SwingUtilities.isRightMouseButton(e)){
				removeMouseListener(this);
				removeMouseMotionListener(this);
			}			
		
		}
		
		/**
		 * cette méthode permet de déplacer une
		 *  figure géométrique à l'aide de la souris.
		 */
		public void mouseDragged(MouseEvent e){
			if (SwingUtilities.isLeftMouseButton(e)) {
				if (sel != -1) {
					FigureColoree fc = figures[sel];
						fc.translation(e.getX() - last_x, e.getY() - last_y);
						last_x = e.getX();
						last_y = e.getY();
				}
			}
			repaint();
		}
		
	}
	
	
}
