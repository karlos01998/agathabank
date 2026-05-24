package repository;

import model.ModelCurrentBank;
import view.ViewFunctionBank;

import java.util.ArrayList;

public class RepositoryCurrentBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    public static ArrayList<ModelCurrentBank> currentCount = new ArrayList<>();

    public static void modelCurrentBankCreateInity() {
        currentCount.add(new ModelCurrentBank(12345678901L, "Maria Eunice", 2000, 5, 6, 654321, 1000000));
        currentCount.add(new ModelCurrentBank(12345678910L, "Agatha Leal", 2017, 7,30,80,2000));
    }

    public void repositoryCurrentBankCreate(ModelCurrentBank modelCurrentBank) {
        currentCount.add(modelCurrentBank);
    }
}
