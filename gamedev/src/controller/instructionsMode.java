package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class instructionsMode {


    public static void main(String[] args) {
        new optionMode();
    }


    public instructionsMode() {

        JFrame menuScreen = new JFrame("Instructions");

        menuScreen.setVisible(true);
        menuScreen.setSize(400, 200);
        JPanel pan = new JPanel();
        menuScreen.setContentPane(pan);
        String endl = System.getProperty("line.separator");
        String attackInstruction = "Utilisez x pour attaquer avec Luffy ou z pour utiliser son attaque spéciale";
        JTextArea text = new JTextArea();
        text.setLineWrap(false);

        text.setText("Controllez les mouvements Naruto à l'aide des fléches haut et bas et Luffy à l'aide des flèches gauche et droit " +
                attackInstruction + " vous pouvez également attaquer avec Naruto en appuyant sur c ou e pour son attaque spéciale");
        pan.add(text);


    }
}

// code finale
