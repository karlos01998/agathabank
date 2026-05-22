package model;

import java.util.ArrayList;

public class ModelCurrentBank extends ModelBank {

    boolean debt;
    double debtBalance;
    boolean creditCard;
    double creditCardBalance;
    boolean loan;
    double loanBalance;

    public ModelCurrentBank(long cpf, String name, int year, int month, int day) {
        super(cpf, name, year, month, day);
    }

    public ModelCurrentBank(long cpf, String name, int year, int month, int day, int password) {
        super(cpf, name, year, month, day, password);
    }

    public ModelCurrentBank(long cpf, String name, int year, int month, int day, int password, double balance) {
        super(cpf, name, year, month, day, password, balance);
    }
    public ModelCurrentBank(long cpf, String name, int year, int month, int day, int password,
                            double balance, boolean debt, boolean creditCard, boolean loan) {
        super(cpf, name, year, month, day, password, balance);
        this.debt = debt;
        this.creditCard = creditCard;
        this.loan = loan;
    }

    public boolean isCreditCard() {
        return creditCard;
    }
    public void setCreditCard(boolean creditCard) {
        this.creditCard = creditCard;
    }
    public double getCreditCardBalance() {
        return creditCardBalance;
    }
    public void setCreditCardBalance(double creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }
    public boolean isLoan() {
        return loan;
    }
    public void setLoan(boolean loan) {
        this.loan = loan;
    }
    public double getLoanBalance() {
        return loanBalance;
    }
    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }

}
