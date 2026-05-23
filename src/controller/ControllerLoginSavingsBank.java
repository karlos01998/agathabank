package controller;

import model.ModelSavingsBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

public class ControllerLoginSavingsBank {

    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ViewLoginBank viewLoginBank = new ViewLoginBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public void startDisplayMenuLoginSavingsCPF() {
        ModelSavingsBank savingsCount = null;

        do {
            long idCPF = viewLoginBank.displayLoginCountSavingsCPF();
            savingsCount = checkLoginSavingsCPF(idCPF);

            if (cpfAttempts >= 3) {
                viewFunctionBank.errorLoginExced();
                System.exit(0);
            }
        } while (savingsCount == null);

        viewLoginBank.countDataTest(savingsCount);
    }

    public  ModelSavingsBank checkLoginSavingsCPF(long cpf) {
        ModelSavingsBank savingsCount = getSavingsCountCPF(cpf);

        if (savingsCount == null) {
            viewFunctionBank.errorLogin();
            cpfAttempts++;
            return null;
        }

        cpfAttempts = 0;

        do {
            int password = viewLoginBank.displayLoginCountSavingsPassword();

            if (savingsCount.getPassword() == password) {
                return savingsCount;
            }
            viewFunctionBank.errorLogin();
            passwordAttempts++;

        } while (passwordAttempts < 3);

        viewFunctionBank.errorLoginExced();
        System.exit(0);
        return null;
    }

    public static  ModelSavingsBank getSavingsCountCPF(long cpf) {
        for ( ModelSavingsBank savingsCount : ControllerCreateSavingsBank.SavingsCount) {
            if (savingsCount.getNumberCPF() == cpf) {
                return savingsCount;
            }
        }
        return null;
    }
}
