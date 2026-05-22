package controller;

import model.ModelSavingsBank;

import java.util.ArrayList;

public class ControllerCreateSavingsBank {

    static ArrayList<ModelSavingsBank> SavingsCount = new ArrayList<>();

    public static void modelSavingsBankCreate() {
        SavingsCount.add(new ModelSavingsBank(12345678901L, "Maria Eunice", 2000, 5, 6, 123456));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
