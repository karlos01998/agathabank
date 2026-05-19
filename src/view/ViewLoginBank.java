package view;

import java.util.Scanner;
import view.ViewFunctionBank;

public class ViewLoginBank {

    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public int displayLoginMenuCountApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                
                
                
                  Qual a conta para Login:
                
                      Conta Corrente [1]
                      Conta Poupança [2]
                          SAIR [99]
                """);
        return write.nextInt();
    }

    public int displayLoginCountCurrentCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                   Digite o CPF para Login:
                
                
                
                
                """);
        return write.nextInt();
    }

    public int displayLoginCountCurrentPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                  Digite a SENHA para Login:
                
                
                
                
                """);
        return write.nextInt();
    }

    public void errorLogin(){
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                            ERRO!
                            
                      Dados INCORRETOS!
                
                
                
                """);
        viewFunctionBank.DisplayPause();
    }
}
