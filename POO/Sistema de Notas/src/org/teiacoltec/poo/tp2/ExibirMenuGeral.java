
package org.teiacoltec.poo.tp2;

import java.util.Scanner;
import org.teiacoltec.poo.tp2.excecoes.*;
import org.teiacoltec.poo.tp2.gerenciadores.*;

public class ExibirMenuGeral {
    public static void menuTestes(Scanner scanner) throws PessoaNaoEncontradaException {
        boolean executando = true;

        while (executando) {
            System.out.println("\n======= MENU DE TESTES =======");
            System.out.println("1. Testar Aluno");
            System.out.println("2. Testar Professor");
            System.out.println("3. Testar Turma");
            System.out.println("4. Testar Atividade");
            System.out.println("5. Testar Monitor");
            System.out.println("6. Testar Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> TesteSistemadeNotas.testaAlunos();
                case 2 -> TesteSistemadeNotas.testa_professor();
                case 3 -> {
                    try {
                        TesteSistemadeNotas.testaTurma();
                    } catch (Exception e) {
                        System.out.println("Erro ao testar turma: " + e.getMessage());
                    }
                }
                case 4 -> TesteSistemadeNotas.testaAtividades();
                case 5 -> TesteSistemadeNotas.testaMonitores();
                case 6 -> TesteSistemadeNotas.testaTarefa();
                case 0 -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuSistema(Scanner scanner) throws PessoaNaoEncontradaException, TurmaJaExisteException, TurmaNaoExisteException, PessoaJaParticipanteException, AtividadeNaoAssociadaATurmaException, AtividadeJaAssociadaATurmaException {
        boolean executando = true;

        while (executando) {
            System.out.println("===========Menu Sistema (CRUD)===========");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Professores");
            System.out.println("3. Gerenciar Turmas");
            System.out.println("4. Gerenciar Atividades");
            System.out.println("5. Gerenciar Monitores");
            System.out.println("6. Gerenciar Tarefas");
            System.out.println("0. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> GerenciadorDeAlunos.gerenciarAlunos(scanner);
                case 2 -> GerenciadorDeProfessores.GerenciarProfessores(scanner);
                case 3 -> GerenciadorDeTurmas.GerenciarTurmas(scanner);
                case 4 -> GerenciadorDeAtividades.gerenciarAtividades(scanner);
                case 5 -> GerenciadorDeMonitores.GerenciarMonitores(scanner);
                case 6 -> GerenciadorDeTarefas.GerenciarTarefas(scanner);
                case 0 -> {
                    System.out.println("Voltando ao menu principal...");
                    executando = false;
                }
            }
        }
    }
}
