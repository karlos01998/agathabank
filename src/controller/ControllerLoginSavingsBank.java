package controller;

import model.ModelCurrentBank;
import model.ModelSavingsBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

import java.util.Scanner;

public class ControllerLoginSavingsBank {

    Scanner write = new Scanner(System.in);
    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public void startDisplayMenuLoginSavingsCPF() {
        long idCPF = viewLoginBank.displayLoginCountCurrentCPF();
        checkLoginCurrentCPF(idCPF);
    }

    public void checkLoginCurrentCPF(long cpf) {
        boolean check = getSavingsCountCPF(cpf);

        if (check == false) {
            viewFunctionBank.errorLogin();
        } else if (check == true) {
            checkLoginSavingsPassword();
        }
    }

    public void checkLoginSavingsPassword() {
        int password = viewLoginBank.displayLoginCountSavingsPassword();
        boolean check;

        check = getSavingsCountPassword(password);

        if (check == false) {
            viewFunctionBank.errorLogin();
        } else if (check == true) {
            viewFunctionBank.displaycount();
        }
    }

   public static boolean getSavingsCountCPF(long cpf) {
       for (ModelSavingsBank savingsBank : ControllerCreateSavingsBank.SavingsCount) {
           if (savingsBank.getNumberCPF() == cpf) {
               return true;
           }
       }
       return false;
   }

    public static boolean getSavingsCountPassword(int password) {
        for (ModelSavingsBank savingsBank : ControllerCreateSavingsBank.SavingsCount) {
            if (savingsBank.getPassword() == password) {
                return true;
            }
        }
        return false;
    }
}
