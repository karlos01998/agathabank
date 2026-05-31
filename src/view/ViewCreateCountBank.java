package view;

import dto.DTOCreateCurrentBank;
import dto.DTOCreateSavingsBank;

import java.util.Scanner;

public class ViewCreateCountBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    //Telas para Conta Current//

    public long displayCheckCPFCreateCountCurrentBank() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                        Digite o CPF:
                
                
                
                
                """);
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public DTOCreateCurrentBank displayCreateCountCurrent(long idCPF) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                           Nome:
                        
                
                
                
                
                """);
        String name = write.nextLine();

        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                     Ano de Nascimento:
                        
                
                
                
                
                """);
        int year = write.nextInt();

        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                     Mês de Nascimento:
                        
                
                
                
                
                """);
        int month = write.nextInt();


        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                     Dia de Nascimento:
                        
                
                
                
                
                """);
        int day = write.nextInt();

        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                      Digite a SENHA:
                        [6 NUMEROS]
                
                
                
                
                """);
        int password = write.nextInt();

        return new DTOCreateCurrentBank(idCPF, name, year, month, day, password);
    }

    // Telas para conta poupança

    public long displayCheckCPFCreateCountSavingsBank() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupança
                
                
                        Digite o CPF:
                
                
                
                
                """);
        long idCPF = write.nextLong();
        write.nextLine();
        return idCPF;
    }

    public DTOCreateSavingsBank displayCreateCountSavings(long idCPF) {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupança
                
                
                           Nome:
                        
                
                
                
                
                """);
        String name = write.nextLine();

        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupança
                
                
                     Ano de Nascimento:
                        
                
                
                
                
                """);
        int year = write.nextInt();

        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupança
                
                
                     Mês de Nascimento:
                        
                
                
                
                
                """);
        int month = write.nextInt();


        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupança
                
                
                     Dia de Nascimento:
                        
                
                
                
                
                """);
        int day = write.nextInt();

        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupança
                
                
                      Digite a SENHA:
                        [6 NUMEROS]
                
                
                
                
                """);
        int password = write.nextInt();

        return new DTOCreateSavingsBank(idCPF, name, year, month, day, password);
    }

    public void errorSizeCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                
                    Erro no comprimento
                           do CPF
                        
                
                
                
                """);
        viewFunctionBank.displayPause();
    }

    public void errorCheckCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                
                            CPF
                        Ja Existe!
                
                
                
                """);
        viewFunctionBank.displayPause();
    }

    public void errorPassword() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                
                    Erro no comprimento
                         da Senha
                        
                
                
                
                """);
        viewFunctionBank.displayPause();
    }

    public void errorAge() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                
                           Erro! 
                       Faixa de IDADE
                        
                
                
                
                """);
        viewFunctionBank.displayPause();
    }
}