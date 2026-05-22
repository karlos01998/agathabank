package controller;

import model.ModelCurrentBank;

import java.util.ArrayList;

public class ControllerCreateCurrentBank{

    static ArrayList<ModelCurrentBank> currentCount = new ArrayList<>();

    public static void modelCurrentBankCreate() {
        currentCount.add(new ModelCurrentBank(12345678901L, "Maria Eunice", 2000, 5, 6, 654321, 1000000));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
