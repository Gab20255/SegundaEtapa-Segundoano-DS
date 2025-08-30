package org.teiacoltec.poo.tp2.classes;

import java.util.ArrayList;
import java.util.Date;
import org.teiacoltec.poo.tp2.excecoes.PessoaNaoEncontradaException;

public class Aluno extends Pessoa  {
    private final String matricula;
    private final String curso;
    private static transient ArrayList<Aluno> alunos = new ArrayList<>();

    public Aluno(String CPF, String nome, Date nascimento, String email, String endereco, String matricula, String curso) {
        super(CPF, nome, nascimento, email, endereco);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getCurso() {
        return this.curso;
    }

    @Override
    public String obterInformacoes() {
        String info = super.obterInformacoes();
        info += "Matrícula: " + this.matricula + "\n";
        info += "Curso: " + this.curso + "\n";
        return info;
    }

    public static Aluno obtemAlunoPorCPF(String cpf) throws PessoaNaoEncontradaException {
        for (Aluno aluno : alunos) {
            if (aluno.getCPF().equals(cpf)) {
                return aluno;
            }
        }
        throw new PessoaNaoEncontradaException("Aluno não encontrado com o CPF: " + cpf);
    }

    public static void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public static void criarAluno(String CPF, String nome, Date nascimento, String email, String endereco, String matricula, String curso) {
        Aluno novoAluno = new Aluno(CPF, nome, nascimento, email, endereco, matricula, curso);
        adicionarAluno(novoAluno);
    }

    public static void atualizarAluno(String CPF, String nome, Date nascimento, String email, String endereco, String matricula, String curso) throws PessoaNaoEncontradaException {
        Aluno alunoExistente = obtemAlunoPorCPF(CPF);
        alunos.remove(alunoExistente);
        Aluno alunoAtualizado = new Aluno(CPF, nome, nascimento, email, endereco, matricula, curso);
        alunos.add(alunoAtualizado);
    }

    public static ArrayList<Aluno> getListaAlunos() {
        return alunos;
    }

    public static void removerAlunoPorCPF(String cpf) throws PessoaNaoEncontradaException {
        Aluno aluno = obtemAlunoPorCPF(cpf);
        alunos.remove(aluno);
    }

    public static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.obterInformacoes());
            }
        }
    }

    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public static void setAlunos(ArrayList<Aluno> lista) {
        alunos = lista;
    }
    
}
