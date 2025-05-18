package tp1;

import java.time.LocalDate;

public abstract class Pessoa {
    protected String cpf = null;
    protected String nome = null;
    protected LocalDate nascimento = null;
    protected String email = null;
    protected String endereco = null;
    protected String Informacoes = null;

    Pessoa(String cpf, String nome, LocalDate nascimento, String email, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String obterInformacoes() {
        Informacoes = "------------\nInformações:\ncpf: " + cpf + "\nnome: " + nome + "\ndata de nascimento: " + nascimento+ "\nemail: " + email + "\nendereco:" + endereco + "------------";
        return Informacoes;
    }
}

