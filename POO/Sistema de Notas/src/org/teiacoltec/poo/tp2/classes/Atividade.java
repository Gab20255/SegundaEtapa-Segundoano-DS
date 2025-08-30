package org.teiacoltec.poo.tp2.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Atividade implements Serializable {

    private final int id;
    private final String nome;
    private final String descricao;
    private final Date inicio;
    private final Date fim;
    private boolean completa;
    private Turma turma;
    private static transient final  ArrayList<Atividade> atividades = new ArrayList<>();

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public Atividade(int id, String nome, String descricao, Date inicio, Date fim) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.completa = false;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Date getInicio() {
        return this.inicio;
    }

    public Date getFim() {
        return this.fim;
    }

    public boolean getCompleta() {
        return this.completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public static Atividade obterAtividadePorId(int id) {
        for (Atividade a : atividades) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public static void criarAtividade(int id, String nome, String descricao, Date inicio, Date fim) {
        Atividade nova = new Atividade(id, nome, descricao, inicio, fim);
        atividades.add(nova);
    }

    

    public static void atualizarAtividade(int id, String nome, String descricao, Date inicio, Date fim) {
        Atividade a = obterAtividadePorId(id);
        if (a != null) {
            atividades.remove(a);
            atividades.add(new Atividade(id, nome, descricao, inicio, fim));
        }
    }

    public static void removerAtividadePorId(int id) {
        Atividade a = obterAtividadePorId(id);
        if (a != null) {
            atividades.remove(a);
        }
    }

    public static ArrayList<Atividade> getListaAtividades() {
        return atividades;
    }

    public static ArrayList<Atividade> setAtividades(ArrayList<Atividade> atividades) {
        Atividade.atividades.clear();
        Atividade.atividades.addAll(atividades);
        return Atividade.atividades;
    }

    public static void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public String imprimirInformacoes() {
        return "ID: " + id + "\n"
                + "Nome: " + nome + "\n"
                + "Descrição: " + descricao + "\n"
                + "Início: " + inicio + "\n"
                + "Data de entrega: " + fim + "\n"
                + "Completa: " + (completa ? "Sim" : "Não") + "\n";
    }
}
