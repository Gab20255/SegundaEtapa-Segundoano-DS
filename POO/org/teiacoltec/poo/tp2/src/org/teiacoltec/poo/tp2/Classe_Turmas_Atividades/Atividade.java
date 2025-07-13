package org.teiacoltec.poo.tp2.Classe_Turmas_Atividades;

import java.util.ArrayList;
import java.util.Date;

public class Atividade {
    private static int proximoID = 1;
    protected int ID;
    protected String nome;
    protected Date inicio;
    protected Date fim;
    protected float valor;

    private static ArrayList<Atividade> atividades =new ArrayList<>();

    public Atividade(int ID, String nome,Date inicio, Date fim, float valor){
        this.ID=proximoID++;
        this.nome=nome;
        this.inicio=inicio;
        this.fim=fim;
        this.valor=valor;
    }

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getInicio() {
        return inicio;
    }
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    public Date getFim() {
        return fim;
    }
    public void setFim(Date fim) {
        this.fim = fim;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public void AdicionarAtividades(Atividade atividade_adicionada){
        atividades.add(atividade_adicionada);
    }
    public Atividade ObtemAtividadePorID(int ID){
        for(Atividade a: atividades){
            if(a.getID()==ID){
                return a;
            }
        }
        return null;
    }
}
