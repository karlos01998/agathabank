package view;

import java.util.Scanner;

public class ViewCreateCountBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public int displayCreateCountMenuCountApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                
                
                
                    Qual o tipo de Conta:
                
                      Conta Corrente [1]
                      Conta Poupança [2]
                          SAIR [3]
                """);
        return write.nextInt();
    }

    //Telas para Conta Current//

    public long displayCreateCountCurrentCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                        Digite o CPF:
                
                
                
                
                """);
        return write.nextLong();
    }

    public int displayCreateCountCurrentPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                      Digite a SENHA:
                        [6 NUMEROS]
                
                
                
                
                """);
        return write.nextInt();
    }

    //Telas para Conta SAVINGS//

    public long displayCreateCountSavingsCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupanca
                
                
                        Digite o CPF:
                
                
                
                
                """);
        return write.nextLong();
    }

    public int displayCreateCountSavingsPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupanca
                
                
                      Digite a SENHA:
                        [6 NUMEROS]
                
                
                
                
                """);
        return write.nextInt();
    }
}
