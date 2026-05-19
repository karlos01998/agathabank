package model;

abstract class ModelBank {
    private int numberCPF;
    private String nameUser;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;
    private int password;
    private double balance;

    protected ModelBank(int cpf, String name, int year, int month, int day) {
        this.nameUser = name;
        this.numberCPF = cpf;
        this.yearBirth = year;
        this.monthBirth = month;
        this.dayBirth = day;
    }

    protected ModelBank(int cpf, String name, int year, int month, int day, int password, double balance) {
        this(cpf, name, year, month, day);
        this.password = password;
        this.balance = balance;
    }

    protected int getNumberCPF() {
        return numberCPF;
    }

    protected String getNameUser() {

        return nameUser;
    }

    protected void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    protected int getDayBirth() {
        return dayBirth;
    }

    protected void setDayBirth(int dayBirth) {
        this.dayBirth = dayBirth;
    }

    protected int getMonthBirth() {
        return monthBirth;
    }

    protected void setMonthBirth(int monthBirth) {
        this.monthBirth = monthBirth;
    }

    protected int getYearBirth() {
        return yearBirth;
    }

    protected void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    protected int getPassword() {
        return password;
    }

    protected void setPassword(int password) {
        this.password = password;
    }

    protected double getBalance() {
        return balance;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}