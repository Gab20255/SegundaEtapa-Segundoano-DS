package org.teiacoltec.poo.tp2.gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.teiacoltec.poo.tp2.Persistencia;
import org.teiacoltec.poo.tp2.classes.*;
import org.teiacoltec.poo.tp2.excecoes.*;

public class GerenciadorDeAlunos {
    public static void gerenciarAlunos(Scanner scanner) {
        boolean executando = true;
        while (executando) {
            System.out.println("Gerenciando Alunos...");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Remover Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Buscar Aluno por CPF");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrando aluno...");
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite a matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Digite o curso: ");
                    String curso = scanner.nextLine();
                    try {
                        Date nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                        Aluno.criarAluno(cpf, nome, nascimento, email, endereco, matricula, curso);
                        System.out.println("Aluno cadastrado com sucesso!");
                        Persistencia.salvar(Aluno.getAlunos(), "alunos.dat");
                    } catch (ParseException e) {
                        System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Atualizar Aluno...");
                    System.out.print("Digite o CPF do aluno a ser atualizado: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a nova data de nascimento (dd/MM/yyyy): ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("Digite o novo email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o novo endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite a nova matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Digite o novo curso: ");
                    String curso = scanner.nextLine();
                    try {
                        Date nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                        Aluno.atualizarAluno(cpf, nome, nascimento, email, endereco, matricula, curso);
                        System.out.println("Aluno atualizado com sucesso!");
                        Persistencia.salvar(Aluno.getAlunos(), "alunos.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao atualizar aluno: " + e.getMessage());
                    } catch (PessoaNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Removendo Aluno...");
                    System.out.print("Digite o CPF do aluno a ser removido: ");
                    String cpf = scanner.nextLine();
                    try {
                        Aluno.removerAlunoPorCPF(cpf);
                        System.out.println("Aluno removido com sucesso!");
                        Persistencia.salvar(Aluno.getAlunos(), "alunos.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (PessoaNaoEncontradaException e) {
                        System.out.println("Erro ao remover aluno: " + e.getMessage());
                    }
                }
                case 4 -> Aluno.listarAlunos();
                case 5 -> {
                    System.out.print("Digite o CPF do aluno: ");
                    String cpf = scanner.nextLine();
                    try {
                        Aluno aluno = Aluno.obtemAlunoPorCPF(cpf);
                        System.out.println(aluno.obterInformacoes());
                    } catch (PessoaNaoEncontradaException e) {
                        System.out.println("Aluno não encontrado: " + e.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Voltando ao menu principal...");
                    executando = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
