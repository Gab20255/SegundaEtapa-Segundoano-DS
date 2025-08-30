
package org.teiacoltec.poo.tp2.gerenciadores;

import java.util.Scanner;
import org.teiacoltec.poo.tp2.Persistencia;
import org.teiacoltec.poo.tp2.classes.*;
import org.teiacoltec.poo.tp2.excecoes.AtividadeNaoPertenceATurmaException;
import org.teiacoltec.poo.tp2.excecoes.PessoaNaoEncontradaException;
import org.teiacoltec.poo.tp2.excecoes.TarefaNaoExisteException;
import org.teiacoltec.poo.tp2.excecoes.TurmaNaoExisteException;

public class GerenciadorDeTarefas {

    public static void GerenciarTarefas(Scanner scanner) {
        // ArrayList<Tarefa> listaTarefas = Tarefa.getTarefas();
        boolean executando = true;

        while (executando) {
            System.out.println("\n===== Gerenciar Tarefas =====");
            System.out.println("1. Cadastrar Tarefa");
            System.out.println("2. Atualizar Tarefa");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Buscar Tarefa por ID");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    try {
                        System.out.print("ID da tarefa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("CPF do aluno: ");
                        String cpf = scanner.nextLine();
                        Aluno aluno = Aluno.obtemAlunoPorCPF(cpf);

                        System.out.print("ID da turma: ");
                        int idTurma = scanner.nextInt();
                        Turma turma = Turma.obtemTurmaPorID(idTurma);

                        System.out.print("ID da atividade: ");
                        int idAtividade = scanner.nextInt();
                        scanner.nextLine();
                        Atividade atividade = Atividade.obterAtividadePorId(idAtividade);
                        for (Atividade a : turma.getAtividades()) {
                            if (a.getId() == idAtividade) {
                                atividade = a;
                                break;
                            }
                        }

                        if (atividade == null) {
                            System.out.println("Atividade não encontrada.");
                            break;
                        }

                        System.out.print("Nota: ");
                        float nota = scanner.nextFloat();

                        Tarefa.criarTarefa(id, aluno, turma, atividade, nota);
                        System.out.println("Tarefa cadastrada com sucesso!");

                        Persistencia.salvar(Tarefa.getTarefas(), "tarefas.dat");
                        System.out.println("Dados salvos com sucesso.");

                    } catch (AtividadeNaoPertenceATurmaException | PessoaNaoEncontradaException | TurmaNaoExisteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 2 -> {
                    try {
                        System.out.print("ID da tarefa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("CPF do novo aluno: ");
                        String cpf = scanner.nextLine();
                        Aluno novoAluno = Aluno.obtemAlunoPorCPF(cpf);

                        System.out.print("ID da nova atividade: ");
                        int idAtividade = scanner.nextInt();
                        scanner.nextLine();

                        Atividade novaAtividade = null;
                        for (Atividade a : Atividade.getListaAtividades()) {
                            if (a.getId() == idAtividade) {
                                novaAtividade = a;
                                break;
                            }
                        }

                        System.out.print("Nova nota: ");
                        float novaNota = scanner.nextFloat();

                        Tarefa.atualizarTarefa(id, novoAluno, novaAtividade, novaNota);
                        System.out.println("Tarefa atualizada com sucesso!");

                        Persistencia.salvar(Tarefa.getTarefas(), "tarefas.dat");
                        System.out.println("Dados salvos com sucesso.");

                    } catch (PessoaNaoEncontradaException | TarefaNaoExisteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 3 -> {
                    try {
                        System.out.print("ID da tarefa: ");
                        int id = scanner.nextInt();
                        Tarefa.deletarTarefa(id);
                        System.out.println("Tarefa removida com sucesso!");
                        Persistencia.salvar(Tarefa.getTarefas(), "tarefas.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (TarefaNaoExisteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 4 -> {
                    for (Tarefa t : Tarefa.getTarefas()) {
                        System.out.println(Tarefa.imprimirInformacoesTarefa(t));
                    }
                }

                case 5 -> {
                    try {
                        System.out.print("ID da tarefa: ");
                        int id = scanner.nextInt();
                        Tarefa tarefa = Tarefa.obtemTarefaporID(id);
                        System.out.println(Tarefa.imprimirInformacoesTarefa(tarefa));
                    } catch (TarefaNaoExisteException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 0 -> executando = false;

                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
