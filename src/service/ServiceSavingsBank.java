package service;

import dto.DTOCreateCurrentBank;
import dto.DTOCreateSavingsBank;
import model.ModelCurrentBank;
import model.ModelSavingsBank;
import repository.RepositoryCurrentBank;
import repository.RepositorySavingsBank;
import view.ViewCreateCountBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

import java.time.LocalDate;
import java.time.Period;

public class ServiceSavingsBank {
    private final ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    private final ViewLoginBank viewLoginBank = new ViewLoginBank();
    private final RepositorySavingsBank repositorySavingsBank = new RepositorySavingsBank();
    private final ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public ModelSavingsBank serviceLoginSavings(long idCPF) {
        ModelSavingsBank savingsCount = serviceGetSavingsCountCPF(idCPF);

        if (savingsCount == null) {
            viewFunctionBank.errorLogin();
            cpfAttempts++;

            if (cpfAttempts >= 3) {
                viewFunctionBank.errorLoginExced();
                System.exit(0);
            }
            return null;
        }

        cpfAttempts = 0;

        do {
            int password = viewLoginBank.displayLoginCountSavingsPassword();

            if (savingsCount.getPassword() == password) {
                return savingsCount;
            }
            viewFunctionBank.errorLogin();
            passwordAttempts++;

        } while (passwordAttempts < 3);

        viewFunctionBank.errorLoginExced();
        System.exit(0);
        return null;

    }

    public void serviceCheckSavingsCountCPF(DTOCreateSavingsBank dtoCreateSavingsBank) {
        long idCPF = dtoCreateSavingsBank.cpf();

        if (String.valueOf(idCPF).length() != 11) {
            viewCreateCountBank.errorCPF();
            System.exit(0);
        }

        ModelSavingsBank savingsCount = serviceGetSavingsCountCPF(idCPF);
        if (savingsCount == null) {
            viewFunctionBank.errorLogin();
            System.exit(0);
        }
        serviceCheckSavingsCountPassword(dtoCreateSavingsBank);
    }

    public static ModelSavingsBank serviceGetSavingsCountCPF(long idCPF) {
        for (ModelSavingsBank savingsBank : RepositorySavingsBank.savingsCount) {
            if (savingsBank.getNumberCPF() == idCPF) {
                return savingsBank;
            }
        }
        return null;
    }

    public void serviceCheckSavingsCountPassword(DTOCreateSavingsBank dtoCreateSavingsBank) {
        int idPassword = dtoCreateSavingsBank.password();

        if (String.valueOf(idPassword).length() != 6) {
            viewCreateCountBank.errorPassword();
            System.exit(0);
        }
        serviceGetSavingsCountAge(dtoCreateSavingsBank);
    }

    public void serviceGetSavingsCountAge(DTOCreateSavingsBank dtoCreateSavingsBank) {
        LocalDate age = LocalDate.of(
                dtoCreateSavingsBank.year(),
                dtoCreateSavingsBank.month(),
                dtoCreateSavingsBank.day()
        );

        LocalDate date = LocalDate.now();

        int ageNow = Period.between(age, date).getYears();

        if (ageNow > 18 && ageNow < 100) {
            viewCreateCountBank.errorAge();
            System.exit(0);
        }
        repositorySavingsBank.modelSavingsBankCreate(dtoCreateSavingsBank);
        viewFunctionBank.displaycount();
    }
}