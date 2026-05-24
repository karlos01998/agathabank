package controller;

import dto.DTOCreateSavingsBank;
import service.ServiceSavingsBank;
import view.ViewCreateCountBank;

public class ControllerCreateSavingsBank {
    ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();
    ServiceSavingsBank serviceSavingsBank = new ServiceSavingsBank();

    public void createSavingsBank() {
        DTOCreateSavingsBank dtoCreateSavingsBank = viewCreateCountBank.displayCreateCountSavings();
        serviceSavingsBank.serviceCheckSavingsCountCPF(dtoCreateSavingsBank);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
