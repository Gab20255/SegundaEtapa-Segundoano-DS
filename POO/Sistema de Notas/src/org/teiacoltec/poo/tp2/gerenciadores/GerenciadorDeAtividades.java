package org.teiacoltec.poo.tp2.gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.teiacoltec.poo.tp2.Persistencia;
import org.teiacoltec.poo.tp2.classes.Atividade;

public class GerenciadorDeAtividades {

    public static void gerenciarAtividades(Scanner scanner) {
        boolean executando = true;
        while (executando) {
            System.out.println("\n===== Gerenciar Atividades =====");
            System.out.println("1. Cadastrar Atividade");
            System.out.println("2. Atualizar Atividade");
            System.out.println("3. Remover Atividade");
            System.out.println("4. Listar Atividades");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrando atividade...");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Data de início (dd/MM/yyyy): ");
                    String dataInicio = scanner.nextLine();
                    System.out.print("Data de entrega (dd/MM/yyyy): ");
                    String dataEntrega = scanner.nextLine();

                    try {
                        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
                        Date fim = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrega);
                        Atividade.criarAtividade(id, nome, descricao, inicio, fim);
                        System.out.println("Atividade cadastrada com sucesso!");
                        Persistencia.salvar(Atividade.getListaAtividades(), "atividades.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao cadastrar atividade: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("Atualizando atividade...");
                    System.out.print("ID da atividade: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Nova data de início (dd/MM/yyyy): ");
                    String dataInicio = scanner.nextLine();
                    System.out.print("Nova data de entrega (dd/MM/yyyy): ");
                    String dataEntrega = scanner.nextLine();

                    try {
                        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
                        Date fim = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrega);
                        Atividade.atualizarAtividade(id, nome, descricao, inicio, fim);
                        System.out.println("Atividade atualizada com sucesso!");
                        Persistencia.salvar(Atividade.getListaAtividades(), "atividades.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao atualizar atividade: " + e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.print("ID da atividade a remover: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Atividade.removerAtividadePorId(id);
                    System.out.println("Atividade removida com sucesso!");
                    Persistencia.salvar(Atividade.getListaAtividades(), "atividades.dat");
                    System.out.println("Dados salvos com sucesso.");
                }
                case 4 -> {
                    System.out.println("\n=== Lista de Atividades ===");
                    for (Atividade a : Atividade.getListaAtividades()) {
                        System.out.println(a.imprimirInformacoes());
                    }
                }

                case 0 -> {
                    System.out.println("Voltando ao menu principal...");
                    executando = false;
                }

                default ->
                    System.out.println("Opção inválida.");
            }
        }
    }
}
