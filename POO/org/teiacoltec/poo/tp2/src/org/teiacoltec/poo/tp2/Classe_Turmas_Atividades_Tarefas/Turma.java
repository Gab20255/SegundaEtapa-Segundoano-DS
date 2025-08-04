package org.teiacoltec.poo.tp2.Classe_Turmas_Atividades_Tarefas;

import java.util.ArrayList;
import java.util.Date;
import org.teiacoltec.poo.tp2.Classes_pessoas.Pessoa;
import org.teiacoltec.poo.tp2.Classes_pessoas.Professor;
import org.teiacoltec.poo.tp2.Classes_pessoas.Aluno;
import org.teiacoltec.poo.tp2.Classes_pessoas.Monitor;


public class Turma {

    private static ArrayList<Turma> todasAsTurmas = new ArrayList<>();
    private static int proximoID = 1;
    protected int ID;
    protected String nome;
    protected String descricao;
    protected Date inicio;
    protected Date fim;
    protected ArrayList<Pessoa> participantes=new ArrayList<Pessoa>();
    protected Turma Turma_pai;
    protected ArrayList<Turma> turmas_filhas= new ArrayList<Turma>();
    public ArrayList<Turma> getTurmas_filhas() {
        return turmas_filhas;
    }

    public void setTurmas_filhas(ArrayList<Turma> turmas_filhas) {
        this.turmas_filhas = turmas_filhas;
    }

    protected ArrayList <Atividade> Atividades= new ArrayList<>();

    public Turma( String nome, String descricao, Date ini, Date f){
        this.ID = proximoID++;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = ini; 
        this.fim = f;
        this.participantes = new ArrayList<>();
        this.Atividades = new ArrayList<>();
        this.turmas_filhas = new ArrayList<>();
        this.Turma_pai=null;
        todasAsTurmas.add(this);
    }
    public Turma(Turma turmaPai, String nome, String descricao, Date ini, Date fim) {
    this.ID = proximoID++;
    this.nome = nome;
    this.descricao = descricao;
    this.inicio = ini;
    this.fim = fim;
    this.participantes = new ArrayList<>();
    this.Atividades = new ArrayList<>();
    this.turmas_filhas = new ArrayList<>();
    this.Turma_pai = turmaPai;
    todasAsTurmas.add(this);

    if (turmaPai != null) {
        turmaPai.associaSubturma(this);
    }
}


    public ArrayList<Pessoa> obtemListaParticipantes(){
        return this.participantes;
    }

    public void adicionarParticipante(Pessoa a){
        participantes.add(a);
    }

    public void removerParticipante(Pessoa a){
        participantes.remove(a);
    }

    public boolean participa(Pessoa a){
        for(Pessoa b :participantes){
            if(b.getCPF()== a.getCPF()){
                return true;
            }
        }
        return false;
    }

    public void associaSubturma(Turma subturma){
        if (subturma != null && !turmas_filhas.contains(subturma)) {
        turmas_filhas.add(subturma);
    }
    }

    public ArrayList<Professor> obtemListaProfessores(boolean completa){
        ArrayList<Professor> lista_Professores= new ArrayList<>();
        for (Pessoa p : participantes) {
            if (p instanceof Professor) {
                lista_Professores.add((Professor) p);
            }
        }
        if (completa) {
        for (Turma sub : turmas_filhas) {
            ArrayList<Professor> lista_Professores_sub= new ArrayList<>();
            lista_Professores_sub=sub.obtemListaProfessores(true);
            for (Professor prof : lista_Professores_sub) {
                if (!lista_Professores.contains(prof)) {
                    lista_Professores.add(prof);
                }
            }
        }
    }
        
        return lista_Professores;
    }

    public ArrayList<Aluno> obtemListaAlunos(boolean completa){
        ArrayList<Aluno> lista_Alunos= new ArrayList<>();
        for (Pessoa p : participantes) {
            if (p instanceof Aluno) {
                lista_Alunos.add((Aluno) p);
            }
        }
        if (completa) {
        for (Turma sub : turmas_filhas) {
            ArrayList<Aluno> lista_Alunos_sub= new ArrayList<>();
            lista_Alunos_sub=sub.obtemListaAlunos(true);
            for (Aluno alu : lista_Alunos_sub) {
                if (!lista_Alunos.contains(alu)) {
                    lista_Alunos.add(alu);
                }
            }
        }
    }
        
        return lista_Alunos;
    }

    public ArrayList<Monitor> obtemListaMonitor(boolean completa){
        ArrayList<Monitor> lista_Monitores= new ArrayList<>();
        for (Pessoa p : participantes) {
            if (p instanceof Aluno) {
                lista_Monitores.add((Monitor) p);
            }
        }
        if (completa) {
        for (Turma sub : turmas_filhas) {
            ArrayList<Monitor> lista_Monitores_sub= new ArrayList<>();
            lista_Monitores_sub=sub.obtemListaMonitor(true);
            for (Monitor mon : lista_Monitores_sub) {
                if (!lista_Monitores.contains(mon)) {
                    lista_Monitores.add(mon);
                }
            }
        }
    }
        
        return lista_Monitores;
    }
    public void associaAtividade(Atividade a){
        Atividades.add(a);
    }

