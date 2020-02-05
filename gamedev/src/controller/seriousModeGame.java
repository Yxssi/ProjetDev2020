package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;


public class seriousModeGame extends JFrame{

    public static JFrame fScreen;

    JLabel humHolder, comHolder;
    JPanel pBackground;
    static ImageIcon human;
    static ImageIcon computer;
    JPanel healthBarNaruto;
    JPanel healthBarLuffy;
    static JProgressBar ProgressHealthBar;
    static JProgressBar ProgressHealthBarNaruto;
    JButton button;
    boolean getDown;
    static int life = 100;
    int game = 1;
// Damage damage = new Damage();

    static ImageIcon[] hStandR = new ImageIcon[2];
    static ImageIcon[] hStandL = new ImageIcon[2];
    static ImageIcon[] cStandR = new ImageIcon[2];
    static ImageIcon[] cStandL = new ImageIcon[2];
    static int hStandCtr;
    static int hStandIndex;
    static int cStandCtr;
    static int cStandIndex;

    static ImageIcon[] hRunR = new ImageIcon[8];
    static ImageIcon[] hRunL = new ImageIcon[8];
    static ImageIcon[] cRunR = new ImageIcon[8];
    static ImageIcon[] cRunL = new ImageIcon[8];
    static int hRunCtr;
    static int hRunIndex;
    static int cRunCtr;
    static int cRunIndex;

    static ImageIcon[] hGutlingR = new ImageIcon[4];
    static ImageIcon[] hGutlingL = new ImageIcon[4];
    static ImageIcon[] cDamageR = new ImageIcon[4];
    static ImageIcon[] cDamageL = new ImageIcon[4];
    static ImageIcon[] cGetUpR = new ImageIcon[4];
    static ImageIcon[] cGetUpL = new ImageIcon[4];
    static int hGunCtr;
    static int hGunIndex;
    static int cDamCtr;
    static int cDamIndex;
    static int cGetUpCtr;
    static int cGetUpIndex;

    static ImageIcon[] hRifleR = new ImageIcon[7];
    static ImageIcon[] hRifleL = new ImageIcon[7];
    static ImageIcon[] cKnockOutR = new ImageIcon[7];
    static ImageIcon[] cKnockOutL = new ImageIcon[7];
    static int hRifleCtr;
    static int hRifleIndex;
    static int cKDownCtr;
    static int cKDownIndex;


    static int hFace;
    static int cFace;
    static int comFace;
    static int hMove;
    static int cMove;
    static int compMove;

    static final int comFaceL = 0;
    static final int comFaceR = 1;
    static final int hFaceR = 0;
    static final int hFaceL = 1;
    static final int cFaceR = 0;
    static final int cFaceL = 1;
    static final int moveStand = 0;
    static final int moveStandNaruto = 0;

    static final int moveRun = 1;
    static final int moveGun = 2;
    static final int moveRifle = 3;

    // KO
    static final int compStand = 0;
    static final int compKO = 1;
    static final int humStand = 0;
    static final int humKO = 1;

    final int roomHeight = 350;
    static final int roomWidth = 640;
    final int imageHeight = 150;
    final int imageWidth = 250;


    // Positions
    static int xHum = 20;
    int yHum = 100;
    static int xCom = 500;
    int yCom = 100;

    static int runNow = 0;

    static boolean bGameStart = true;


    public static void main (String[]args){


        new seriousModeGame();
    }



