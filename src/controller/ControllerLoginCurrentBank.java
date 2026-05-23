package controller;

import model.ModelCurrentBank;
import view.ViewLoginBank;
import view.ViewFunctionBank;

public class ControllerLoginCurrentBank {

    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ViewLoginBank viewLoginBank = new ViewLoginBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public void startDisplayMenuLoginCurrentCPF() {
        ModelCurrentBank currentCount = null;

        do {
            long idCPF = viewLoginBank.displayLoginCountCurrentCPF();
            currentCount = checkLoginCurrentCPF(idCPF);

            if (cpfAttempts >= 3) {
                viewFunctionBank.errorLoginExced();
                System.exit(0);
            }
        } while (currentCount == null);

        viewLoginBank.countDataTest(currentCount);
    }

    public ModelCurrentBank checkLoginCurrentCPF(long cpf) {
        ModelCurrentBank currentCount = getCurrentCountCPF(cpf);

        if (currentCount == null) {
            viewFunctionBank.errorLogin();
            cpfAttempts++;
            return null;
        }

        cpfAttempts = 0;

        do {
            int password = viewLoginBank.displayLoginCountCurrentPassword();

            if (currentCount.getPassword() == password) {
                return currentCount;
            }
                viewFunctionBank.errorLogin();
                passwordAttempts++;

        } while (passwordAttempts < 3);

        viewFunctionBank.errorLoginExced();
        System.exit(0);
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
