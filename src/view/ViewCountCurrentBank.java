package view;

import model.ModelCurrentBank;

import java.util.Scanner;

public class ViewCountCurrentBank {
    Scanner write = new Scanner(System.in);
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public int displayCountCurrent(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("      |- AgathaBank -|");
        System.out.println("   Ola, " + modelCurrentBank.getNameUser());
        System.out.println("""
                
                      [1] Saldo 
                      [2] Extrato 
                      [3] Fazer Pix 
                      [4] Perfil 
                      [5] Cartao
                      [6] Emprestimo
                      
                      [7]    SAIR
                """);

        return write.nextInt();
    }
    public void displayCountCurrentBalance(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("      |- AgathaBank -|");
        System.out.println("""
                
                
                """);
        System.out.println("""
                
                
                """);
        System.out.println("   " + modelCurrentBank.getNameUser());
        System.out.printf("   Saldo: R$%.2f%n", modelCurrentBank.getBalance());
        System.out.println("""
                
                      
                
                """);

        viewFunctionBank.displayPause();
    }
}