package controller;

import model.ModelCurrentBank;
import view.ViewLoginBank;
import view.ViewFunctionBank;

public class ControllerLoginCurrentBank {

    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ControllerFunctionsBank controllerFunctionsBank = new ControllerFunctionsBank();

    int attempts = 0;

    public void startDisplayMenuLoginCurrentCPF() {

        long idCPF = viewLoginBank.displayLoginCountCurrentCPF();
        ModelCurrentBank countUser = checkLoginCurrentCPF(idCPF);

        if (countUser != null) {
            viewLoginBank.countDataTest(countUser);
            viewFunctionBank.DisplayPause();
        }
        System.exit(0);
    }

    public ModelCurrentBank checkLoginCurrentCPF(long cpf) {

        ModelCurrentBank currentCount = getCurrentCountCPF(cpf);

            if (currentCount == null) {
                viewFunctionBank.errorLogin();
                attempts++;

            }

        do {

            int password = viewLoginBank.displayLoginCountCurrentPassword();

            if (currentCount.getPassword() != password) {
                viewFunctionBank.errorLogin();
                attempts++;
            } else if (currentCount.getPassword() == password) {
                return currentCount;
            }

        } while (attempts < 3);
        viewFunctionBank.errorLogin();
        return null;
    }

    public static ModelCurrentBank getCurrentCountCPF(long cpf) {
        for (ModelCurrentBank currentBank : ControllerCreateCurrentBank.currentCount) {
            if (currentBank.getNumberCPF() == cpf) {
                return currentBank;
            }
        }
        return null;
    }
}
