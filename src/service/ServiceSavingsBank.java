package service;

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

            // 🔐 CORREÇÃO: Se a senha for IGUAL (==), o login é autorizado com sucesso!
            if (savingsCount.getPassword() == password) {
                passwordAttempts = 0; // Reseta o contador para o próximo login
                return savingsCount;
            }

            // Se a senha for errada, executa o bloco abaixo
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

    // 🔥 ESPELHAMENTO: Método adicionado para checar o saldo da poupança antes do PIX
    public boolean serviceCheckValuePixSavingsBank(long idCPF, double valuePix) {
        ModelSavingsBank modelSavingsCount = serviceCheckSavingsCountCPFReturn(idCPF);

        // Proteção contra NullPointerException caso a conta não seja instanciada
        if (modelSavingsCount == null) {
            return false;
        }

        if (modelSavingsCount.getBalance() < valuePix) {
            return false;
        }
        return true;
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

        // 🧠 CORREÇÃO: Mudado de && para || (Se for menor de 18 OU maior de 100)
        if (ageNow < 18 || ageNow > 100) {
            viewCreateCountBank.errorAge();
            System.exit(0);
        }
        serviceSavingsBankCreate(dtoCreateSavingsBank);
    }

    public void serviceSavingsBankCreate(DTOCreateSavingsBank dtoCreateSavingsBank) {
        ModelSavingsBank newCountCreate = new ModelSavingsBank(
                dtoCreateSavingsBank.cpf(),
                dtoCreateSavingsBank.name(),
                dtoCreateSavingsBank.year(),
                dtoCreateSavingsBank.month(),
                dtoCreateSavingsBank.day(),
                dtoCreateSavingsBank.password()
        );
        repositorySavingsBank.repositorySavingsBankCreate(newCountCreate);
    }
}