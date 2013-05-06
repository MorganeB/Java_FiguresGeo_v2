import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Cette classe est le point d'entrée du programme de visualisation
 * et de manipulation de figures à l'écran
 * @author Morgane
 */
public class Dialogue {
	/** 
	 * Cette méthode crée une fenétre dans laquelle aucune figure
	 * n'apparaét, puis organise un dialogue avec l'utilisateur,
	 * de maniére à lui proposer de fabriquer une nouvelle figure
	 * géométrique, d'effectuer une opération sur la figure actuellement
	 * sélectionnée, ou de changer de figure sélectionnée.
	 * 
	 * @param args arguments du programme
	 */
	public static void main(String[] args) throws java.io.IOException {
		JFrame fenetre=new JFrame("Premiéres figures");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DessinFigures dessin=new DessinFigures();
		dessin.setPreferredSize(new Dimension(600,600));
		fenetre.setContentPane(dessin);
		fenetre.pack();
		fenetre.setVisible(true);
		Scanner scan;
		scan = new Scanner(System.in);
		int rep, rep2;
		while (true) {
			System.out.println("Voulez-vous :");
			System.out.println("   1- fabriquer une figure ");
			System.out.println("   2- tracer une forme à main levee ");
			System.out.println("   3- effectuer des manipulations de figures à la souris ");
			rep=scan.nextInt();
			if (rep==1) {
				System.out.println("\nVoulez-vous construire :");
				System.out.println("   1 - un rectangle");
				System.out.println("   2 - un carré");
				System.out.println("   3 - un triangle ");
				System.out.println("   4 - un cercle ");
				System.out.println("   5 - un quadrilatere");
				rep2=scan.nextInt();
				FigureColoree fc = null;
				switch (rep2) {
				case 1:
					fc=new Rectangle();
					break;
				case 2:
					fc = new Carre();
					break;
				case 3:
					fc=new Triangle();
					break;
				case 4:
					fc=new Cercle();
					break;
				case 5:
					fc=new Quadrilatere();
					break;
				}
				System.out.println("Cliquez sur les "+fc.nbClics() +" points qui definissent la figure");
				System.out.println("puis faites Entrée pour continuer");
				dessin.construit(fc);
				System.in.read();
				System.out.println("\n\n\n");
			}
			if (rep==2) {
				dessin.trace(Color.black);
				System.out.println("Pour tracer : bouton gauche tenu\n");
				System.out.println("Quand vous avez fini, cliquez sur le bouton droit");
				System.out.println("puis faites Entrée pour continuer");
				System.in.read();
			}
			if (rep==3) {
				dessin.activeManipulationsSouris();
				System.out.println("Quand vous avez fini, cliquez sur le bouton droit");
				System.out.println("puis faites Entrée pour continuer");
				System.in.read();
			}
		}
	}
}