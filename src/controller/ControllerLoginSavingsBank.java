package controller;

import model.ModelSavingsBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

import java.util.Scanner;

public class ControllerLoginSavingsBank {

    Scanner write = new Scanner(System.in);
    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ModelSavingsBank modelSavingsBank;


   /* public void startLoginSavingsBank() {
        viewLoginBank.displayLoginCountSavingsCPF();
        viewFunctionBank.displayExitApp();
        System.exit(0);
    }

    public void twoStartLoginSavingsBank() {
            System.exit(0);
            viewFunctionBank.displayExitApp();
    }*/
}
