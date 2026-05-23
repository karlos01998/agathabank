package service;

import model.ModelSavingsBank;
import repository.RepositorySavingsBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

public class ServiceSavingsBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ViewLoginBank viewLoginBank = new ViewLoginBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public ModelSavingsBank checkLoginSavingsCPF(long cpf) {
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
        for ( ModelSavingsBank savingsCount : RepositorySavingsBank.SavingsCount) {
            if (savingsCount.getNumberCPF() == cpf) {
                return savingsCount;
            }
        }
        return null;
    }

}
