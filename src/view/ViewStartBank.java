package view;

import java.util.Scanner;

public class ViewStartBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public void displayStartApp() {
        System.out.println("""
                
                
                
                
                
                      |- AgathaBank -|
                
                
                
                
                """);
        viewFunctionBank.DisplayPause();
    }

    public int displayStartMenuApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                
                
                
                  Digite a opcao desejada:
                
                      Fazer Login [1]
                      Criar Conta [2]
                         SAIR [99]
                """);
        return write.nextInt();
    }



    public void displayLoginError() {
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                            ERRO!
                            
                      Dados INCORRETOS!
                
                
                
                """);
    }

    public int displayCreateCountMenuApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                
                
                
                  Qual Conta deseja abrir:
                
                      Conta Corrente [1]
                      Conta Poupança [2]
                          SAIR [99]
                """);
        return write.nextInt();
    }
}