    public void desassociaAtividade(Atividade a){
        Atividades.remove(a);
    }
    public ArrayList<Atividade> obtemAtividadesDaTurma(boolean completa){
        if(completa){
            ArrayList<Atividade> lista_atividades_completa= new ArrayList<>();
            //Adiciona a lista completa a lista da Turma Geral
            for(Atividade a:Atividades){
                lista_atividades_completa.add(a);
            }
            for(Turma sub: turmas_filhas){
                ArrayList<Atividade> lista_atividades_completa2= new ArrayList<>();
                lista_atividades_completa2= sub.obtemAtividadesDaTurma(true);
                for(Atividade a:lista_atividades_completa2){
                    if (!lista_atividades_completa.contains(a)) {
                    lista_atividades_completa.add(a);
                }
                }
            }
            return lista_atividades_completa;
        }
        return Atividades;
    }

    public ArrayList<Atividade> obtemAtividadesDaTurma(boolean completa, Date inicio, Date fim){
        ArrayList<Atividade> Atividades_filtradas= new ArrayList<>();
        for(Atividade a:Atividades){
            if((a.getInicio().before(inicio)) && (a.getFim().after(fim))){
                Atividades_filtradas.add(a);
            }
        }

        if(completa){
            ArrayList<Atividade> lista_atividades_filtradas_completa= new ArrayList<>();
            //Adiciona a lista completa a lista da Turma Geral
            for(Atividade a:Atividades_filtradas){
                lista_atividades_filtradas_completa.add(a);
            }
            for(Turma sub: turmas_filhas){
                ArrayList<Atividade> lista_atividades_completa2= new ArrayList<>();
                lista_atividades_completa2= sub.obtemAtividadesDaTurma(true, inicio, fim);
                for(Atividade a:lista_atividades_completa2){
                    if ((!lista_atividades_filtradas_completa.contains(a)) && (a.getInicio().before(inicio)) && (a.getFim().after(fim))) {
                    lista_atividades_filtradas_completa.add(a);
                }
                }
            }
            return lista_atividades_filtradas_completa;
        }

        return Atividades_filtradas;
    }

    public Turma obtemTurmaPorID(int ID){
        for(Turma t: todasAsTurmas) {
            if(t.getID()==ID){
                return t;
            }
        }
        return null;
    }

    public ArrayList<Turma> obtemTurmaPorPessoa(Pessoa p){
        ArrayList<Turma> turmasDaPessoa = new ArrayList<>();

        for (Turma t : todasAsTurmas) {
            if (t.participa(p)) {
                turmasDaPessoa.add(t);
            }
        }

        return turmasDaPessoa;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Turma getTurma_pai() {
        return Turma_pai;
    }

    public void setTurma_pai(Turma turma_pai) {
        Turma_pai = turma_pai;
    }

    public void obterInformacoes(Turma a){
        String Informacoes=null;
        if(a.getTurma_pai()!=null){
            Informacoes= "Turma Filha Requerida\n -------------------------\n| Informações completas |\n-------------------------\n"+"ID: "+a.getID()+"\n"+"Nome: "+a.getNome()+"\n"+"Descrição: "+a.getDescricao()+"\n"+"Inicio:: "+a.getInicio()+"\n"+"Fim: "+a.getFim()+"\n"+"Turma Pai:"+a.getTurma_pai().getNome()+"\n------------------------------------------------\n";
        System.out.println(Informacoes);
        }
        else{
        Informacoes= "Turma Requerida\n -------------------------\n| Informações completas |\n-------------------------\n"+"ID: "+a.getID()+"\n"+"Nome: "+a.getNome()+"\n"+"Descrição: "+a.getDescricao()+"\n"+"Inicio:: "+a.getInicio()+"\n"+"Fim: "+a.getFim()+"\n"+"------------------------------------------------\n";
        System.out.println(Informacoes);
        }
        System.out.println("-----------------\nAtividades\n-----------------\n");
        int i=1;
        for(Atividade b: a.obtemAtividadesDaTurma(true)){
            System.out.println("Atividade "+String.format("%02d", i)+"\n");
            b.obterInformacoes(b);
            i++;
        }
        int al=1;
        int m=1;
        int p=1;
        for(Pessoa b: a.obtemListaParticipantes()){
            if(b instanceof Aluno){
            System.out.println("Aluno "+String.format("%02d", al)+"\n");
            al++;
            }
            if(b instanceof Professor){
            System.out.println("Professor "+String.format("%02d", p)+"\n");
                p++;
            }
            if(b instanceof Monitor){
            System.out.println("Monitor "+String.format("%02d", m)+"\n");
            m++;
            }
            b.obterInformacoes(b);
            
            
        }
        i=1;
        if(a.getTurmas_filhas()!=null){
        for(Turma b: a.getTurmas_filhas()){
            System.out.println("SubTurmas "+String.format("%02d", i)+"\n");
            b.obterInformacoes(b);
            i++;
        }
    }
        i=1;
    }
}
