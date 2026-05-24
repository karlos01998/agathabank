package controller;

import repository.RepositoryCurrentBank;
import repository.RepositorySavingsBank;

public class ControllerStartBank {
    ControllerFunctionsBank controllerFunctionsBank = new ControllerFunctionsBank();

    ControllerCreateCurrentBank controllerCreateCurrentBank = new ControllerCreateCurrentBank();
    ControllerCreateSavingsBank controllerCreateSavingsBank = new ControllerCreateSavingsBank();

    ControllerLoginCurrentBank controllerLoginCurrentBank = new ControllerLoginCurrentBank();
    ControllerLoginSavingsBank controllerLoginSavingsBank = new ControllerLoginSavingsBank();

    RepositorySavingsBank repositorySavingsBank = new RepositorySavingsBank();
    RepositoryCurrentBank repositoryCurrentBank = new RepositoryCurrentBank();


    public void startDisplaySwitchApp() {
        int choose = 0;

        controllerFunctionsBank.startApp();
        repositoryCurrentBank.modelCurrentBankCreateInity();
        repositorySavingsBank.modelSavingsBankCreateInity();

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
                    System.exit(0);
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
                    System.exit(0);
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
                    controllerCreateCurrentBank.createCurrentBank();
                    break;

                case 2:
                    controllerLoginSavingsBank.startDisplayMenuLoginSavingsCPF();
                    break;

                case 3:
                    controllerFunctionsBank.exitApp();
                    System.exit(0);
                    break;

                default:
                    controllerFunctionsBank.chooseError();
                    startDisplaySwitchApp();
            }
        } while (choose != 3);
    }

}
