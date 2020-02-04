package controller;

public class moves extends seriousModeGame {
    // Fonctions nécessaires aux mouvements

 public static void LuffyMove(int run) {

        if (hMove == moveStand) {
            hStandCtr += 1;
            if (hStandCtr >= 60)
                hStandCtr = 0;
            if (hStandCtr < 30)
                hStandIndex = 0;
            else if (hStandCtr < 60)
                hStandIndex = 1;

            if (hFace == hFaceR)
                human = hStandR[hStandIndex];
            else
                human = hStandL[hStandIndex];

            hStandCtr += 1;

        } 
        else if (hMove == moveRun) {
            hRunCtr += 1;
            if (hRunCtr >= 60)
                hRunCtr = 0;
            if (hRunCtr < 7)
                hRunIndex = 0;
            else if (hRunCtr < 21)
                hRunIndex = 1;
            else if (hRunCtr < 28)
                hRunIndex = 2;
            else if (hRunCtr < 35)
                hRunIndex = 3;
            else if (hRunCtr < 42)
                hRunIndex = 4;
            else if (hRunCtr < 49)
                hRunIndex = 5;
            else if (hRunCtr < 56)
                hRunIndex = 6;
            else if (hRunCtr < 60)
                hRunIndex = 7;

            if (hFace == hFaceR) {
                xHum += 2;
                if (xHum > 600)
                    xHum = -50;
                if (xHum == (xCom - 80))
                    xHum = xCom - 90;
                human = hRunR[hRunIndex];
            } else {
                xHum -= 2;
                if (xHum < -50)
                    xHum = 600;
                if (xHum == (xCom + 50))
                    xHum = xCom + 70;
                human = hRunL[hRunIndex];
            }

        }

        else if (hMove == moveGun) {

            if (hGunCtr < 15)
                hGunIndex = 0;
            else if (hGunCtr < 30)
                hGunIndex = 1;
            else if (hGunCtr < 45)
                hGunIndex = 2;
            else if (hGunCtr < 60)
                hGunIndex = 3;
            else {
                hGunCtr = 0;
                hMove = moveStand;
            }

            if (hFace == hFaceR)
                human = hGutlingR[hGunIndex];
            else
                human = hGutlingL[hGunIndex];

            hGunCtr += 1;

        }
        else if (hMove == moveRifle) {

            if (hRifleCtr < 8)
                hRifleIndex = 0;
            else if (hRifleCtr < 16)
                hRifleIndex = 1;
            else if (hRifleCtr < 24)
                hRifleIndex = 2;
            else if (hRifleCtr < 32)
                hRifleIndex = 3;
            else if (hRifleCtr < 40)
                hRifleIndex = 4;
            else if (hRifleCtr < 50)
                hRifleIndex = 5;
            else if (hRifleCtr < 60)
                hRifleIndex = 6;
            else {
                hRifleCtr = 0;
                hMove = moveStand;
            }

            if (hFace == hFaceR)
                human = hRifleR[hRifleIndex];
            else
                human = hRifleL[hRifleIndex];

            hRifleCtr += 1;

        }
        if (run != 0)
            mCompAllMovements();
        else
            CompStand();


        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
        }
    }

    public static void NarutoMove(int run) {

        if (cMove == moveStandNaruto) {
            cStandCtr += 1;
            if (cStandCtr >= 60)
                cStandCtr = 0;
            if (cStandCtr < 30)
                cStandIndex = 0;
            else if (cStandCtr < 60)
                cStandIndex = 1;

            if (cFace == cFaceR)
                human = cStandR[cStandIndex];
            else
                human = cStandL[cStandIndex];

            cStandCtr += 1;

        }


         if (cMove == moveRun) {
            cRunCtr += 1;
            if (cRunCtr <= 60)
                cRunCtr = 0;
            if (cRunCtr > 7)
                cRunIndex = 0;
            else if (cRunCtr < 21)
                cRunIndex = 0;
            else if (cRunCtr < 28)
                cRunIndex = 1;
            else if (cRunCtr < 35)
                cRunIndex = 3;
            else if (cRunCtr < 42)
                cRunIndex = 4;
            else if (cRunCtr < 49)
                cRunIndex = 5;
            else if (cRunCtr < 56)
                cRunIndex = 6;
            else if (cRunCtr <  60)
                cRunIndex = 7;

            if (cFace == cFaceR) {
                xCom += 2;
                if (xCom > 600)
                    xCom = -50;
                if (xCom == (xHum - 80))
                    xCom = xHum - 90;
                human = cRunR[cRunIndex];
            } else {
                xCom -= 2;
                if (xCom < -50)
                    xCom = 600;
                if (xCom == (xHum + 50))
                    xCom = xHum + 70;
                human = cRunL[cRunIndex];
            }

        }


         // attaques








         // Méthode pour attaque naruto basée sur gun rifle de luffy
       //// Méthode pour attaque naruto basée sur move rifle de luffy
        if (run != 0)
            mCompAllMovements();
        else
            CompStand();


        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
        }
    }


    public static void mCompAllMovements() {

        if (hMove == moveGun) {
            if (hFace == hFaceR) {
                if (xHum < roomWidth / 2) {
                    if (xHum >= xCom - 130)
                      compDamage();
                    else
                       CompStand();
                }
            } else {
                if (xHum > roomWidth / 2) {
                    if (xHum <= xCom + 130)
                        compDamage();
                    else {
                    CompStand();
                    }
                }
            }
        }
        else if (hMove == moveRifle) {

            if (hFace == hFaceR) {
                if (xHum < roomWidth / 2) {
                    if (xHum >= xCom - 130) {
                       CompKnockDown();
                    } else
                       CompStand();


                }
            } else {
                if (xHum > roomWidth / 2) {
                    if (xHum <= xCom + 130) {
                    CompKnockDown();
                    } else {
                       CompStand();
                    }
                }
            }
        } else {
            if (hFace == hFaceR) {
                if (xHum >= (xCom - 120)) {
                    if (compMove == compKO)
                        CompGetUp();
                    else
                        CompStand();
                }
            } else {
                if (xHum <= (xCom + 120)) {
                    if (compMove == compKO)
                        CompGetUp();
                    else
                        CompStand();
                }
            }
        }

    }

    public static void CompStand() {

 cStandCtr += 1;
        if (cStandCtr >= 60)
            cStandCtr = 0;
        if (cStandCtr < 30)
            cStandIndex = 0;
        else if (cStandCtr < 60)
            cStandIndex = 1;
        if (comFace == comFaceL)
            computer = cStandL[cStandIndex];
        else
            computer = cStandR[cStandIndex];

        cStandCtr += 1;



    }


    public static void compDamage() {

        cDamCtr += 1;

        if (cDamCtr < 15)
            cDamIndex = 0;

        else if (cDamCtr < 30)
            cDamIndex = 1;
        else if (hGunCtr < 45)
            cDamIndex = 2;
        else if (cDamCtr < 60)
            cDamIndex = 3;
        else {
            cDamCtr = 0;
        }

        if (hFace == hFaceL) {


            computer = cDamageR[cDamIndex];

        } else
            computer = cDamageL[cDamIndex];


    }

    public static boolean CompKnockDown() {

        compMove = compKO;
        cKDownCtr += 1;
        if (cKDownCtr < 8)
            cKDownIndex = 0;
        else if (cKDownCtr < 16)
            cKDownIndex = 1;
        else if (cKDownCtr < 24)
            cKDownIndex = 2;
        else if (cKDownCtr < 32)
            cKDownIndex = 3;
        else if (cKDownCtr < 40)
            cKDownIndex = 4;
        else if (cKDownCtr < 50)
            cKDownIndex = 5;
        else if (cKDownCtr < 60)
            cKDownIndex = 6;
        else
            cKDownCtr = 0;


        if (hFace == hFaceL) {
            computer = cKnockOutR[cKDownIndex];


        } else {
            computer = cKnockOutL[cKDownIndex];


        }

        return true;
    }




    public static void CompGetUp() {
        cGetUpCtr += 1;
        if (cGetUpCtr < 8)
            cGetUpIndex = 0;
        else if (cGetUpCtr < 16)
            cGetUpIndex = 1;
        else if (cGetUpCtr < 24)
            cGetUpIndex = 2;
        else if (cGetUpCtr < 32)
            cGetUpIndex = 3;
        else {
            cGetUpCtr = 0;
            compMove = compStand;
        }

        if (hFace == hFaceL) {
            computer = cGetUpR[cGetUpIndex];

        } else {
            computer = cGetUpL[cGetUpIndex];
        }
    }


}
