package model;

import java.util.ArrayList;

abstract class ModelBank {
    private Long numberCPF;
    private String nameUser;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;
    private int password;
    private double balance;

    protected ModelBank(long cpf, String name, int year, int month, int day, int password) {
        this.nameUser = name;
        this.numberCPF = cpf;
        this.yearBirth = year;
        this.monthBirth = month;
        this.dayBirth = day;
        this.password = this.password;
    }

    protected ModelBank(long cpf, String name, int year, int month, int day, int password, double balance) {
        this(cpf, name, year, month, day, password);
        this.balance = balance;
    }

    ArrayList<ModelBank> bankCount = new ArrayList<>();

    public ModelBank getCountCPF(long cpf) {
        for (ModelBank savingsBank : bankCount) {
            if (savingsBank.getNumberCPF() == cpf) {
                return savingsBank;
            }
        }
        return null;
    }

    public boolean getCountLogin(long cpf, int password) {
        ModelBank conta = getCountCPF(cpf);
        if (conta != null && conta.getPassword() == password) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ModelBank{" +
                "balance=" + balance +
                ", numberCPF=" + numberCPF +
                ", nameUser='" + nameUser + '\'' +
                ", dayBirth=" + dayBirth +
                ", monthBirth=" + monthBirth +
                ", yearBirth=" + yearBirth +
                ", password=" + password +
                ", bankCount=" + bankCount +
                '}';
    }

    public long getNumberCPF() {
        return this.numberCPF;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getDayBirth() {
        return dayBirth;
    }

    public void setDayBirth(int dayBirth) {
        this.dayBirth = dayBirth;
    }

    public int getMonthBirth() {
        return monthBirth;
    }

    public void setMonthBirth(int monthBirth) {
        this.monthBirth = monthBirth;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}