package view;

import java.util.Scanner;

public class ViewFunctionBank {
    Scanner write = new Scanner(System.in);

    public void clearDisplay() {
        try {
            // Verifica se o sistema é Windows e executa o comando 'cls'
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Caso um dia rode no Linux/Mac, executa 'clear'
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Se falhar, não faz nada para não travar o app
        }

    }

    public void DisplayPause() {
        System.out.println("   Enter para PROSSEGUIR...");
        write.nextLine();
    }

    public void displayExitApp() {
        System.out.println("""
                
                
                
                
                
                      |- AgathaBank -|
                
                
                
                          SAINDO...
                """);
        DisplayPause();
    }

    public void displayChooseError() {
        System.out.println("""
                
                
                
                
                
                      |- AgathaBank -|
                
                
                     Escolha Incorreta
                
                """);
        DisplayPause();
    }

    public void errorLogin(){
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                            ERRO!
                            
                      Dados INCORRETOS!
                
                
                
                """);
        DisplayPause();
    }
}
