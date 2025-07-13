package org.teiacoltec.poo.tp2.Classes_pessoas;

import java.sql.Date;

public class Monitor extends Pessoa {
    protected String Matricula;
    protected String Curso;

    public Monitor(String Cpf,String nome, String email, String endereco, Date nascimento, String Matricula, String Curso){
        super(Cpf, nome, email, endereco, nascimento);
        this.Matricula=Matricula;
        this.Curso=Curso;
    }
    public String getMatricula() {
        return this.Matricula;
    }

    public void setMatricula(String nova_informacao) {
        this.Matricula=nova_informacao;
    }

    public String getCurso() {
        return this.Curso;
    }

    public void setCurso(String nova_informacao) {
        this.Curso=nova_informacao;
    }
}
