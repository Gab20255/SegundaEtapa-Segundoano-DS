
package org.teiacoltec.poo.tp2.gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.teiacoltec.poo.tp2.Persistencia;
import org.teiacoltec.poo.tp2.classes.*;
public class GerenciadorDeProfessores {
    public static void GerenciarProfessores(Scanner scanner) {
        boolean executando = true;
        while (executando) {
            System.out.println("Gerenciando Professores...");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Atualizar Professor");
            System.out.println("3. Remover Professor");
            System.out.println("4. Listar Professores");
            System.out.println("5. Buscar Professor por CPF");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrando professor...");
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
                    System.out.print("Digite o departamento: ");
                    String departamento = scanner.nextLine();
                    try {
                        Date nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                        Professor.criarProfessor(cpf, nome, nascimento, email, endereco, matricula, departamento);
                        System.out.println("Professor cadastrado com sucesso!");
                        Persistencia.salvar(Professor.getListaProfessores(), "professores.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao cadastrar professor: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Atualizar Professor...");
                    System.out.print("Digite o CPF do professor a ser atualizado: ");
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
                    System.out.print("Digite o novo departamento: ");
                    String departamento = scanner.nextLine();

                    try {
                        Date nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                        Professor.atualizarProfessor(cpf, nome, nascimento, email, endereco, matricula, departamento);
                        System.out.println("Professor atualizado com sucesso!");
                        Persistencia.salvar(Professor.getListaProfessores(), "professores.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Removendo Professor...");
                    System.out.print("Digite o CPF do professor a ser removido: ");
                    String cpf = scanner.nextLine();
                    try {
                        Professor.removerProfessorPorCPF(cpf);
                        System.out.println("Professor removido com sucesso!");
                        Persistencia.salvar(Professor.getListaProfessores(), "professores.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao remover professor: " + e.getMessage());
                    }
                }
                case 4 -> Professor.listarProfessores();
                case 5 -> {
                    System.out.print("Digite o CPF do professor: ");
                    String cpf = scanner.nextLine();
                    try {
                        Professor professor = Professor.obtemProfessorPorCPF(cpf);
                        System.out.println(professor.obterInformacoes());
                    } catch (Exception e) {
                        System.out.println("Professor não encontrado: " + e.getMessage());
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
