package repository;

import model.ModelCurrentBank;

import java.util.HashMap;
import java.util.Map;

public class RepositoryCurrentBank {
    public static Map<Long, ModelCurrentBank> currentCount = new HashMap<>();

    public static void repositoryCurrentBankCreateInity() {
        ModelCurrentBank countOne = new ModelCurrentBank(12345678901L, "Maria Eunice", 2000, 5, 6, 654321, 1000000);
        ModelCurrentBank countTwo = new ModelCurrentBank(12345678910L, "Agatha Leal", 2017, 7,30,80,2000);

        currentCount.put(countOne.getNumberCPF(), countOne);
        currentCount.put(countTwo.getNumberCPF(), countTwo);
    }

    public void repositoryCurrentBankCreate(ModelCurrentBank modelCurrentBank) {
        currentCount.put(modelCurrentBank.getNumberCPF(), modelCurrentBank);
    }
}