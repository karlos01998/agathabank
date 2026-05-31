package controller;

import service.ServiceCurrentBank;
import view.ViewCreateCountBank;
import view.ViewFunctionBank;

public class ControllerCreateCurrentBank {
    ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();
    ServiceCurrentBank serviceCurrentBank = new ServiceCurrentBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ControllerLoginCurrentBank controllerLoginCurrentBank = new ControllerLoginCurrentBank();

    public void createCurrentBank() {
        long idCPF = viewCreateCountBank.displayCheckCPFCreateCountCurrentBank();
        boolean sizeCPF = serviceCurrentBank.serviceCheckCPFSizeCurrentBank(idCPF);

        if (sizeCPF == false) {
            viewCreateCountBank.errorSizeCPF();
            System.exit(0);
        }

        boolean existCPF = serviceCurrentBank.serviceCheckCurrentCountCPF(idCPF);
        if (existCPF == true) {
            viewCreateCountBank.errorCheckCPF();
            System.exit(0);
        }

        serviceCurrentBank.serviceCurrentBankCreate(viewCreateCountBank.displayCreateCountCurrent(idCPF));
        viewFunctionBank.displaycount();
        controllerLoginCurrentBank.startDisplayMenuLoginCurrentCPF();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}