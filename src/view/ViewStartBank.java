package view;

import java.util.Scanner;

public class ViewStartBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public void displayStartApp() {
        System.out.println("""
                =====================================
                
                          |- AgathaBank -|
                    Sua plataforma financeira terminal
                    
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public int displayStartMenuApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                =====================================
                 Selecione uma operação para iniciar:
                
                    [1] Entrar na minha Conta
                    [2] Criar uma nova Conta
                    
                    [3] Sair do Sistema
                =====================================
                """);
        System.out.print(" Opção > ");
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }

    public int displayCreateCountMenuApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- NOVA CONTA  -|
                =====================================
                 Escolha a categoria que deseja abrir:
                
                    [1] Conta Corrente
                    [2] Conta Poupança
                    
                    [3] Voltar ao Início
                =====================================
                """);
        System.out.print(" Opção > ");
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }
}