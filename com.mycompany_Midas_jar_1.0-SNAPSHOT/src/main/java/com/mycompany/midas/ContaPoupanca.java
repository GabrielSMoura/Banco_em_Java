package com.mycompany.midas;

public class ContaPoupanca extends Conta {
    
    private static final double TAXA_CRIACAO = 5.0;

    public ContaPoupanca(Pessoas pessoas) {
        super(pessoas);
        setSaldo(-TAXA_CRIACAO); // Deduz a taxa de criação do saldo inicial
    }
    
    public String toString(){
        return super.toString() +
               "\nTipo de Conta:    Conta Poupança";
    }
}
