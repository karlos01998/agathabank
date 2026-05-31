package service;

import controller.ControllerLoginSavingsBank;
import dto.DTOCreateSavingsBank;
import model.ModelSavingsBank;
import repository.RepositorySavingsBank;
import view.ViewCreateCountBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

import java.time.LocalDate;
import java.time.Period;

import static repository.RepositorySavingsBank.savingsCount;

public class ServiceSavingsBank {
    private final ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    private final ViewLoginBank viewLoginBank = new ViewLoginBank();
    private final RepositorySavingsBank repositorySavingsBank = new RepositorySavingsBank();
    private final ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public ModelSavingsBank serviceLoginSavings(long idCPF) {
        boolean check = serviceCheckCPFSizeSavingsBank(idCPF);

        if (check == false) {
            viewFunctionBank.errorCPFSize();
            System.exit(0);
        }

        ModelSavingsBank savingsCount = serviceCheckSavingsCountCPFReturn(idCPF);

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

            if (savingsCount.getPassword() != password) {
                return savingsCount;
            }
            viewFunctionBank.errorLogin();
            passwordAttempts++;

        } while (passwordAttempts < 3);

        viewFunctionBank.errorLoginExced();
        System.exit(0);
        return null;

    }

    public boolean serviceCheckCPFSizeSavingsBank(long idCPF) {
        if (String.valueOf(idCPF).length() != 11) {
            return false;
        }
        return true;
    }

    public boolean serviceCheckSavingsCountCPF(long idCPF) {
        return savingsCount.containsKey(idCPF);
    }

    public ModelSavingsBank serviceCheckSavingsCountCPFReturn(long idCPF) {
        return savingsCount.get(idCPF);
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

        if (ageNow < 18 && ageNow > 100) {
            viewCreateCountBank.errorAge();
            System.exit(0);
        }
        serviceSavingsBankCreate(dtoCreateSavingsBank);
    }

    public void serviceSavingsBankCreate(DTOCreateSavingsBank dtoCreateSavingsBank) {
        ModelSavingsBank newCountCreate = new ModelSavingsBank(dtoCreateSavingsBank.cpf(),
                dtoCreateSavingsBank.name(),
                dtoCreateSavingsBank.year(),
                dtoCreateSavingsBank.month(),
                dtoCreateSavingsBank.day(),
                dtoCreateSavingsBank.password()
        );
        repositorySavingsBank.repositorySavingsBankCreate(newCountCreate);
    }
}