package controller;

import dto.DTOCreateCurrentBank;
import service.ServiceCurrentBank;
import view.ViewCreateCountBank;

public class ControllerCreateCurrentBank{
ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();
ServiceCurrentBank serviceCurrentBank = new ServiceCurrentBank();

    public void createCurrentBank(){
        DTOCreateCurrentBank dtoCreateCurrentBank = viewCreateCountBank.displayCreateCountCurrent();
        serviceCurrentBank.serviceCheckCurrentCountCPF(dtoCreateCurrentBank);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
