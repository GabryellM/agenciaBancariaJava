package Programa;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------Bem-vindo ao Banco Java!--------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("************* Selecione uma operação para realizar *************");
        System.out.println("----------------------------------------------------------------");
        System.out.println("|    Opção 1 - Abrir conta    |");
        System.out.println("|    Opção 2 - Depositar      |");
        System.out.println("|    Opção 3 - Sacar          |");
        System.out.println("|    Opção 4 - Transferir     |");
        System.out.println("|    Opção 5 - Listar         |");
        System.out.println("|    Opção 6 - Sair           |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1 -> criarConta();
            case 2 -> depositar();
            case 3 -> sacar();
            case 4 -> transferir();
            case 5 -> listarContas();
            case 6 -> {
                System.out.println("Obrigado por preferir sempre o Banco Java, até mais!");
                System.exit(0);
            }
            default -> {
                System.out.println("Opção inválida!");
                operacoes();
            }
        }

    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF:");
        String CPF = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, CPF, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);

        System.out.println("Conta criada com sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
            System.out.println("Número da conta para depósito: ");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if(conta != null) {
                System.out.println("Qual o valor para ser depositado? ");
                Double valorDeposito = input.nextDouble();
                conta.depositar(valorDeposito);
                System.out.println("Valor depositado com sucesso! ");
            }else {
                System.out.println("Conta não encontrada. ");
            }
            operacoes();
        }

        public static void sacar() {
            System.out.println("Número da conta: ");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if(conta != null) {
                System.out.println("Qual o valor para saque? ");
                Double valorSaque = input.nextDouble();
                conta.sacar(valorSaque);
                System.out.println("Saque realizado com sucesso! ");
            }else {
                System.out.println("Conta não encontrada. ");
            }
            operacoes();
        }

        public static void transferir() {
            System.out.println("Número da conta remetente: ");
            int numeroContaRemetente = input.nextInt();

            Conta contaRemetente = encontrarConta(numeroContaRemetente);

            if(contaRemetente != null) {
                System.out.println("Número da conta destinatário: ");
                int numeroContaDestinatario = input.nextInt();

                Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

                if(contaDestinatario != null) {
                    System.out.println("Valor para ser transferido: ");
                    Double valor = input.nextDouble();

                    contaRemetente.transferir(contaDestinatario, valor);
                }
            }
            operacoes();
        }

        public static void listarContas() {
            if(contasBancarias.size() > 0) {
                for (Conta conta: contasBancarias) {
                    System.out.println(conta);
                }
            }else {
                System.out.println("Não existem contas cadastradas. ");
            }
            operacoes();
        }


}
