package view;

import model.ModelCurrentBank;
import model.ModelSavingsBank;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ViewCountCurrentPIX {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    // Utilitário de formatação bancária estável (100,000.00)
    private String formatToBankStandard(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        return decimalFormat.format(value);
    }

    public Long displayCountCurrentPIX(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ USUÁRIO: """ + modelCurrentBank.getNameUser() + " ]\n" + """
                 
                   Insira a Chave PIX [CPF]:
                =====================================
                """);
        System.out.print(" CPF > ");
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public double displayCountCurrentPIXValue(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ USUÁRIO: """ + modelCurrentBank.getNameUser() + " ]\n" + """
                 
                   Insira o valor da transferência:
                =====================================
                """);
        System.out.print(" Valor R$ > ");
        double value = write.nextDouble();
        write.nextLine();
        return value;
    }

    public int displayCountCurrentPIXCurrentFind(ModelCurrentBank modelCurrentBank, ModelCurrentBank modelCurrentBankReceiver) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ CONFIRMAÇÃO DE DADOS DO DESTINO ]
                """);
        System.out.println("  --> Conta Destino: " + modelCurrentBankReceiver.getNameUser());
        System.out.println("  --> Instituição:   AGATHA-BANK");
        System.out.println("  --> Tipo de Conta: Conta Corrente");
        System.out.println("""
                =====================================
                 Selecione uma opção e tecle Enter:
                 
                    [1] Prosseguir com o Pix
                    [2] Voltar ao Menu Principal
                =====================================
                """);
        System.out.print(" Opção > ");
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }

    public int displayCountCurrentPIXSavingsFind(ModelCurrentBank modelCurrentBank, ModelSavingsBank modelSavingsBankReceiver) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ CONFIRMAÇÃO DE DADOS DO DESTINO ]
                """);
        System.out.println("  --> Conta Destino: " + modelSavingsBankReceiver.getNameUser());
        System.out.println("  --> Instituição:   AGATHA-BANK");
        System.out.println("  --> Tipo de Conta: Conta Poupança");
        System.out.println("""
                =====================================
                 Selecione uma opção e tecle Enter:
                 
                    [1] Prosseguir com o Pix
                    [2] Voltar ao Menu Principal
                =====================================
                """);
        System.out.print(" Opção > ");
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }

    public int displayCountCurrentPIXPassword(ModelCurrentBank modelCurrentBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ USUÁRIO: """ + modelCurrentBank.getNameUser() + " ]\n" + """
                 
                   Insira a Senha [6 Dígitos]:
                =====================================
                """);
        System.out.print(" Senha > ");
        int password = write.nextInt();
        write.nextLine();
        return password;
    }

    public void displayCountCurrentPIXCurrent(ModelCurrentBank modelCurrentBank, ModelCurrentBank modelCurrentBankReceiver, double valuePIX) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- COMPROVANTE -|
                =====================================
                
                 [ TRANSAÇÃO REALIZADA COM SUCESSO ]
                """);
        System.out.println("  --> Valor Enviado:   R$" + formatToBankStandard(valuePIX));
        System.out.println("  --> Tipo de Envio:   PIX");
        System.out.println("\n [ DADOS DO DESTINATÁRIO ]");
        System.out.println("  --> Nome:            " + modelCurrentBankReceiver.getNameUser());
        System.out.println("  --> Instituição:     AGATHA-BANK");
        System.out.println("  --> Tipo de Conta:   Conta Corrente");
        System.out.println("\n [ DADOS DO REMETENTE ]");
        System.out.println("  --> Nome:            " + modelCurrentBank.getNameUser());
        System.out.println("  --> Instituição:     AGATHA-BANK");
        System.out.println("""
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void displayCountCurrentPIXSavings(ModelCurrentBank modelCurrentBank, ModelSavingsBank modelSavingsBankReceiver, double valuePIX) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- COMPROVANTE -|
                =====================================
                
                 [ TRANSAÇÃO REALIZADA COM SUCESSO ]
                """);
        System.out.println("  --> Valor Enviado:   R$" + formatToBankStandard(valuePIX));
        System.out.println("  --> Tipo de Envio:   PIX");
        System.out.println("\n [ DADOS DO DESTINATÁRIO ]");
        System.out.println("  --> Nome:            " + modelSavingsBankReceiver.getNameUser());
        System.out.println("  --> Instituição:     AGATHA-BANK");
        System.out.println("  --> Tipo de Conta:   Conta Poupança");
        System.out.println("\n [ DADOS DO REMETENTE ]");
        System.out.println("  --> Nome:            " + modelCurrentBank.getNameUser());
        System.out.println("  --> Instituição:     AGATHA-BANK");
        System.out.println("""
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void displayCurrentPIXFoundError() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-    ALERTA   -|
                =====================================
                
                 [ ERRO ]: Chave PIX não Encontrada!
                           Verifique os dados.
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void displayCurrentPIXBalanceError() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-    ALERTA   -|
                =====================================
                
                 [ ERRO ]: Saldo Insuficiente!
                           Operação cancelada.
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void displayCurrentPIXPasswordError() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-    ALERTA   -|
                =====================================
                
                 [ ERRO ]: Senha Incorreta!
                           Acesso negado.
                =====================================
                """);
        viewFunctionBank.displayPause();
    }
}