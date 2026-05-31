package view;

import java.util.Scanner;

import model.ModelCurrentBank;
import model.ModelSavingsBank;

public class ViewLoginBank {

    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public int displayLoginMenuCountApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                
                
                
                    Qual o tipo de Conta:
                
                      Conta Corrente [1]
                      Conta Poupança [2]
                          SAIR [3]
                """);
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }

    // Telas de Login Conta Current

    public long displayLoginCountCurrentCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                   Digite o CPF para Login:
                
                
                
                
                """);
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public int displayLoginCountCurrentPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                  Digite a SENHA para Login:
                
                
                
                
                """);
        int password = write.nextInt();
        write.nextLine();
        return password;
    }

    //Telas de login Conta Savings

    public long displayLoginCountSavingsCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                   Digite o CPF para Login:
                
                
                
                
                """);
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public int displayLoginCountSavingsPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                  Digite a SENHA para Login:
                
                
                
                
                """);
        int password = write.nextInt();
        write.nextLine();
        return password;
    }

    public void countDataTest(ModelCurrentBank conta) {
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                """);
        System.out.println(conta);

    }

    public void countDataTest(ModelSavingsBank conta) {
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                """);
        System.out.println(conta);

    }

}