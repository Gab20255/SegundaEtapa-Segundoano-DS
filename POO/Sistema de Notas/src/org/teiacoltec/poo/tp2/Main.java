/*
COLÉGIO TÉCNICO DA UFMG – TÉCNICO EM DESENVOLVIMENTO DE SISTEMAS – 2º ANO
TRABALHO PRÁTICO DE PROGRAMAÇÃO ORIENTADA A OBJETOS – SISTEMA DE NOTAS (TP2)

Aluno: Rafael Valdivio Siqueira Santos  
Turma: 203-B  
Professor: Leandro Maia Silva

*/




package org.teiacoltec.poo.tp2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import org.teiacoltec.poo.tp2.classes.*;
import org.teiacoltec.poo.tp2.excecoes.*;

public class Main {

    public static void main(String[] args) throws PessoaNaoEncontradaException, TurmaJaExisteException, TurmaNaoExisteException, PessoaJaParticipanteException, AtividadeNaoAssociadaATurmaException, AtividadeJaAssociadaATurmaException {
        Locale.setDefault(Locale.of("pt", "BR"));
        carregarDados();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║     SISTEMA DE NOTAS - BEM-VINDO!          ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║  1.  Executar Testes                       ║");
            System.out.println("║  2.  Acessar Sistema (CRUD)                ║");
            System.out.println("║  0.  Sair                                  ║");
            System.out.println("╚════════════════════════════════════════════╝");

            int opcao = -1;

            while (true) {
                System.out.print("Escolha uma opção: ");
                try {
                    opcao = Integer.parseInt(scanner.nextLine());

                    if (opcao == 0 || opcao == 1 || opcao == 2) {
                        break;
                    } else {
                        System.out.println("Opção inválida. Digite 0, 1 ou 2.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                }
            }

            switch (opcao) {
                case 1 ->
                    ExibirMenuGeral.menuTestes(scanner);
                case 2 ->
                    ExibirMenuGeral.menuSistema(scanner);
                case 0 -> {
                    salvarDados();
                    System.out.println("Encerrando...");
                    executando = false;
                }
                default ->
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

    }

    @SuppressWarnings("unchecked")
    public static void carregarDados() {
        Object dados;

        dados = Persistencia.carregar("alunos.dat");
        if (dados != null) {
            Aluno.setAlunos((ArrayList<Aluno>) dados);
        }

        dados = Persistencia.carregar("monitores.dat");
        if (dados != null) {
            Monitor.setMonitores((ArrayList<Monitor>) dados);
        }

        dados = Persistencia.carregar("professores.dat");
        if (dados != null) {
            Professor.setListaProfessores((ArrayList<Professor>) dados);
        }
        dados = Persistencia.carregar("turmas.dat");
        if (dados != null) {
            Turma.setTurmas((ArrayList<Turma>) dados);
        }
        dados = Persistencia.carregar("atividades.dat");
        if (dados != null) {
            Atividade.setAtividades((ArrayList<Atividade>) dados);
        }

        dados = Persistencia.carregar("tarefas.dat");
        if (dados != null) {
            Tarefa.setTarefas((ArrayList<Tarefa>) dados);
        }
    }

    public static void salvarDados() {
        Persistencia.salvar(Aluno.getAlunos(), "alunos.dat");
        Persistencia.salvar(Atividade.getListaAtividades(), "atividades.dat");
        Persistencia.salvar(Monitor.getListaMonitores(), "monitores.dat");
        Persistencia.salvar(Professor.getListaProfessores(), "professores.dat");
        Persistencia.salvar(Turma.getTurmas(), "turmas.dat");
        Persistencia.salvar(Tarefa.getTarefas(), "tarefas.dat");
        System.out.println("Dados salvos com sucesso.");
    }

    public static void imprimirInformacoes(Pessoa pessoa) {
        System.out.println("=== Pessoa ===");
        System.out.println(pessoa.obterInformacoes());
    }

    public static void imprimirInformacoes(Turma turma) {
        System.out.println("=== Turma ===");
        System.out.println(turma.imprimirInformacoes(turma));
    }

    public static void imprimirInformacoes(Atividade atividade) {
        System.out.println("=== Atividade ===");
        System.out.println(atividade.imprimirInformacoes());
    }

}
