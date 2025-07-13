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

    public Tarefa(int ID, Aluno aluno, Atividade atividade, float nota){
        this.ID=ProximoIDT++;
        this.aluno=aluno;
        this.atividade= atividade;
        this.nota=nota;
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
}
