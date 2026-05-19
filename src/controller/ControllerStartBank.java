package controller;

import view.ViewStartBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

public class ControllerStartBank {
    ViewStartBank viewStartBank = new ViewStartBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ViewLoginBank viewLoginBank = new ViewLoginBank();

    public void startApp() {
        viewStartBank.displayStartApp();
    }

    public int startDisplayMenu() {
        int choose = viewStartBank.displayStartMenuApp();
        startDisplaySwitchApp(choose);
        return choose;
    }

    public int startDisplayMenuLogin(){
        int choose = viewLoginBank.displayLoginMenuCountApp();
        startDisplaySwitchApp(choose);
        return choose;
    }

    public void startDisplayMenuLoginCurrent(){
        int idCPF = viewLoginBank.displayLoginCountCurrentCPF();

    }

    public int startDisplayMenuCreateCount() {
        int choose = viewStartBank.displayCreateCountMenuApp();
        startDisplaySwitchApp(choose);
        return choose;
    }

    public int startDisplaySwitchApp(int choose) {
        switch (choose) {
            case 1:
                return 1;

            case 2:
                return 2;

            case 99:
                return 99;

            default:
                viewFunctionBank.displayChooseError();
                return choose;
        }
    }

    public void ExitApp() {
        viewFunctionBank.displayExitApp();
    }
}