    public seriousModeGame() {
        fScreen = new JFrame("Luffy vs Naruto !!!");
        humHolder = new JLabel();
        comHolder = new JLabel();
        pBackground = new JPanel();

        // Connexion BDD
        Connection connection = databseElements.getConnection();

        // Variables BDD
        int ScoreLuffy = databseElements.selectScoreLuffy();
        System.out.println("voici le score de Luffy : " + ScoreLuffy );
        int ScoreNaruto = databseElements.selectScoreNaruto();
        System.out.println("voici le score de Naruto : " + ScoreNaruto );



        // Création barre de vie Naruto
        healthBarNaruto = new JPanel();
        healthBarNaruto.setBounds(440, 10, 200, 20);
        Color red1 = Color.decode("#AD260B"); // couleur barre personalisée
        healthBarNaruto.setBackground(red1);
        fScreen.add(healthBarNaruto);

        // Création barre de progression vie Naruto
        ProgressHealthBar = new JProgressBar(0, ScoreNaruto);
        ProgressHealthBar.setPreferredSize(new Dimension(200, 20));
        ProgressHealthBar.setValue(ScoreNaruto);
        ProgressHealthBar.setStringPainted(true);
        ProgressHealthBar.setForeground(Color.blue);
        healthBarNaruto.add(ProgressHealthBar);


        // Création barre de vie Luffy
        healthBarNaruto = new JPanel();
        healthBarNaruto.setBounds(40, 10, 200, 20);
        Color red2 = Color.decode("#AD260B"); // couleur barre personalisée
        healthBarNaruto.setBackground(red1);
        fScreen.add(healthBarNaruto);

        // Création barre de progression vie Luffy
        ProgressHealthBar = new JProgressBar(0, ScoreLuffy);
        ProgressHealthBar.setPreferredSize(new Dimension(200, 20));
        ProgressHealthBar.setValue(ScoreLuffy);
        ProgressHealthBar.setStringPainted(true);
        ProgressHealthBar.setForeground(Color.green);
        healthBarNaruto.add(ProgressHealthBar);


        // Caracteristiques des deux joueurs
        humHolder.setBounds(imageWidth, imageHeight, imageWidth, imageHeight);
        comHolder.setBounds(imageWidth, imageHeight, imageWidth, imageHeight);
        pBackground.setLayout(null);


        //pBackground.setIc(icon);

        fScreen.addKeyListener(new MultiKey());
        fScreen.add(humHolder);
        // humHolder = Luffy
        fScreen.add(comHolder);
        // comHolder = Naruto
        fScreen.add(pBackground, BorderLayout.CENTER);
        // Gravité
        fScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fScreen.setSize(roomWidth, roomHeight);
        // Jeu Fenêtré
        fScreen.setLocationRelativeTo(null);
        fScreen.setVisible(true);


        int i;
        for (i = 0; i < 2; i++) {
            hStandR[i] = new ImageIcon("images/hum/stand/r/" + (i + 1) + ".png");
            hStandL[i] = new ImageIcon("images/hum/stand/l/" + (i + 1) + ".png");
            cStandR[i] = new ImageIcon("images/com/stand/r/" + (i + 1) + ".png");
            cStandL[i] = new ImageIcon("images/com/stand/l/" + (i + 1) + ".png");
        }
        for (i = 0; i < 4; i++) {
            hGutlingR[i] = new ImageIcon("images/hum/gutling/r/" + (i + 1) + ".png");
            hGutlingL[i] = new ImageIcon("images/hum/gutling/l/" + (i + 1) + ".png");
            cDamageR[i] = new ImageIcon("images/com/damage/r/" + (i + 1) + ".png");
            cDamageL[i] = new ImageIcon("images/com/damage/l/" + (i + 1) + ".png");
            cGetUpR[i] = new ImageIcon("images/com/getUp/r/" + (i + 1) + ".png");
            cGetUpL[i] = new ImageIcon("images/com/getUp/l/" + (i + 1) + ".png");
        }
        for (i = 0; i < 7; i++) {
            hRifleR[i] = new ImageIcon("images/hum/curtscrew/r/" + (i + 1) + ".png");
            hRifleL[i] = new ImageIcon("images/hum/curtscrew/l/" + (i + 1) + ".png");
            cKnockOutR[i] = new ImageIcon("images/com/ko/r/" + (i + 1) + ".png");
            cKnockOutL[i] = new ImageIcon("images/com/ko/l/" + (i + 1) + ".png");
        }
        for (i = 0; i < 8; i++) {
            hRunR[i] = new ImageIcon("images/hum/run/r/" + (i + 1) + ".png");
            hRunL[i] = new ImageIcon("images/hum/run/l/" + (i + 1) + ".png");
            cRunR[i] = new ImageIcon("images/com/run/r/" + (i + 1) + ".png");
            cRunL[i] = new ImageIcon("images/com/run/l/" + (i + 1) + ".png");
        }

        do {
            moves.NarutoMove(runNow);
            moves.LuffyMove(runNow);

           /* Tests
            System.out.println("xuxxx");
            */
            humHolder.setLocation(xHum, yHum);
            humHolder.setIcon(human);
            comHolder.setLocation(xCom, yCom);
            comHolder.setIcon(computer);

        } while (bGameStart)
                ;
    }




    // Barre de progression - perte de vie
    public static void LowScore() {


        ProgressHealthBar.setValue(life - 20);


    }




    // Méthodes pour dégats
    public static void GetDamages() {

        if(moves.CompKnockDown())
            LowScore();
    }





    public static class MultiKey extends KeyAdapter {


        public void keyPressed(KeyEvent arrows) {
            int arrowpress = arrows.getKeyCode();
            char attack = arrows.getKeyChar();

            if (arrowpress == KeyEvent.VK_UP) {
                runNow = 1;
                cMove = moveRun;
                cFace = hFaceR;
            } else if (arrowpress == KeyEvent.VK_DOWN) {
                runNow = 2;
                cMove = moveRun;
                cFace = cFaceL;


            } else if (attack == 'k') {
                runNow = 3;
                // Créer méthodes attaques pour Naruto
                //   hMove = moveGun;
            } else if (attack == 'm') {
                runNow = 4;
                //   hMove = moveRifle;

            }

            if (arrowpress == KeyEvent.VK_RIGHT) {
                runNow = 1;
                hMove = moveRun;
                hFace = hFaceR;
            } else if (arrowpress == KeyEvent.VK_LEFT) {
                runNow = 2;
                hMove = moveRun;
                hFace = hFaceL;
            } else if (attack == 'z') {
                runNow = 3;
                hMove = moveGun;
            } else if (attack == 'x') {
                runNow = 4;
                hMove = moveRifle;
            } else if (arrowpress == KeyEvent.VK_ESCAPE) {
                fScreen.dispose();
            }




        }

        public void keyReleased(KeyEvent arrow) {
            int arrowRelease = arrow.getKeyCode();
            // Conditions for not make Luffy run if we're not pressed key
            if (arrowRelease == KeyEvent.VK_RIGHT) {
               hMove = moveStand;
            } else if (arrowRelease == KeyEvent.VK_LEFT) {
              hMove = moveStand;
            }

            if (arrowRelease == KeyEvent.VK_UP) {
                cMove = moveStandNaruto;
            } else if (arrowRelease == KeyEvent.VK_DOWN) {
                cMove = moveStandNaruto;
            }
        }




            }

    }


