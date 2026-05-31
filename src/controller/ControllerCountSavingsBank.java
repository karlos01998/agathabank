package controller;

import model.ModelCurrentBank;
import model.ModelSavingsBank;
import view.ViewCountSavingsBank;
import view.ViewFunctionBank;

public class ControllerCountSavingsBank {
    ViewCountSavingsBank viewCountSavingsBank = new ViewCountSavingsBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public void displayCountSavings(ModelSavingsBank modelSavingsBank) {
        int choose = viewCountSavingsBank.displayCountSavings(modelSavingsBank);

        switch (choose) {
            case 1:
                viewCountSavingsBank.displayCountSavingsBalance(modelSavingsBank);
                displayCountSavings(modelSavingsBank);
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            default:
                viewFunctionBank.displayChooseError();
                break;
        }
    }
}