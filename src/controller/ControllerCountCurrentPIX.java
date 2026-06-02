package controller;

import model.ModelCurrentBank;
import model.ModelSavingsBank;
import service.ServiceCurrentBank;
import service.ServiceSavingsBank;
import view.ViewCountCurrentPIX;
import view.ViewFunctionBank;

public class ControllerCountCurrentPIX {
    ViewCountCurrentPIX viewCountCurrentPIX = new ViewCountCurrentPIX();
    ServiceCurrentBank serviceCurrentBank = new ServiceCurrentBank();
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    ServiceSavingsBank serviceSavingsBank = new ServiceSavingsBank();

    double valuePIX = 0;
    boolean checkValue;

    public void startCurrentPix(ModelCurrentBank modelCurrentBank) {
        long idCPF = viewCountCurrentPIX.displayCountCurrentPIX(modelCurrentBank);
        ModelSavingsBank modelSavingsBankReceiver = null;

        boolean checkSize = serviceCurrentBank.serviceCheckCPFSizeCurrentBank(idCPF);
        if (checkSize == false) {
            viewFunctionBank.errorCPFSize();
            return;
        }

        ModelCurrentBank modelCurrentBankReceiver = serviceCurrentBank.serviceCheckCurrentCountCPFReturn(idCPF);
        if (modelCurrentBankReceiver == null) {
            modelSavingsBankReceiver = serviceSavingsBank.serviceCheckSavingsCountCPFReturn(idCPF);
            if (modelSavingsBankReceiver == null) {
                viewCountCurrentPIX.displayCurrentPIXFoundError();
                return;
            }
        }

        // ─── FLUXO PARA CONTA DESTINO CORRENTE ───
        if (modelCurrentBankReceiver != null) {
            valuePIX = viewCountCurrentPIX.displayCountCurrentPIXValue(modelCurrentBank);

            // 🔥 TELA DE CONFIRMAÇÃO INSERIDA AQUI (image_c52cbb.png)
            int conf = viewCountCurrentPIX.displayCountCurrentPIXCurrentFind(modelCurrentBank, modelCurrentBankReceiver);
            if (conf == 2) {
                return; // Usuário escolheu "Voltar" -> Retorna direto para o menu do banco
            }

            checkValue = currentPixCurrentValue(modelCurrentBank.getNumberCPF(), valuePIX);
            if (checkValue == false) {
                return;
            }
            currentPixCurrentTransfer(modelCurrentBank, modelCurrentBankReceiver, valuePIX);
            currentCurrentProof(modelCurrentBank, modelCurrentBankReceiver, valuePIX);

            // ─── FLUXO PARA CONTA DESTINO POUPANÇA ───
        } else if (modelSavingsBankReceiver != null) {
            valuePIX = viewCountCurrentPIX.displayCountCurrentPIXValue(modelCurrentBank);

            // 🔥 TELA DE CONFIRMAÇÃO INSERIDA AQUI (Espelhada para Poupança)
            int conf = viewCountCurrentPIX.displayCountCurrentPIXSavingsFind(modelCurrentBank, modelSavingsBankReceiver);
            if (conf == 2) {
                return; // Usuário escolheu "Voltar" -> Retorna direto para o menu do banco
            }

            checkValue = currentPixSavingsValue(modelCurrentBank.getNumberCPF(), valuePIX);
            if (checkValue == false) {
                return;
            }
            currentPixSavingsTransfer(modelCurrentBank, modelSavingsBankReceiver, valuePIX);
            currentSavingsProof(modelCurrentBank, modelSavingsBankReceiver, valuePIX);
        }
    }

    public void currentPixCurrentTransfer(ModelCurrentBank modelCurrentBank, ModelCurrentBank modelCurrentBankReceiver, double valuePIX) {
        modelCurrentBank.setBalance(modelCurrentBank.getBalance() - valuePIX);
        modelCurrentBankReceiver.setBalance(modelCurrentBankReceiver.getBalance() + valuePIX);

        modelCurrentBank.addTransactionToExtract(modelCurrentBank.getNameUser(), modelCurrentBankReceiver.getNameUser(), valuePIX);
        modelCurrentBankReceiver.addTransactionToExtract(modelCurrentBank.getNameUser(), modelCurrentBankReceiver.getNameUser(), valuePIX);
    }

    public void currentPixSavingsTransfer(ModelCurrentBank modelCurrentBank, ModelSavingsBank modelSavingsBank, double valuePIX) {
        modelCurrentBank.setBalance(modelCurrentBank.getBalance() - valuePIX);
        modelSavingsBank.setBalance(modelSavingsBank.getBalance() + valuePIX);

        modelCurrentBank.addTransactionToExtract(modelCurrentBank.getNameUser(), modelSavingsBank.getNameUser(), valuePIX);
        modelSavingsBank.addTransactionToExtract(modelCurrentBank.getNameUser(), modelSavingsBank.getNameUser(), valuePIX);
    }

    public void currentCurrentProof(ModelCurrentBank modelCurrentBank, ModelCurrentBank modelCurrentBankReceiver, double valuePIX) {
        viewCountCurrentPIX.displayCountCurrentPIXCurrent(modelCurrentBank, modelCurrentBankReceiver, valuePIX);
    }

    public void currentSavingsProof(ModelCurrentBank modelCurrentBank, ModelSavingsBank modelSavingsBank, double valuePIX) {
        viewCountCurrentPIX.displayCountCurrentPIXSavings(modelCurrentBank, modelSavingsBank, valuePIX);
    }

    public boolean currentPixCurrentValue(long idCPF, double valuePix) {
        boolean temSaldo = serviceCurrentBank.serviceCheckValuePixCurrentBank(idCPF, valuePix);
        if (temSaldo == false) {
            viewCountCurrentPIX.displayCurrentPIXBalanceError();
            return false;
        }
        return true;
    }

    public boolean currentPixSavingsValue(long idCPF, double valuePix) {
        boolean temSaldo = serviceSavingsBank.serviceCheckValuePixSavingsBank(idCPF, valuePix);
        if (temSaldo == false) {
            viewCountCurrentPIX.displayCurrentPIXBalanceError();
            return false;
        }
        return true;
    }
}