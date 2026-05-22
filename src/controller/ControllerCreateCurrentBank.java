package controller;

import model.ModelCurrentBank;

import java.util.ArrayList;

public class ControllerCreateCurrentBank{

    static ArrayList<ModelCurrentBank> currentCount = new ArrayList<>();


    public static void modelCurrentBankCreate(){
        currentCount.add(new ModelCurrentBank(12345678901L, "Maria Eunice", 2000, 5, 6, 123456));
    }

    public static boolean getCurrentCountCPF(long cpf) {
        for (ModelCurrentBank currentBank : currentCount) {
            if (currentBank.getNumberCPF() == cpf) {
                return true;
            }
        }
        return false;
    }

    public static boolean getCurrentCountPassword(int password) {
        for (ModelCurrentBank currentBank : currentCount) {
            if (currentBank.getPassword() == password) {
                return true;
            }
        }
        return false;
    }
}
