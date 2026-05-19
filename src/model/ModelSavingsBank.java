package model;

import java.util.ArrayList;


public class ModelSavingsBank extends ModelBank {
    public ModelSavingsBank(int cpf, String name, int year, int month, int day) {
        super(cpf, name, year, month, day);
    }

    public ModelSavingsBank(int cpf, String name, int year, int month, int day, int password, double balance) {
        super(cpf, name, year, month, day, password, balance);
    }

    ArrayList<ModelSavingsBank> savingsCount = new ArrayList<>();

    public boolean getSavingsCountCPF(int cpf) {
        for (ModelSavingsBank savingsBank : savingsCount) {
            if (savingsBank.getNumberCPF() == cpf) {
                return true;
            }
        }
        return false;
    }

    public boolean getSavingsCountPassword(int password) {
        for (ModelSavingsBank savingsBank : savingsCount) {
            if (savingsBank.getPassword() == password) {
                return true;
            }
        }
        return false;
    }


}
