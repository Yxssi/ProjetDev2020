package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class optionMode {


    public static void main(String[] args) {
        new optionMode();
    }


    public optionMode() {

        JFrame menuScreen = new JFrame("Options");

        menuScreen.setVisible(true);
        menuScreen.setSize(400, 200);
        JPanel pan = new JPanel();
        menuScreen.setContentPane(pan);
        JButton b = new JButton("OPTIONS");
        menuScreen.getContentPane().add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                menuScreen.setVisible(false);
                menuScreen.setDefaultCloseOperation(menuScreen.EXIT_ON_CLOSE);
                menuScreen.dispose();
              //  seriousModeGame.fScreen.setVisible(false);


            }


        });
    }
}
