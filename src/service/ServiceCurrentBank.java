package service;

import controller.ControllerLoginCurrentBank;
import dto.DTOCreateCurrentBank;
import model.ModelCurrentBank;
import repository.RepositoryCurrentBank;
import view.ViewCreateCountBank;
import view.ViewFunctionBank;
import view.ViewLoginBank;

import java.time.LocalDate;
import java.time.Period;

import static repository.RepositoryCurrentBank.currentCount;

public class ServiceCurrentBank {
    private final ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    private final ViewLoginBank viewLoginBank = new ViewLoginBank();
    private final RepositoryCurrentBank repositoryCurrentBank = new RepositoryCurrentBank();
    private final ViewCreateCountBank viewCreateCountBank = new ViewCreateCountBank();

    private int passwordAttempts = 0;
    private int cpfAttempts = 0;

    public ModelCurrentBank serviceLoginCurrent(long idCPF) {
        boolean check = serviceCheckCPFSizeCurrentBank(idCPF);

        if (check == false) {
            viewFunctionBank.errorCPFSize();
            System.exit(0);
        }

        ModelCurrentBank currentCount = serviceCheckCurrentCountCPFReturn(idCPF);

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

            if (currentCount.getPassword() != password) {
                return currentCount;
            }
            viewFunctionBank.errorLogin();
            passwordAttempts++;

        } while (passwordAttempts < 3);

        viewFunctionBank.errorLoginExced();
        System.exit(0);
        return null;

    }

    public boolean serviceCheckCPFSizeCurrentBank(long idCPF) {
        if (String.valueOf(idCPF).length() != 11) {
            return false;
        }
        return true;
    }

    public boolean serviceCheckCurrentCountCPF(long idCPF) {
        return currentCount.containsKey(idCPF);
    }

    public ModelCurrentBank serviceCheckCurrentCountCPFReturn(long idCPF) {
        return repositoryCurrentBank.currentCount.get(idCPF);
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

        if (ageNow < 18 && ageNow > 100) {
            viewCreateCountBank.errorAge();
            System.exit(0);
        }
        serviceCurrentBankCreate(dtoCreateCurrentBank);
    }

    public void serviceCurrentBankCreate(DTOCreateCurrentBank dtoCreateCurrentBank) {
        ModelCurrentBank newCountCreate = new ModelCurrentBank(dtoCreateCurrentBank.cpf(),
                dtoCreateCurrentBank.name(),
                dtoCreateCurrentBank.year(),
                dtoCreateCurrentBank.month(),
                dtoCreateCurrentBank.day(),
                dtoCreateCurrentBank.password()
        );
        repositoryCurrentBank.repositoryCurrentBankCreate(newCountCreate);
    }
}