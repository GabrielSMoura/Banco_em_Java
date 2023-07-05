package com.mycompany.midas;

import utilitarios.Utils;

public class Conta {
    private static int contadorDeContas = 1;
    
    private int numeroConta;
    private Pessoas titular;
    private Double saldo = 0.0;
    private String tipoConta;

    public Conta(Pessoas titular) {
        this.numeroConta = contadorDeContas;
        this.titular = titular;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoas getTitular() {
        return titular;
    }

    public void setTitular(Pessoas titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Não foi possível realizar o depósito.");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public void transferir(Conta contaDestino, Double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Não foi possível realizar a transferência.");
        }
    }

    public void excluirConta() {
        // Realize qualquer ação necessária para excluir a conta aqui
        // Por exemplo, você pode remover a conta de uma lista de contas existente
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nNúmero da Conta:  ").append(this.getNumeroConta());
        builder.append("\nNome:             ").append(this.titular.getNome());
        builder.append("\nCPF:              ").append(this.titular.getCpf());
        builder.append("\nEmail:            ").append(this.titular.getEmail());
        builder.append("\nSaldo:            ").append(Utils.doubleToString(this.getSaldo()));

        if (tipoConta != null) {
            builder.append("\nTipo de Conta:    ").append(tipoConta);
        }

        return builder.toString();
    }
}


