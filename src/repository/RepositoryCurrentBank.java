package repository;

import model.ModelCurrentBank;

import java.util.HashMap;
import java.util.Map;

public class RepositoryCurrentBank {
    public static Map<Long, ModelCurrentBank> currentCount = new HashMap<>();

    public static void repositoryCurrentBankCreateInity() {
        ModelCurrentBank countOne = new ModelCurrentBank(12345678901L, "Maria Eunice", 2000, 5, 6, 654321, 1000000);
        ModelCurrentBank countTwo = new ModelCurrentBank(12345678910L, "Agatha Leal", 2017, 7,30,80,2000);
        ModelCurrentBank countTree = new ModelCurrentBank(12345678950L, "Joao Carlos", 1998, 06, 28, 29,1000);

        currentCount.put(countOne.getNumberCPF(), countOne);
        currentCount.put(countTwo.getNumberCPF(), countTwo);
        currentCount.put(countTree.getNumberCPF(), countTree);
    }

    public void repositoryCurrentBankCreate(ModelCurrentBank modelCurrentBank) {
        currentCount.put(modelCurrentBank.getNumberCPF(), modelCurrentBank);
    }
}