package org.teiacoltec.poo.tp2.classes;


import java.io.Serializable;
import java.util.Date;

public abstract class Pessoa implements Serializable {
    private final String CPF;
    private final String nome;
    private final Date nascimento;
    private final String email;
    private final String endereco;
    public String getNome;

    public Pessoa(String CPF, String nome, Date nascimento, String email, String endereco) {
        this.CPF = CPF;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String obterInformacoes() {
        String informacoes = "";
        informacoes += "Nome: " + nome + "\n";
        informacoes += "CPF: " + CPF + "\n";
        informacoes += "Data de Nascimento: " + nascimento + "\n";
        informacoes += "E-mail: " + email + "\n";
        informacoes += "Endereço " + endereco + "\n";
        return informacoes;
    }
}




