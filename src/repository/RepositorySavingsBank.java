package repository;

import dto.DTOCreateCurrentBank;
import dto.DTOCreateSavingsBank;
import model.ModelCurrentBank;
import model.ModelSavingsBank;
import view.ViewFunctionBank;

import java.util.ArrayList;

public class RepositorySavingsBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    public static ArrayList<ModelSavingsBank> savingsCount = new ArrayList<>();

    public static void modelSavingsBankCreateInity() {
        savingsCount.add(new ModelSavingsBank(12345678901L, "Maria Eunice", 2000, 5, 6, 654321, 1000000));
        savingsCount.add(new ModelSavingsBank(12345678910L, "Agatha Leal", 2017, 7,30,80,2000));
    }

    public void modelSavingsBankCreate(DTOCreateSavingsBank dtoCreateSavingsBank) {
        ModelSavingsBank newCountCreate = new ModelSavingsBank(dtoCreateSavingsBank.cpf(),
                dtoCreateSavingsBank.name(),
                dtoCreateSavingsBank.year(),
                dtoCreateSavingsBank.month(),
                dtoCreateSavingsBank.day(),
                dtoCreateSavingsBank.password()
        );
        savingsCount.add(newCountCreate);
        viewFunctionBank.displaycount();
    }

}