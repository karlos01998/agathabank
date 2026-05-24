package controller;

import model.ModelSavingsBank;
import service.ServiceSavingsBank;
import view.ViewLoginBank;

public class ControllerLoginSavingsBank {

    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ServiceSavingsBank serviceSavingsBank = new ServiceSavingsBank();

    public void startDisplayMenuLoginSavingsCPF() {
        ModelSavingsBank savingsCount = null;

        do {
            long idCPF = viewLoginBank.displayLoginCountSavingsCPF();
            savingsCount = serviceSavingsBank.serviceLoginSavings(idCPF);

        } while (savingsCount == null);
        viewLoginBank.countDataTest(savingsCount);
    }

}
