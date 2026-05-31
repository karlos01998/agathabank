package repository;

import model.ModelSavingsBank;

import java.util.HashMap;
import java.util.Map;

public class RepositorySavingsBank {
    public static Map<Long, ModelSavingsBank> savingsCount = new HashMap<>();

    public static void modelSavingsBankCreateInity() {
        ModelSavingsBank countOne = new ModelSavingsBank(12345678901L, "Maria Eunice", 2000, 5, 6, 654321, 1000000);
        ModelSavingsBank countTwo = new ModelSavingsBank(12345678910L, "Agatha Leal", 2017, 7, 30, 80, 2000);

        savingsCount.put(countOne.getNumberCPF(), countOne);
        savingsCount.put(countTwo.getNumberCPF(), countTwo);
    }

    public void repositorySavingsBankCreate(ModelSavingsBank modelSavingsBank) {
        savingsCount.put(modelSavingsBank.getNumberCPF(), modelSavingsBank);
    }
}