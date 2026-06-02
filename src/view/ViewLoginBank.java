package view;

import model.ModelCurrentBank;
import model.ModelSavingsBank;
import java.util.Scanner;

public class ViewLoginBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public int displayLoginMenuCountApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-   ACESSO    -|
                =====================================
                 Selecione a modalidade da conta:
                
                    [1] Conta Corrente
                    [2] Conta Poupança
                    
                    [3] Voltar
                =====================================
                """);
        System.out.print(" Opção > ");
        int choose = write.nextInt();
        write.nextLine();
        return choose;
    }

    public long displayLoginCountCurrentCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- LOGIN CC    -|
                =====================================
                   Insira o CPF do titular:
                =====================================
                """);
        System.out.print(" CPF > ");
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public int displayLoginCountCurrentPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- LOGIN CC    -|
                =====================================
                   Insira a senha de acesso:
                =====================================
                """);
        System.out.print(" Senha > ");
        int password = write.nextInt();
        write.nextLine();
        return password;
    }

    public long displayLoginCountSavingsCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- LOGIN CP    -|
                =====================================
                   Insira o CPF do titular:
                =====================================
                """);
        System.out.print(" CPF > ");
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public int displayLoginCountSavingsPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- LOGIN CP    -|
                =====================================
                   Insira a senha de acesso:
                =====================================
                """);
        System.out.print(" Senha > ");
        int password = write.nextInt();
        write.nextLine();
        return password;
    }

    public void countDataTest(ModelCurrentBank conta) {
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                           Dados de Teste
                =====================================
                """);
        System.out.println(conta);
    }

    public void countDataTest(ModelSavingsBank conta) {
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                           Dados de Teste
                =====================================
                """);
        System.out.println(conta);
    }
}