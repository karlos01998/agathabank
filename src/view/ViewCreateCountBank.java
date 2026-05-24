package view;

import dto.DTOCreateCurrentBank;
import dto.DTOCreateSavingsBank;

import java.util.Scanner;

public class ViewCreateCountBank {
    ViewFunctionBank viewFunctionBank = new ViewFunctionBank();
    Scanner write = new Scanner(System.in);

    public int displayCreateCountMenuCountApp() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                
                
                
                    Qual o tipo de Conta:
                
                      Conta Corrente [1]
                      Conta Poupança [2]
                          SAIR [3]
                """);
        return write.nextInt();
    }

    //Telas para Conta Current//

    public DTOCreateCurrentBank displayCreateCountCurrent() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Corrente
                
                
                        Digite o CPF:
                
                
                
                
                """);
        long cpf = write.nextLong();
        write.nextLine();

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

        return new DTOCreateCurrentBank(cpf, name, year, month, day, password);
    }

    public DTOCreateSavingsBank displayCreateCountSavings() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       Conta Poupança
                
                
                        Digite o CPF:
                
                
                
                
                """);
        long cpf = write.nextLong();
        write.nextLine();

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


        return new DTOCreateSavingsBank(cpf, name, year, month, day, password);
    }

    public void errorCPF() {
        viewFunctionBank.clearDisplay();
        System.out.println("""
                
                      |- AgathaBank -|
                       
                
                
                    Erro no comprimento
                           do CPF
                        
                
                
                
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
