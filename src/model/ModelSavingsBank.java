package model;

import java.util.ArrayList;

public class ModelSavingsBank extends ModelBank {
    private static final float YELD_RATE = 0.5f;

    public ModelSavingsBank(long cpf, String name, int year, int month, int day) {
        super(cpf, name, year, month, day);
    }

    public ModelSavingsBank(long cpf, String name, int year, int month, int day, int password, double balance) {
        super(cpf, name, year, month, day, password, balance);
    }

    public ModelSavingsBank(long cpf, String name, int year, int month, int day, int password) {
        super(cpf, name, year, month, day, password);
    }

    @Override
    public String toString() {
        return "ModelSavingsBank{" +
                "bankCount=" + bankCount +
                '}';
    }

    @Override
    public void setBalance(double balance) {
        if (balance < 0) {

        }
        super.setBalance(balance);
    }
}
