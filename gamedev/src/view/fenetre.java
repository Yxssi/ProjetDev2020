package view;

import javax.swing.*;

public class fenetre extends JFrame {
    public static JFrame fScreen;
    String titreFenetre;





    public void fenetreGame() {
        titreFenetre = "Luffy vs Naruto";
        fScreen = new JFrame(titreFenetre);
    }
}
