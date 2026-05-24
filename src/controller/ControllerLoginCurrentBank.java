package controller;

import model.ModelCurrentBank;
import service.ServiceCurrentBank;
import view.ViewLoginBank;

public class ControllerLoginCurrentBank {

    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ServiceCurrentBank serviceCurrentBank = new ServiceCurrentBank();

    public void startDisplayMenuLoginCurrentCPF() {
        ModelCurrentBank currentCount = null;

        do {
            long idCPF = viewLoginBank.displayLoginCountCurrentCPF();
            currentCount = serviceCurrentBank.serviceLoginCurrent(idCPF);

        } while (currentCount == null);
        viewLoginBank.countDataTest(currentCount);
    }

}
