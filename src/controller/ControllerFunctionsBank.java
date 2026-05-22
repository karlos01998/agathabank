package controller;

import view.ViewCreateCountBank;
import view.ViewFunctionBank;
import view.ViewStartBank;
import view.ViewLoginBank;

public class ControllerFunctionsBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ViewStartBank viewStartBank = new ViewStartBank();
    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();


    public void startApp() {
        viewStartBank.displayStartApp();
    }

    public int startDisplayMenu() {
        return viewStartBank.displayStartMenuApp();
    }

    public int startDisplayMenuLogin() {
        return viewLoginBank.displayLoginMenuCountApp();
    }

    public int startDisplayMenuCreateCount() {
        return viewStartBank.displayCreateCountMenuApp();
    }

    public void startDisplayMenuCreateCurrentCPF() {
        long idCPF = viewCreateCountBank.displayCreateCountCurrentCPF();
    }

    public void startDisplayMenuCreateSavingsCPF() {
        long idCPF = viewCreateCountBank.displayCreateCountSavingsCPF();
    }

    public void exitApp() {
        viewFunctionBank.displayExitApp();
    }

    public void chooseError(){
        viewFunctionBank.displayChooseError();
    }

}
