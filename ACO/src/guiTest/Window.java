
package guiTest;
import java.awt.*;
import javax.swing.*;
 
public class Window extends JFrame{
	public Window(){
    //Définit un titre pour notre fenêtre
    this.setTitle("textEditor");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    this.setSize(1000, 700);
    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    //Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);        
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(pan); 
    //Et enfin, la rendre visible
    
    TextZone jta = new TextZone();
    this.setContentPane(jta);
    this.setVisible(true);
	}
}
