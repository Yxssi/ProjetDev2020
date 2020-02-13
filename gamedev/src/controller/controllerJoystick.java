package controller;
import com.badlogic.gdx.jnigen.JniGenSharedLibraryLoader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.studiohartman.jamepad.ControllerState;
import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerButton;


// Class permettant de faire appels aux joystics / boutons


public class controllerJoystick {
    public controllerJoystick() {
        ControllerManager controllers = new ControllerManager();
        controllers.initSDLGamepad();

        while(true) {
            ControllerState currState = controllers.getState(0);

            if(!currState.isConnected || currState.b) {
                System.out.println("Pas connecté ");
                break;
            }
            if(currState.a) {
                System.out.println("\"A\" on \"" + currState.controllerType + "\" is pressed");
            }
        }
    }
}


