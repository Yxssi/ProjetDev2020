package view;

import view.welcomeMode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class optionMode {


    public static void main(String[] args) {
        JFrame menuScreen = new JFrame("Options");
        menuScreen.setVisible(true);
        menuScreen.setSize(400, 200);
        JPanel pan = new JPanel();
        menuScreen.setContentPane(pan);
        JButton b = new JButton("Options");
        menuScreen.getContentPane().add(b);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuScreen.setVisible(false);
                menuScreen.setDefaultCloseOperation(menuScreen.EXIT_ON_CLOSE);
                menuScreen.dispose();
                new welcomeMode();

            }

        });
    }


}









