package controller;

import model.ModelSavingsBank;
import repository.RepositorySavingsBank;
import service.ServiceSavingsBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

public class ControllerLoginSavingsBank {

    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ServiceSavingsBank serviceSavingsBank = new ServiceSavingsBank();

    private int cpfAttempts = 0;

    public void startDisplayMenuLoginSavingsCPF() {
        ModelSavingsBank savingsCount = null;

        do {
            long idCPF = viewLoginBank.displayLoginCountSavingsCPF();
            savingsCount = serviceSavingsBank.checkLoginSavingsCPF(idCPF);

            if (cpfAttempts >= 3) {
                viewFunctionBank.errorLoginExced();
                System.exit(0);
            }
        } while (savingsCount == null);

        viewLoginBank.countDataTest(savingsCount);
    }


}
