package org.teiacoltec.poo.tp2.Classe_Turmas_Atividades_Tarefas;

import java.util.ArrayList;
import java.util.Date;


public class Atividade {
    private static int proximoID = 1;
    private int ID;
    private String nome;
    private Date inicio;
    private Date fim;
    private float valor;
    private String Descricao;

    public Atividade(String nome, Date inicio, Date fim, float valor, String desc) {
        this.ID = proximoID++;
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
        this.Descricao = desc;
    }
    private static ArrayList<Atividade> atividades =new ArrayList<>();
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
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
    public void obterInformacoes(Atividade a){
        String Informacoes=null;
        Informacoes= "-------------------------\n| Informações completas |\n-------------------------"+"\nID: "+a.getID()+"\n"+"Nome: "+a.getNome()+"\nDescrição: "+a.getDescricao()+"\n"+"Valor: "+a.getValor()+"\n"+"Inicio: "+a.getInicio()+"\n"+"Fim:"+a.getFim()+"\n"+"-------------------------------";
        System.out.println(Informacoes);
    }
}
