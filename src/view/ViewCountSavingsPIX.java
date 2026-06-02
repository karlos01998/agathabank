package view;

import model.ModelCurrentBank;
import model.ModelSavingsBank;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ViewCountSavingsPIX {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    private String formatToBankStandard(double value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        return decimalFormat.format(value);
    }

    public Long displayCountSavingsPIX(ModelSavingsBank modelSavingsBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ USUÁRIO: """ + modelSavingsBank.getNameUser() + " ]\n" + """
                 
                   Insira a Chave PIX [CPF]:
                =====================================
                """);
        System.out.print(" CPF > ");
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public double displayCountSavingsPIXValue(ModelSavingsBank modelSavingsBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ USUÁRIO: """ + modelSavingsBank.getNameUser() + " ]\n" + """
                 
                   Insira o valor da transferência:
                =====================================
                """);
        System.out.print(" Valor R$ > ");
        double value = write.nextDouble();
        write.nextLine();
        return value;
    }

    public int displayCountSavingsPIXSavingsFind(ModelSavingsBank modelSavingsBank, ModelSavingsBank modelSavingsBankReceiver) {
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

    public int displayCountSavingsPIXCurrentFind(ModelSavingsBank modelSavingsBank, ModelCurrentBank modelCurrentBankReceiver) {
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

    public int displayCountSavingsPIXPassword(ModelSavingsBank modelSavingsBank) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-     Pix    -|
                =====================================
                
                 [ USUÁRIO: """ + modelSavingsBank.getNameUser() + " ]\n" + """
                 
                   Insira a Senha [6 Dígitos]:
                =====================================
                """);
        System.out.print(" Senha > ");
        int password = write.nextInt();
        write.nextLine();
        return password;
    }

    public void displayCountSavingsPIXSavings(ModelSavingsBank modelSavingsBank, ModelSavingsBank modelSavingsBankReceiver, double valuePIX) {
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
        System.out.println("  --> Nome:            " + modelSavingsBank.getNameUser());
        System.out.println("  --> Instituição:     AGATHA-BANK");
        System.out.println("""
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void displayCountSavingsPIXCurrent(ModelSavingsBank modelSavingsBank, ModelCurrentBank modelCurrentBankReceiver, double valuePIX) {
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
        System.out.println("  --> Nome:            " + modelSavingsBank.getNameUser());
        System.out.println("  --> Instituição:     AGATHA-BANK");
        System.out.println("""
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void displaySavingsPIXFoundError() {
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

    public void displaySavingsPIXBalanceError() {
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

    public void displaySavingsPIXPasswordError() {
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