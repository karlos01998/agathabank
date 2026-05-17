package model;

public class ModelBank {
    private int numberCPF;
    private String nameUser;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;
    private int password;

    public ModelBank(int cpf, String name, int year, int month, int day) {
        this.nameUser = name;
        this.numberCPF = cpf;
        this.yearBirth = year;
        this.monthBirth = month;
        this.dayBirth = day;
    }

    public ModelBank(int cpf, String name, int year, int month, int day, int password) {
        this(cpf, name, year, month, day);
        this.password = password;
    }

    public int getNumberCPF() {
        return numberCPF;
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
}