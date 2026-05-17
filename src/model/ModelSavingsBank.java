package model;

import java.util.Scanner;

import model.ModelBank;

public class ModelSavingsBank extends ModelBank {
    public ModelSavingsBank(int cpf, String name, int year, int month, int day) {
        super(cpf, name, year, month, day);
    }

    public ModelSavingsBank(int cpf, String name, int year, int month, int day, int password) {
        super(cpf, name, year, month, day, password);
    }
}
