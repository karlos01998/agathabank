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

    @Override
    public String toString() {
        return "DADOS BANCARIOS" + '\n' +
                "Saldo: " + getBalance() + '0' +'\n' +
                "CPF: " + getNumberCPF() +'\n' +
                "Nome: " + getNameUser() + '\'' +'\n' +
                "Aniversario: " + '\n' + getDayBirth() +'/' +
                 getMonthBirth() +
                "/" + getYearBirth() +'\n' +
                "SENHA: " + getPassword() +'\n' +
                "Cartao de Credito? " + creditCard +'\n' +
                "Limite no cartao: " + creditCardBalance +'\n' +
                "Divida? " + debt +'\n' +
                "Saldo devedor: " + debtBalance +'\n' +
                "Emprestimo Disponivel: " + loan +'\n' +
                "Valor do emprestimo: " + loanBalance ;
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
