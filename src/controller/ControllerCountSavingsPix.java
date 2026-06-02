package controller;

import model.ModelCurrentBank;
import model.ModelSavingsBank;
import service.ServiceCurrentBank;
import service.ServiceSavingsBank;
import view.ViewCountCurrentPIX;
import view.ViewCountSavingsPIX;
import view.ViewFunctionBank;

public class ControllerCountSavingsPix {
    ViewCountSavingsPIX viewCountSavingsPIX = new ViewCountSavingsPIX();
    ServiceSavingsBank serviceSavingsBank = new ServiceSavingsBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ServiceCurrentBank serviceCurrentBank = new ServiceCurrentBank();
    ControllerCountSavingsBank controllerCountSavingsBank = new ControllerCountSavingsBank();
    ViewCountCurrentPIX viewCountCurrentPIX = new ViewCountCurrentPIX();

    double valuePIX = 0;
    boolean checkValue;

    public void startSavingsPix(ModelSavingsBank modelSavingsBank) {
        long idCPF = viewCountSavingsPIX.displayCountSavingsPIX(modelSavingsBank);
        ModelCurrentBank modelCurrentBankReceiver = null;

        boolean checkSize = serviceSavingsBank.serviceCheckCPFSizeSavingsBank(idCPF);
        if (checkSize == false) {
            viewFunctionBank.errorCPFSize();
            startSavingsPix(modelSavingsBank);
            return;
        }

        ModelSavingsBank modelSavingsBankReceiver = serviceSavingsBank.serviceCheckSavingsCountCPFReturn(idCPF);
        if (modelSavingsBankReceiver == null) {
            modelCurrentBankReceiver = serviceCurrentBank.serviceCheckCurrentCountCPFReturn(idCPF);
            if (modelCurrentBankReceiver == null) {
                viewCountSavingsPIX.displaySavingsPIXFoundError();
                startSavingsPix(modelSavingsBank);
                return;
            }
        }

        // Linhas para poupança
        if (modelSavingsBankReceiver != null) {
            valuePIX = viewCountSavingsPIX.displayCountSavingsPIXValue(modelSavingsBank);
            checkValue = savingsPixSavingsValue(modelSavingsBank.getNumberCPF(), valuePIX);
            if (checkValue == false) {
                // Se não tem saldo, o método corta a execução aqui
                startSavingsPix(modelSavingsBank);
                return;
            }
            savingsPixSavingsTransfer(modelSavingsBank, modelSavingsBankReceiver, valuePIX);

            // Linhas para corrente
        } else if (modelCurrentBankReceiver != null) {
            valuePIX = viewCountSavingsPIX.displayCountSavingsPIXValue(modelSavingsBank);
            checkValue = savingsPixCurrentValue(modelSavingsBank.getNumberCPF(), valuePIX);
            if (checkValue == false) {
                // Se não tem saldo, o método corta a execução aqui
                startSavingsPix(modelSavingsBank);
                return;
            }
            savingsPixCurrentTransfer(modelSavingsBank, modelCurrentBankReceiver, valuePIX);
        }
    }

    public void savingsPixSavingsTransfer(ModelSavingsBank modelSavingsBank, ModelSavingsBank modelSavingsBankReceiver, double valuePIX) {
        double balanceValueFrom = modelSavingsBank.getBalance() - valuePIX;
        modelSavingsBank.setBalance(balanceValueFrom);

        double balanceValueReceiver = modelSavingsBankReceiver.getBalance() + valuePIX;
        modelSavingsBankReceiver.setBalance(balanceValueReceiver);

        modelSavingsBank.addTransactionToExtract(
                modelSavingsBank.getNameUser(),
                modelSavingsBankReceiver.getNameUser(),
                valuePIX
        );

        modelSavingsBankReceiver.addTransactionToExtract(
                modelSavingsBank.getNameUser(),
                modelSavingsBankReceiver.getNameUser(),
                valuePIX
        );

        savingsSavingsProof(modelSavingsBank, modelSavingsBankReceiver, valuePIX);
    }

    public void savingsPixCurrentTransfer(ModelSavingsBank modelSavingsBank, ModelCurrentBank modelCurrentBank, double valuePIX) {
        double balanceValueFrom = modelSavingsBank.getBalance() - valuePIX;
        modelSavingsBank.setBalance(balanceValueFrom);

        double balanceValueReceiver = modelCurrentBank.getBalance() + valuePIX;
        modelCurrentBank.setBalance(balanceValueReceiver);

        modelSavingsBank.addTransactionToExtract(
                modelSavingsBank.getNameUser(),
                modelCurrentBank.getNameUser(),
                valuePIX
        );

        modelCurrentBank.addTransactionToExtract(
                modelSavingsBank.getNameUser(),
                modelCurrentBank.getNameUser(),
                valuePIX
        );

        savingsCurrentProof(modelSavingsBank, modelCurrentBank, valuePIX);
    }

    public void savingsSavingsProof(ModelSavingsBank modelSavingsBank, ModelSavingsBank modelSavingsBankReceiver, double valuePIX) {
        viewCountSavingsPIX.displayCountSavingsPIXSavings(modelSavingsBank, modelSavingsBankReceiver, valuePIX);
        // 🔥 REMOVIDO: controllerCountSavingsBank.displayCountSavings(modelSavingsBank);
    }

    public void savingsCurrentProof(ModelSavingsBank modelSavingsBank, ModelCurrentBank modelCurrentBank, double valuePIX) {
        viewCountSavingsPIX.displayCountSavingsPIXCurrent(modelSavingsBank, modelCurrentBank, valuePIX);
        // 🔥 REMOVIDO: controllerCountSavingsBank.displayCountSavings(modelSavingsBank);
    }

    // 🔥 MÉTODOS CORRIGIDOS ABAIXO: Capturando o booleano real da ServiceSavingsBank

    // Checagem de valor na Poupanca para enviar para outra Poupanca
    public boolean savingsPixSavingsValue(long idCPF, double valuePix) {
        boolean temSaldo = serviceSavingsBank.serviceCheckValuePixSavingsBank(idCPF, valuePix);
        if (temSaldo == false) {
            viewCountSavingsPIX.displaySavingsPIXBalanceError();
            return false;
        }
        return true;
    }

    // Checagem de valor na Poupanca para enviar para uma Corrente
    public boolean savingsPixCurrentValue(long idCPF, double valuePix) {
        // Quem envia continua sendo a POUPANÇA de origem, logo usa a serviceSavingsBank
        boolean temSaldo = serviceSavingsBank.serviceCheckValuePixSavingsBank(idCPF, valuePix);
        if (temSaldo == false) {
            viewCountSavingsPIX.displaySavingsPIXBalanceError();
            return false;
        }
        return true;
    }
}