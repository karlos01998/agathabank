package controller;
import java.util.Scanner;
import model.ModelCurrentBank;
import view.ViewLoginBank;
import view.ViewFunctionBank;

public class ControllerLoginCurrentBank extends ModelCurrentBank {

    Scanner write = new Scanner(System.in);
    ViewLoginBank viewLoginBank = new ViewLoginBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public void startLoginCurrentBank() {
        boolean check = loginCheckCPF();
        if (check == false) {
            viewLoginBank.errorLogin();
            twoStartLoginCurrentBank();
        } else if (check == true) {
            check = loginCheckPassword();
            if (check == false) {
                viewLoginBank.errorLogin();
                viewFunctionBank.displayExitApp();
                System.exit(0);
            }
        }
    }
    protected boolean loginCheckCPF() {
        int idCPF = viewLoginBank.displayLoginCountCurrentCPF();
        boolean check = getCurrentCountCPF(idCPF);
        if (check == true) {
            return true;
        }
        return false;
    }

    protected boolean loginCheckPassword(){
        int password = viewLoginBank.displayLoginCountCurrentPassword();
        boolean check = getCurrentCountPassword(password);
        if (check == true) {
            return true;
        }
        return false;
    }

    public void twoStartLoginCurrentBank() {
        boolean checkCPF = loginCheckCPF();
        if (checkCPF == false) {
            System.exit(0);
            viewFunctionBank.displayExitApp();
        }
    }

}
