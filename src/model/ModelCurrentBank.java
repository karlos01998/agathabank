package model;

import model.ModelBank;

public class ModelCurrentBank extends ModelBank {
    public ModelCurrentBank(int cpf, String name, int year, int month, int day) {
        super(cpf, name, year, month, day);
    }

    public ModelCurrentBank(int cpf, String name, int year, int month, int day, int password) {
        super(cpf, name, year, month, day, password);
    }

}
