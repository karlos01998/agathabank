package controller;

import model.ModelCurrentBank;
import service.ServiceCurrentBank;
import view.ViewLoginBank;

public class ControllerLoginCurrentBank {

    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ServiceCurrentBank serviceCurrentBank = new ServiceCurrentBank();

    public void startDisplayMenuLoginCurrentCPF() {
        ModelCurrentBank currentCount = null;

        // O Controller gerencia o loop, pois ele pode pedir novos CPFs à View a cada rodada
        do {
            long idCPF = viewLoginBank.displayLoginCountCurrentCPF();
            currentCount = serviceCurrentBank.startServiceLoginCurrentCPF(idCPF);

        } while (currentCount == null); // Repete o menu se o service retornar nulo

        // Fluxo de Sucesso
        viewLoginBank.countDataTest(currentCount);
    }

}
