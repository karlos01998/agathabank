package repository;

import model.ModelCurrentBank;

import java.util.ArrayList;

public class RepositoryCurrentBank {
    public static ArrayList<ModelCurrentBank> currentCount = new ArrayList<>();

    public static void modelCurrentBankCreate() {
        currentCount.add(new ModelCurrentBank(12345678901L, "Maria Eunice", 2000, 5, 6, 654321, 1000000));
        currentCount.add(new ModelCurrentBank(12345678910L, "Agatha Leal", 2017, 7,30,80,2000));
    }
}
