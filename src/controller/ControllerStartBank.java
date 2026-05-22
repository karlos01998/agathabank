package controller;

public class ControllerStartBank {
    ControllerFunctionsBank controllerFunctionsBank = new ControllerFunctionsBank();
    ControllerLoginCurrentBank controllerLoginCurrentBank = new ControllerLoginCurrentBank();
    ControllerLoginSavingsBank controllerLoginSavingsBank = new ControllerLoginSavingsBank();
    ControllerCreateCurrentBank controllerCreateCurrentBank = new ControllerCreateCurrentBank();
    ControllerCreateSavingsBank controllerCreateSavingsBank = new ControllerCreateSavingsBank();

    public void startDisplaySwitchApp() {
        int choose = 0;

        controllerFunctionsBank.startApp();
        controllerCreateCurrentBank.modelCurrentBankCreate();
        controllerCreateSavingsBank.modelSavingsBankCreate();

        choose = controllerFunctionsBank.startDisplayMenu();
        do {
            switch (choose) {
                case 1:
                    startDisplayLoginApp();
                    break;

                case 2:
                    startDisplayCreateCountApp();
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
                    controllerLoginCurrentBank.startDisplayMenuLoginCurrentCPF();
                    break;

                case 2:
                    controllerLoginSavingsBank.startDisplayMenuLoginSavingsCPF();
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
                    controllerLoginCurrentBank.startDisplayMenuLoginCurrentCPF();
                    break;

                case 2:
                    controllerLoginSavingsBank.startDisplayMenuLoginSavingsCPF();
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
