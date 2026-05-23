package service;

import model.ModelCurrentBank;
import repository.RepositoryCurrentBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

public class ServiceCurrentBank {
    private final ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    private final ViewLoginBank viewLoginBank = new ViewLoginBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public ModelCurrentBank startServiceLoginCurrentCPF(long idCPF) {
        ModelCurrentBank currentCount = getCurrentCountCPF(idCPF);

        if (currentCount == null) {
            viewFunctionBank.errorLogin();
            cpfAttempts++;

            if (cpfAttempts >= 3) {
                viewFunctionBank.errorLoginExced();
                System.exit(0);
            }
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

    public static ModelCurrentBank getCurrentCountCPF(long idCPF) {
        for (ModelCurrentBank currentBank : RepositoryCurrentBank.currentCount) {
            if (currentBank.getNumberCPF() == idCPF) {
                return currentBank;
            }
        }
        return null;
    }
}

