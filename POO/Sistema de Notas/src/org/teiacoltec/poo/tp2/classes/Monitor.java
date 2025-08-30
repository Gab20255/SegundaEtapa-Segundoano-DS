package org.teiacoltec.poo.tp2.classes;

import java.util.ArrayList;
import java.util.Date;

public class Monitor extends Pessoa {
    private final String matricula;
    private final String curso;
    private static transient final ArrayList<Monitor> monitores = new ArrayList<>();

    public Monitor(String CPF, String nome, Date nascimento, String email, String endereco, String matricula, String curso) {
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

    public static void criarMonitor(String CPF, String nome, Date nascimento, String email, String endereco, String matricula, String curso) {
        Monitor novo = new Monitor(CPF, nome, nascimento, email, endereco, matricula, curso);
        monitores.add(novo);
    }

    public static Monitor obtemMonitorPorCPF(String cpf) {
        for (Monitor m : monitores) {
            if (m.getCPF().equals(cpf)) {
                return m;
            }
        }
        return null;
    }

    public static void atualizarMonitor(String CPF, String nome, Date nascimento, String email, String endereco, String matricula, String curso) {
        Monitor existente = obtemMonitorPorCPF(CPF);
        if (existente != null) {
            monitores.remove(existente);
            Monitor atualizado = new Monitor(CPF, nome, nascimento, email, endereco, matricula, curso);
            monitores.add(atualizado);
        }
    }

    public static void removerMonitorPorCPF(String cpf) {
        Monitor m = obtemMonitorPorCPF(cpf);
        if (m != null) {
            monitores.remove(m);
        }
    }

    public static ArrayList<Monitor> getListaMonitores() {
        return monitores;
    }

    public static void setMonitores(ArrayList<Monitor> lista) {
        monitores.clear();
        monitores.addAll(lista);
    }

    public static void listarMonitores() {
        if (monitores.isEmpty()) {
            System.out.println("Nenhum monitor cadastrado.");
        } else {
            for (Monitor m : monitores) {
                System.out.println(m.obterInformacoes());
            }
        }
    }

    @Override
    public String obterInformacoes() {
        String info = super.obterInformacoes();
        info += "Matrícula: " + this.matricula + "\n";
        info += "Curso: " + this.curso + "\n";
        return info;
    }
}
