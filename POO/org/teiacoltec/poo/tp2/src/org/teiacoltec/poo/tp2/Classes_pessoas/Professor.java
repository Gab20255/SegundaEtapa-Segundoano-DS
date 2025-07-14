package org.teiacoltec.poo.tp2.Classes_pessoas;

import java.util.Date;

public class Professor extends Pessoa {
    protected String Matricula;
    protected String formacao;

    public Professor(String Cpf,String nome, String email, String endereco, Date nascimento, String Matricula, String formacao){
        super(Cpf, nome, email, endereco, nascimento);
        this.Matricula=Matricula;
        this.formacao=formacao;
    }
    public String getMatricula() {
        return this.Matricula;
    }

    public void setMatricula(String nova_informacao) {
        this.Matricula=nova_informacao;
    }

    public String getformacao() {
        return this.formacao;
    }

    public void setformacao(String nova_informacao) {
        this.formacao=nova_informacao;
    }
}
