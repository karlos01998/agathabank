package app;

import controller.ControllerLoginCurrentBank;
import controller.ControllerStartBank;
import controller.ControllerCreateCurrentBank;
import controller.ControllerCountBank;

public class Main {
    public static void main(String[] args) {

        ControllerStartBank controllerStartBank = new ControllerStartBank();
        ControllerCreateCurrentBank controllerCreateCountBank = new ControllerCreateCurrentBank();
        ControllerCountBank controllerCountBank = new ControllerCountBank();
        ControllerLoginCurrentBank controllerLoginCurrentBank = new ControllerLoginCurrentBank();

        //Inicia o app e chama o primeiro metodo de escolha que alimenta a variavel de escolha
        controllerStartBank.startApp();

        int choose = controllerStartBank.startDisplayMenu();

        if (choose == 99) {
            controllerStartBank.ExitApp();
            System.exit(0);

        } else if (choose == 1) {
            choose = controllerStartBank.startDisplayMenuLogin();

            if (choose == 99) {
                controllerStartBank.ExitApp();
                System.exit(0);

            } else if (choose == 1) {
                controllerLoginCurrentBank.startLoginCurrentBank();
            }

        } else if (choose == 2) {
            controllerStartBank.startDisplayMenuCreateCount();
        }

        //Recebe a variavel de escolha do primeiro metodo e chama o metodo de escolha em tipo de conta
        if (choose == 99) {
            controllerStartBank.startApp();
            System.exit(0);

        } else if (choose == 1) {
            choose += controllerStartBank.startDisplayMenuCreateCount() + 1;
        } else if (choose == 2) {

        }

        if (choose == 3) {

        }
    }
}