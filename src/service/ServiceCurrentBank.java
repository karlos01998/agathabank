package service;

import dto.DTOCreateCurrentBank;
import model.ModelCurrentBank;
import repository.RepositoryCurrentBank;
import view.ViewCreateCountBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

import java.time.LocalDate;
import java.time.Period;

public class ServiceCurrentBank {
    private final ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    private final ViewLoginBank viewLoginBank = new ViewLoginBank();
    private final RepositoryCurrentBank repositoryCurrentBank = new RepositoryCurrentBank();
    private final ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public ModelCurrentBank serviceLoginCurrent(long idCPF) {
        ModelCurrentBank currentCount = serviceGetCurrentCountCPF(idCPF);

        if (currentCount == null) {
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
            int password = viewLoginBank.displayLoginCountCurrentPassword();

            if (currentCount.getPassword() == password) {
                return currentCount;
            }
            viewFunctionBank.errorLogin();
            passwordAttempts++;

        } while (passwordAttempts < 3);

        viewFunctionBank.errorLoginExced();
        System.exit(0);
        return null;

    }

    public void serviceCheckCurrentCountCPF(DTOCreateCurrentBank dtoCreateCurrentBank) {
        long idCPF = dtoCreateCurrentBank.cpf();

        if (String.valueOf(idCPF).length() != 11) {
            viewCreateCountBank.errorCPF();
            System.exit(0);
        }

        ModelCurrentBank currentCount = serviceGetCurrentCountCPF(idCPF);
        if (currentCount == null) {
            viewFunctionBank.errorLogin();
            System.exit(0);
        }
        serviceCheckCurrentCountPassword(dtoCreateCurrentBank);
    }

    public static ModelCurrentBank serviceGetCurrentCountCPF(long idCPF) {
        for (ModelCurrentBank currentBank : RepositoryCurrentBank.currentCount) {
            if (currentBank.getNumberCPF() == idCPF) {
                return currentBank;
            }
        }
        return null;
    }

    public void serviceCheckCurrentCountPassword(DTOCreateCurrentBank dtoCreateCurrentBank) {
        int idPassword = dtoCreateCurrentBank.password();

        if (String.valueOf(idPassword).length() != 6) {
            viewCreateCountBank.errorPassword();
            System.exit(0);
        }
        serviceGetCurrentCountAge(dtoCreateCurrentBank);
    }

    public void serviceGetCurrentCountAge(DTOCreateCurrentBank dtoCreateCurrentBank) {
        LocalDate age = LocalDate.of(
                dtoCreateCurrentBank.year(),
                dtoCreateCurrentBank.month(),
                dtoCreateCurrentBank.day()
        );

        LocalDate date = LocalDate.now();

        int ageNow = Period.between(age, date).getYears();

        if (ageNow > 18 && ageNow < 100) {
            viewCreateCountBank.errorAge();
            System.exit(0);
        }
        repositoryCurrentBank.modelCurrentBankCreate(dtoCreateCurrentBank);
        viewFunctionBank.displaycount();
    }
}

