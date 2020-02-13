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
        JButton LuffyOption = new JButton("Modifier Option de Luffy");
        JButton NarutoOption = new JButton("Modifier Option de Naruto");
        JButton b = new JButton("Lire les instructions");

        menuScreen.getContentPane().add(b);
        menuScreen.getContentPane().add(NarutoOption);
        menuScreen.getContentPane().add(LuffyOption);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                menuScreen.setVisible(false);
                menuScreen.setDefaultCloseOperation(menuScreen.EXIT_ON_CLOSE);
                menuScreen.dispose();
                new instructionsMode();


            }


        });

        LuffyOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionLuffy();
            }
        });


    }

    public static void optionLuffy(){
        databseElements.getConnection();
        databseElements.updateLuffy();

        return;

    }
}
