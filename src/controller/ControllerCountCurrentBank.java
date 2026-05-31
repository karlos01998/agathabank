package controller;

import model.ModelCurrentBank;
import view.ViewCountCurrentBank;
import view.ViewFunctionBank;

public class ControllerCountCurrentBank {
    ViewCountCurrentBank viewCountCurrentBank = new ViewCountCurrentBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public void displayCountCurrent(ModelCurrentBank modelCurrentBank) {
        int choose = viewCountCurrentBank.displayCountCurrent(modelCurrentBank);

        switch (choose) {
            case 1:
                    viewCountCurrentBank.displayCountCurrentBalance(modelCurrentBank);
                    displayCountCurrent(modelCurrentBank);
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