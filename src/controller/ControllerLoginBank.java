package controller;
import java.util.Scanner;

import model.ModelBank;
import view.ViewLoginBank;

public class ControllerLoginBank extends ModelBank{

    Scanner write = new Scanner(System.in);
    ViewLoginBank viewLoginBank = new ViewLoginBank();

    public ControllerLoginBank(int cpf, String name, int year, int month, int day) {
        super(cpf, name, year, month, day);
    }

    public ControllerLoginBank(int cpf, String name, int year, int month, int day, int password) {
        super(cpf, name, year, month, day, password);
        this.setPassword(password);
    }
}
