package com.mycompany.midas;

public class Pessoas {

    private String nome;
    private String cpf;
    private String email;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Pessoas(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.contaCorrente = null; // inicialmente não possui conta corrente
        this.contaPoupanca = null; // inicialmente não possui conta poupança
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    // Métodos getters e setters para os atributos nome, cpf e email

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nNome: ").append(this.getNome());
        builder.append("\nCPF: ").append(this.getCpf());
        builder.append("\nEmail: ").append(this.getEmail());

        if (contaCorrente != null) {
            builder.append("\n\nConta Corrente:");
            builder.append(contaCorrente.toString());
        }

        if (contaPoupanca != null) {
            builder.append("\n\nConta Poupança:");
            builder.append(contaPoupanca.toString());
        }

        return builder.toString();
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
