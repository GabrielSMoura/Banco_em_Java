package com.mycompany.midas;

public class ContaCorrente extends Conta {
    
    private static final double TAXA_CRIACAO = 10.0;

    public ContaCorrente(Pessoas pessoas) {
        super(pessoas);
        setSaldo(-TAXA_CRIACAO); // Deduz a taxa de criação do saldo inicial
    }
    
    public String toString(){
        return super.toString() +
               "\nTipo de Conta:    Conta Corrente";
    }
}
