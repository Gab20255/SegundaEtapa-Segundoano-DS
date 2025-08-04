package org.teiacoltec.poo.tp2.Classes_pessoas;

import java.util.Date;

public abstract class Pessoa{
    protected String CPF;
    protected String nome;
    protected String email;
    protected String endereco;
    protected Date nascimento;

    public Pessoa(String Cpf,String nome, String email, String endereco, Date nascimento){
        this.CPF=Cpf;
        this.nome=nome;
        this.email=email;
        this.endereco=endereco;
        this.nascimento=nascimento;
    }

    public String obterInformacoes(){
        String Informacoes=null;
        Informacoes= "-------------------------\n| Informações gerais |\n-------------------------"+"Cpf: "+getCPF()+"\n"+"Nome: "+getNome()+"\n"+"Email: "+getemail()+"\n"+"Endereco:: "+getendereco()+"\n"+"Data de nascimento: "+getnascimento()+"\n"+"------------------------------------------------";
        return Informacoes;
    }

    public void obterInformacoes(Pessoa a){
        String Informacoes=null;
        Informacoes= "-------------------------\n| Informações completas |\n-------------------------\n"+"Cpf: "+a.getCPF()+"\n"+"Nome: "+a.getNome()+"\n"+"Email: "+a.getemail()+"\n"+"Endereco:: "+a.getendereco()+"\n"+"Data de nascimento: "+a.getnascimento()+"\n"+"------------------------------------------------";
        System.out.println(Informacoes);
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getNome() {
        return this.nome;
    }

    public String getemail() {
        return this.email;
    }

    public String getendereco() {
        return this.endereco;
    }

    public Date getnascimento() {
        return this.nascimento;
    }

    public void setCPF(String novo_CPF) {
        this.CPF=novo_CPF;
    }

    public void setNome(String novo_nome) {
        this.nome=novo_nome;
    }

    public void setemail(String novo_email) {
        this.email=novo_email;
    }

    public void setendereco(String novo_endereco) {
        this.endereco=novo_endereco;
    }

    public void setNascimento(Date novo_nascimento) {
        this.nascimento=novo_nascimento;
    }

}