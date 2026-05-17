package app;

import controller.ControllerStartBank;
import controller.ControllerCreateCountBank;
import controller.ControllerCountBank;
import controller.ControllerLoginBank;

public class Main {
    public static void main(String[] args) {

        ControllerStartBank controllerStartBank = new ControllerStartBank();
        ControllerCreateCountBank controllerCreateCountBank = new ControllerCreateCountBank();
        ControllerCountBank controllerCountBank = new ControllerCountBank();
        //ControllerLoginBank controllerLoginBank = new ControllerLoginBank();

        //Inicia o app e chama o primeiro metodo de escolha que devolve a variavel de escolha
        controllerStartBank.startApp();
        int choose = controllerStartBank.startDisplayMenu();
        if (choose == 99) {
            controllerStartBank.ExitApp();
            System.exit(0);
        }

        //Recebe a variavel de escolha do primeiro metodo e chama o metodo de escolha em tipo de conta
        if (choose == 99) {
            controllerStartBank.startApp();
            System.exit(0);

        } else if (choose == 1) {
                choose += controllerStartBank.startDisplayMenuCountApp() + 1;
            } else if (choose == 2) {

            }

        if (choose == 3) {

        }
    }
}