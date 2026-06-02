package view;

import dto.DTOCreateCurrentBank;
import dto.DTOCreateSavingsBank;
import java.util.Scanner;

public class ViewCreateCountBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public long displayCheckCPFCreateCountCurrentBank() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- ABRE CONTA -|
                =====================================
                 [ CATEGORIA: CONTA CORRENTE ]
                 
                   Digite o número do CPF:
                =====================================
                """);
        System.out.print(" CPF > ");
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public DTOCreateCurrentBank displayCreateCountCurrent(long idCPF) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                =====================================
                """);
        System.out.print(" Nome Completo > ");
        String name = write.nextLine();

        System.out.print(" Ano de Nascimento (AAAA) > ");
        int year = write.nextInt();

        System.out.print(" Mês de Nascimento (MM) > ");
        int month = write.nextInt();

        System.out.print(" Dia de Nascimento (DD) > ");
        int day = write.nextInt();

        System.out.print(" Defina a Senha (6 números) > ");
        int password = write.nextInt();
        write.nextLine();

        return new DTOCreateCurrentBank(idCPF, name, year, month, day, password);
    }

    public long displayCheckCPFCreateCountSavingsBank() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |- ABRE CONTA -|
                =====================================
                 [ CATEGORIA: CONTA POUPANÇA ]
                 
                   Digite o número do CPF:
                =====================================
                """);
        System.out.print(" CPF > ");
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public DTOCreateSavingsBank displayCreateCountSavings(long idCPF) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                =====================================
                """);
        System.out.print(" Nome Completo > ");
        String name = write.nextLine();

        System.out.print(" Ano de Nascimento (AAAA) > ");
        int year = write.nextInt();

        System.out.print(" Mês de Nascimento (MM) > ");
        int month = write.nextInt();

        System.out.print(" Dia de Nascimento (DD) > ");
        int day = write.nextInt();

        System.out.print(" Defina a Senha (6 números) > ");
        int password = write.nextInt();
        write.nextLine();

        return new DTOCreateSavingsBank(idCPF, name, year, month, day, password);
    }

    public void errorSizeCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-    ALERTA   -|
                =====================================
                
                 [ ERRO ]: Comprimento inválido!
                           O CPF deve conter 11 dígitos.
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void errorCheckCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-    ALERTA   -|
                =====================================
                
                 [ ERRO ]: Cadastro recusado!
                           Este CPF já possui conta ativa.
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void errorPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-    ALERTA   -|
                =====================================
                
                 [ ERRO ]: Senha fora do padrão!
                           A senha deve ter exatamente 6 dígitos.
                =====================================
                """);
        viewFunctionBank.displayPause();
    }

    public void errorAge() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                =====================================
                          |- AgathaBank -|
                          |-    ALERTA   -|
                =====================================
                
                 [ ERRO ]: Operação não permitida!
                           Idade fora da faixa aceita (18 a 100 anos).
                =====================================
                """);
        viewFunctionBank.displayPause();
    }
}