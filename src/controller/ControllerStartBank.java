package controller;

import view.ViewStartBank;
import view.ViewFunctionBank;

public class ControllerStartBank {
    ViewStartBank viewStartBank = new ViewStartBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public void startApp() {
        viewStartBank.displayStartApp();
    }

    public int startDisplayMenu() {
        int choose = viewStartBank.displayStartMenuApp();
        startDisplaySwitchApp(choose);
        return choose;
    }

    public int startDisplayMenuCountApp() {
        int choose = viewStartBank.displayLoginMenuCountApp();
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
