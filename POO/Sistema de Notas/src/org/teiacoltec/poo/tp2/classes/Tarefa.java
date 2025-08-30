package org.teiacoltec.poo.tp2.classes;

import java.io.Serializable;
import java.util.ArrayList;
import org.teiacoltec.poo.tp2.excecoes.AtividadeNaoPertenceATurmaException;
import org.teiacoltec.poo.tp2.excecoes.TarefaNaoExisteException;
import org.teiacoltec.poo.tp2.excecoes.TurmaNaoExisteException;

public class Tarefa implements Serializable {

    int id;
    Aluno aluno;
    Turma turma;
    Atividade atividade;
    float nota;

    private static final transient  ArrayList<Tarefa> tarefas = new ArrayList<>();

    public Tarefa(int id, Aluno aluno, Turma turma, Atividade atividade, float nota) {
        this.id = id;
        this.aluno = aluno;
        this.atividade = atividade;
        this.nota = nota;
        this.turma = turma;
    }

    public static void setTarefas(ArrayList<Tarefa> lista) {
        tarefas.clear();
        tarefas.addAll(lista);
    }

    public static void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public int getId() {
        return this.id;
    }

    public Aluno getPessoa() {
        return this.aluno;
    }

    public Atividade getAtividade() {
        return this.atividade;
    }

    public float getNota() {
        return this.nota;
    }

    public static Tarefa obtemTarefaporID(int id) throws TarefaNaoExisteException {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }
        throw new TarefaNaoExisteException("Erro: A tarefa não existe");
    }

    public static ArrayList<Tarefa> obtemTarefasDaPessoa(Pessoa pessoa) {
        ArrayList<Tarefa> resultados = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getPessoa().getNome().equals(pessoa.getNome())) {
                resultados.add(t);
            }
        }
        return resultados;
    }

    public static String imprimirInformacoesTarefa(Tarefa tarefa) {
        String info = "";
        info += "=== INFORMAÇÕES DA TAREFA ===\n";
        info += "ID da Tarefa: " + tarefa.getId() + "\n";
        info += "Nota: " + tarefa.getNota() + "\n";
        info += "\n--- Atividade ---\n";
        info += tarefa.getAtividade().imprimirInformacoes() + "\n";
        info += "\n--- Pessoa ---\n";
        info += tarefa.getPessoa().obterInformacoes() + "\n";
        info += "\n--- Turma ---\n";
        info += tarefa.getTurma().imprimirInformacoes(tarefa.getTurma()) + "\n";
        return info;
    }

    public static Tarefa criarTarefa(int id, Aluno aluno, Turma turma, Atividade atividade, float nota) throws AtividadeNaoPertenceATurmaException, TurmaNaoExisteException {
        if (!turma.getAtividades().contains(atividade)) {
            throw new AtividadeNaoPertenceATurmaException("A atividade não pertence à Turma.");
        }
        for (Tarefa t : tarefas) {
            if (t.getPessoa().equals(aluno) && t.getAtividade().equals(atividade)) {
                throw new TurmaNaoExisteException("Erro: Tarefa duplicada para esse aluno e atividade.");
            }
        }

        Tarefa tarefa_nova = new Tarefa(id, aluno, turma, atividade, nota);
        tarefas.add(tarefa_nova);
        return tarefa_nova;
    }

    public static void atualizarTarefa(int id, Aluno novoAluno, Atividade novaAtividade, float novaNota) throws TarefaNaoExisteException {
        Tarefa tarefaParaAtualizar = obtemTarefaporID(id);
        tarefaParaAtualizar.aluno = novoAluno;
        tarefaParaAtualizar.atividade = novaAtividade;
        tarefaParaAtualizar.nota = novaNota;
    }

    public static void deletarTarefa(int id) throws TarefaNaoExisteException {
        Tarefa tarefaParaRemover = obtemTarefaporID(id);
        tarefas.remove(tarefaParaRemover);
    }

    public static int geraProximoId() {
        int maior = 0;
        for (Tarefa t : tarefas) {
            if (t.getId() > maior) {
                maior = t.getId();
            }
        }
        return maior + 1;
    }
}
