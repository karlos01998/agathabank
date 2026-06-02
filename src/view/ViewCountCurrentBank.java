package view;

import dto.DTOTransaction;
import model.ModelCurrentBank;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.List;
import java.util.Scanner;

public class ViewCountCurrentBank {
    Scanner write = new Scanner(System.in);
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    private List<DTOTransaction> extract;

    private String formatToBankStandard(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        return decimalFormat.format(value);
    }

    public int displayCountCurrent(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                =====================================
                 Olá, """ + modelCurrentBank.getNameUser() + """
                
                
                  [1] Saldo 
                  [2] Extrato 
                  [3] Fazer Pix 
                  [4] Perfil 
                  [5] Cartão
                  [6] Empréstimo
                  
                  [7] SAIR
                =====================================
                """);
        System.out.print(" Opção > ");
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }

    public void displayCountCurrentBalance(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-   SALDO    -|
                =====================================
                """);
        System.out.println("   Cliente: " + modelCurrentBank.getNameUser());
        System.out.println("   Saldo:   R$" + formatToBankStandard(modelCurrentBank.getBalance()));
        System.out.println("""
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void displayCountCurrentExtract(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
            =====================================
                      |- AgathaBank -|
                      |-  EXTRATO   -|
            =====================================
            
             [ HISTÓRICO DE TRANSAÇÕES ]
            """);

        List<DTOTransaction> listaTransacoes = modelCurrentBank.getExtract();

        if (listaTransacoes == null || listaTransacoes.isEmpty()) {
            System.out.println("   Nenhuma transação localizada.");
        } else {
            for (DTOTransaction t : listaTransacoes) {
                // Agora o .value() vai puxar o double perfeitamente do record!
                System.out.printf("  --> De: %s | Para: %s | R$ %.2f%n",
                        t.name(), t.nameReceiver(), t.value());
            }
        }

        System.out.println("""
            =====================================
            """);
        viewFunctionBank.displayPause();
    }
}