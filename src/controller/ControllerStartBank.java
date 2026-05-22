package controller;

import view.ViewFunctionBank;

public class ControllerStartBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ControllerFunctionsBank controllerFunctionsBank = new ControllerFunctionsBank();

    public void startDisplaySwitchApp() {
        int choose = 0;
        controllerFunctionsBank.startApp();
        choose = controllerFunctionsBank.startDisplayMenu();
        do {
            switch (choose) {
                case 1:
                    controllerFunctionsBank.startDisplayMenuLogin();
                    break;

                case 2:
                    controllerFunctionsBank.startDisplayMenuCreateCount();
                    break;

                case 3:
                    controllerFunctionsBank.exitApp();
                    break;

                default:
                    controllerFunctionsBank.chooseError();
                    startDisplaySwitchApp();
            }
        } while (choose != 3);
    }

    public void startDisplayLoginApp() {
        int choose = 0;
        choose = controllerFunctionsBank.startDisplayMenuLogin();
        do {
            switch (choose) {
                case 1:
                    controllerFunctionsBank.startDisplayMenuLoginCurrentCPF();
                    break;

                case 2:
                    controllerFunctionsBank.startDisplayMenuLoginSavingsCPF();
                    break;

                case 3:
                    controllerFunctionsBank.exitApp();
                    break;

                default:
                    controllerFunctionsBank.chooseError();
                    startDisplaySwitchApp();
            }
        } while (choose != 3);
    }

    public void startDisplayCreateCountApp() {
        int choose = 0;
        choose = controllerFunctionsBank.startDisplayMenuCreateCount();
        do {
            switch (choose) {
                case 1:
                    controllerFunctionsBank.startDisplayMenuLoginCurrentCPF();
                    break;

                case 2:
                    controllerFunctionsBank.startDisplayMenuLoginSavingsCPF();
                    break;

                case 3:
                    controllerFunctionsBank.exitApp();
                    break;

                default:
                    controllerFunctionsBank.chooseError();
                    startDisplaySwitchApp();
            }
        } while (choose != 3);
    }

}
