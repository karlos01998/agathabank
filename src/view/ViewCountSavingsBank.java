package view;

import model.ModelCurrentBank;
import model.ModelSavingsBank;

import java.util.Scanner;

public class ViewCountSavingsBank {
    Scanner write = new Scanner(System.in);
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    public int displayCountSavings(ModelSavingsBank modelSavingsBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("      |- AgathaBank -|");
        System.out.println("   Ola, " + modelSavingsBank.getNameUser());
        System.out.println("""
                
                
                      [1] Saldo 
                      [2] Extrato 
                      [3] Fazer Pix 
                      [4] Perfil 
                      
                      
                      [7]    SAIR
                """);

        return write.nextInt();
    }

    public void displayCountSavingsBalance(ModelSavingsBank modelSavingsBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("      |- AgathaBank -|");
        System.out.println("""
                
                
                """);
        System.out.println("""
                
                
                """);
        System.out.println("   " + modelSavingsBank.getNameUser());
        System.out.printf("   Saldo: R$%.2f%n", modelSavingsBank.getBalance());
        System.out.println("""
                
                      
                
                """);

        viewFunctionBank.displayPause();
    }
}