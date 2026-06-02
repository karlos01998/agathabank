package controller;

import model.ModelSavingsBank;
import view.ViewCountSavingsBank;
import view.ViewFunctionBank;

public class ControllerCountSavingsBank {
    ViewCountSavingsBank viewCountSavingsBank = new ViewCountSavingsBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public void displayCountSavings(ModelSavingsBank modelSavingsBank) {
        int choose = 0;

        // 🔥 Espelhado com a Corrente usando DO-WHILE estável
        do {
            choose = viewCountSavingsBank.displayCountSavings(modelSavingsBank);

            switch (choose) {
                case 1:
                    viewCountSavingsBank.displayCountSavingsBalance(modelSavingsBank);
                    break;

                case 2:
                    // Seu extrato de poupança entrará aqui
                    break;

                case 3:
                    ControllerCountSavingsPix controllerCountSavingsPix = new ControllerCountSavingsPix();
                    controllerCountSavingsPix.startSavingsPix(modelSavingsBank);
                    break;

                case 7:
                    viewFunctionBank.displayExitApp();
                    break;

                default:
                    viewFunctionBank.displayChooseError();
                    break;
            }
        } while (choose != 7);
    }
}