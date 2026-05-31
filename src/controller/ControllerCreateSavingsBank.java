package controller;

import service.ServiceSavingsBank;
import view.ViewCreateCountBank;
import view.ViewFunctionBank;

public class ControllerCreateSavingsBank{
    ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();
    ServiceSavingsBank serviceSavingsBank = new ServiceSavingsBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ControllerLoginSavingsBank controllerLoginSavingsBank = new ControllerLoginSavingsBank();

    public void createSavingsBank(){
        long idCPF = viewCreateCountBank.displayCheckCPFCreateCountSavingsBank();
        boolean sizeCPF = serviceSavingsBank.serviceCheckCPFSizeSavingsBank(idCPF);

        if (sizeCPF == false){
            viewCreateCountBank.errorSizeCPF();
            System.exit(0);
        }

        boolean existCPF = serviceSavingsBank.serviceCheckSavingsCountCPF(idCPF);
        if (existCPF == true){
            viewCreateCountBank.errorCheckCPF();
            System.exit(0);
        }

        serviceSavingsBank.serviceSavingsBankCreate(viewCreateCountBank.displayCreateCountSavings(idCPF));
        viewFunctionBank.displaycount();
        controllerLoginSavingsBank.startDisplayMenuLoginSavingsCPF();
    }
    @Override
    public String toString() {
        return super.toString();
    }
}