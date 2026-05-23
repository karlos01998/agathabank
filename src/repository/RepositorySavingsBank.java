package repository;

import model.ModelSavingsBank;

import java.util.ArrayList;

public class RepositorySavingsBank {
    public static ArrayList<ModelSavingsBank> SavingsCount = new ArrayList<>();

    public static void modelSavingsBankCreate() {
        SavingsCount.add(new ModelSavingsBank(12345678901L, "Maria Eunice", 2000, 5, 6, 123456));
    }
}
