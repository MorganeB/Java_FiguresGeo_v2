import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.EventListener;
import javax.swing.SwingUtilities;

public class TraceurForme implements MouseListener, MouseMotionListener, EventListener {

		/**
		 * variables contenant les coordonnées du dernier point tracé 
		 */
		private int last_x, last_y;
		
		/**
		 * le contexte graphique 
		 */
		private Graphics g;
		
		/**
		 * le constructeur 
		 * @param gr environnement graphique
		 */
		public TraceurForme(Graphics gr){
			this.g=gr;
		}
		
		/**
		 * Méthodes des interfaces "MouseListener" et "MouseMotioinListener" non utilisées.
		 */
		public void mouseClicked(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mouseMoved(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		
		
		/**
		 * methode appelée lorsqu'on clique sur le contenant 
		 */
		public void mousePressed(MouseEvent e){
			if(SwingUtilities.isLeftMouseButton(e)){
					last_x = e.getX();
					last_y = e.getY();
			}else{ 
				if(SwingUtilities.isRightMouseButton(e)){
					((JComponent)(e.getSource())).removeMouseListener(this);
					((JComponent)(e.getSource())).removeMouseMotionListener(this);
					((JComponent)(e.getSource())).repaint();
				}
			}
		}
		
		/**
		 * méthode appelée lorsque l'on clique avec la souris et qu'on déplace un composant
		 * dans la fenêtre 
		 */
		public void mouseDragged(MouseEvent e){
			g.drawLine(last_x, last_y, e.getX(), e.getY());
			last_x = e.getX();
			last_y = e.getY();
			}
}
