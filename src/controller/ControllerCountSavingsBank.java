package controller;

import model.ModelSavingsBank;
import view.ViewCountSavingsBank;
import view.ViewFunctionBank;

public class ControllerCountSavingsBank {
    ViewCountSavingsBank viewCountSavingsBank = new ViewCountSavingsBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public void displayCountSavings(ModelSavingsBank modelSavingsBank) {
        int choose = 0;

        do {
            choose = viewCountSavingsBank.displayCountSavings(modelSavingsBank);

            switch (choose) {
                case 1:
                    viewCountSavingsBank.displayCountSavingsBalance(modelSavingsBank);
                    break;

                case 2:
                    viewCountSavingsBank.displayCountSavingsExtract(modelSavingsBank);
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