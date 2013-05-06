import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

/**
 * Chaque instance de cette classe est un dessin 
 * comportant plusieurs figures color�es visualisables � l'�cran dont une seule est s�lectionn�e.
 * @author Morgane
 *
 */

public class DessinFigures extends JPanel{

	/**
	 *  Nombre effectif de figures apparaissant dans ce dessin.
	 */
	private int nbf;
	
	/**
	 * Indice de la figure actuellement s�lectionn�e (-1 si aucune figure n'est s�lectionn�e).
	 */
	private int sel;
	
	/**
	 * Tableau pouvant contenir jusqu'� 100 figures � visualiser et manipuler
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
	 *  Cette m�thode permet d'ajouter une nouvelle figure au dessin.
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
	 * Cette m�thode redessine toutes les figures du dessin.
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < nbf; i++)
			figures[i].affiche(g);
	}
	
	/**
	 *  Cette m�thode retourne la figure actuellement s�lectionn�e.
	 * @return figure s�lectionn�e (ou null) si aucune figure n'est s�lectionn�e.
	 */
	public FigureColoree figureSelection(){
		if(sel != -1)
			return figures[sel];
		else
			return null;
	}
	
	/**
	 * m�thode d'acc�s 
	 * @return Nombre effectif de figures du le dessin
	 */
	public int nbFigures(){
		return nbf;
	}
	
	
	/**
	 * Cette m�thode selectionne la prochaine figure dans le tableau des figures
	 */
	public void selectionProchaineFigure(){
		figures[sel ++].deSelectionne();
		this.sel ++;
		if(sel == nbf)
			sel = 0;
		figures[sel].selectionne();
	}

	
	/**
	 * Cette m�thode permet d'initier le m�canisme �v�nementiel d'un trac� quelconque � la souris
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
	 * Cette m�thode permet d'initier le m�canisme �v�nementiel de fabrication des figures � la souris (ajout du listener).
	 * @param f la figure 
	 */
	public void construit(FigureColoree f){
		FabricantFigures fc = new FabricantFigures(f);
		addMouseListener(fc);
	}
	
	/**
	 *  Cette m�thode active les manipulations d'une figure g�om�trique avec la souris.
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
		 * ordonn�e d'un clic de souris
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
		 * Red�finition des m�thodes des interfaces
		 */
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
		
		/**
		 * M�thode impl�mentant la construction et la s�lection 
		 * d'une forme g�om�trique avec des clics de souris.
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
		 * cette m�thode permet de d�placer une
		 *  figure g�om�trique � l'aide de la souris.
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
