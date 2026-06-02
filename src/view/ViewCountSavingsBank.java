package view;

import model.ModelSavingsBank;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ViewCountSavingsBank {
    Scanner write = new Scanner(System.in);
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();

    private String formatToBankStandard(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        return decimalFormat.format(value);
    }

    public int displayCountSavings(ModelSavingsBank modelSavingsBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                =====================================
                 Olá, """ + modelSavingsBank.getNameUser() + """
                
                
                  [1] Saldo 
                  [2] Extrato 
                  [3] Fazer Pix 
                  [4] Perfil 
                  
                  [7] SAIR
                =====================================
                """);
        System.out.print(" Opção > ");
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }

    public void displayCountSavingsBalance(ModelSavingsBank modelSavingsBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-   SALDO    -|
                =====================================
                """);
        System.out.println("   Cliente: " + modelSavingsBank.getNameUser());
        System.out.println("   Saldo:   R$" + formatToBankStandard(modelSavingsBank.getBalance()));
        System.out.println("""
                =====================================
                """);
        viewFunctionBank.displayPause();
    }
}