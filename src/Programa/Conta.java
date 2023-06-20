package Programa;

import Utils.Utils;

public class Conta {

    private static int counterConta = 1;

    private int numeroConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.numeroConta = counterConta;
        this.cliente = cliente;
        counterConta += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getCPF() +
                "\nEmail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor) {
        if(valor>0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Depósito não realizado! Verifique se há algum erro, por favor.");
        }
    }

    public void sacar(Double valor) {
        if(valor>0 && this.getSaldo()>= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Saque não realizado! Verifique se há algum erro, por favor.");
        }
    }

    public void transferir(Conta contaParaTransferir, Double valor) {
        if(valor>0 && this.getSaldo()>=valor) {
            setSaldo(getSaldo() - valor);
            contaParaTransferir.saldo = contaParaTransferir.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        }else {
            System.out.println("Transferência não realizada! Verifique se há algum erro, por favor.");
        }
    }

}
