
package org.teiacoltec.poo.tp2.classes;

import java.util.ArrayList;
import java.util.Date;

public class Professor extends Pessoa {
    private final String matricula;
    private final String departamento;

    private static final transient ArrayList<Professor> professores = new ArrayList<>();

    public static ArrayList<Professor> getListaProfessores() {
        return professores;
    }
    public static void setListaProfessores(ArrayList<Professor> lista) {
        professores.clear();
        professores.addAll(lista);
    }

    public Professor(String cpf, String nome, Date dataNascimento, String email, String endereco, String matricula, String departamento) {
        super(cpf, nome, dataNascimento, email, endereco);
        this.matricula = matricula;
        this.departamento = departamento;
    }

    public static void criarProfessor(String cpf, String nome, Date dataNascimento, String email, String endereco, String matricula, String departamento) {
        professores.add(new Professor(cpf, nome, dataNascimento, email, endereco, matricula, departamento));
    }

    public static void atualizarProfessor(String cpf, String nome, Date dataNascimento, String email, String endereco, String matricula, String departamento) throws Exception {
        Professor p = obtemProfessorPorCPF(cpf);
        professores.remove(p);
        professores.add(new Professor(cpf, nome, dataNascimento, email, endereco, matricula, departamento));
    }

    public static void removerProfessorPorCPF(String cpf) throws Exception {
        Professor p = obtemProfessorPorCPF(cpf);
        professores.remove(p);
    }

    public static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor p : professores) {
                System.out.println(p.obterInformacoes());
            }
        }
    }

    public static Professor obtemProfessorPorCPF(String cpf) throws Exception {
        for (Professor professor : professores) {
            if (professor.getCPF().equals(cpf)) {
                return professor;
            }
        }
        throw new Exception("Professor não encontrado com o CPF: " + cpf);
    }

    @Override
    public String obterInformacoes() {
        return "Professor: " + getNome() + " - Matrícula: " + matricula + " - Departamento: " + departamento;
    }
}
