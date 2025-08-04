package org.teiacoltec.poo.tp2.Classe_Turmas_Atividades_Tarefas;
import java.util.ArrayList;
import java.util.Date;
import org.teiacoltec.poo.tp2.Classes_pessoas.Pessoa;
import org.teiacoltec.poo.tp2.Classes_pessoas.Aluno;

public class Tarefa {
    private static ArrayList<Tarefa> todasAsTarefas = new ArrayList<>();
    private static int ProximoIDT=1;
    protected int ID;
    protected Aluno aluno;
    protected Atividade atividade;
    protected float nota;
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    protected Turma turma;

    public Tarefa( Aluno aluno, Atividade atividade, float nota, Turma t){
        this.ID=ProximoIDT++;
        this.aluno=aluno;
        this.atividade= atividade;
        this.nota=nota;
        this.turma=t;
        todasAsTarefas.add(this);
    }

    public Tarefa obtemTarefaPorID(int id){
        for(Tarefa t:todasAsTarefas){
            if(t.getID()==id){
                return t;
            }
        }
        return null;
    }

    public ArrayList<Tarefa >obtemTarefasDaPessoa(Pessoa p){
        ArrayList <Tarefa> Tarefas=new ArrayList<>();
        for(Tarefa t:todasAsTarefas){
            if(t.getAluno().getCPF()==p.getCPF()){
                Tarefas.add(t);
            }
        }
        return Tarefas;
    }

    public ArrayList<Tarefa >obtemTarefasDaPessoa(Pessoa p, Date inicio, Date fim){
        ArrayList <Tarefa> Tarefas=new ArrayList<>();
        ArrayList <Tarefa> Tarefas_com_data=new ArrayList<>();
        for(Tarefa t:todasAsTarefas){
            if(t.getAluno().getCPF()==p.getCPF()){
                Tarefas.add(t);
            }
        }
        for(Tarefa t:Tarefas){
            if((t.getAtividade().getInicio().before(inicio))&&(t.getAtividade().getInicio().after(fim))){
                Tarefas_com_data.add(t);
            }
        }
        return Tarefas_com_data;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void obterInformacoes(Tarefa a){
        int i=1;
        String Informacoes=null;
        Informacoes= "------------------------\n| Informações da tarefa |\n------------------------\n"+"ID: "+a.getID()+"\n"+"\n"+"Nota: "+a.getNota()+"\n"+"-----------------";
        System.out.println(Informacoes);
        
        for(Turma b: a.getTurma().getTurmas_filhas()){
            System.out.println("Turma 0"+i+"\n");
            b.obterInformacoes(b);
            i++;
        }
        i=1;
        System.out.println("Atividade\n");
        a.getAtividade().obterInformacoes(a.getAtividade());
    }
}
