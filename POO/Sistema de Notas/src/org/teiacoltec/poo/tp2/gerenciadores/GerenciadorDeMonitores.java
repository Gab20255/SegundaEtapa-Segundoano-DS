
package org.teiacoltec.poo.tp2.gerenciadores;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.teiacoltec.poo.tp2.Persistencia;
import org.teiacoltec.poo.tp2.classes.*;

public class GerenciadorDeMonitores {
    public static void GerenciarMonitores(Scanner scanner) {
        boolean executando = true;
        while (executando) {
            System.out.println("Gerenciando Monitores...");
            System.out.println("1. Cadastrar Monitor");
            System.out.println("2. Atualizar Monitor");
            System.out.println("3. Remover Monitor");
            System.out.println("4. Listar Monitores");
            System.out.println("5. Buscar Monitor por CPF");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrando monitor...");
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
                    System.out.print("Digite a disciplina: ");
                    String disciplina = scanner.nextLine();

                    try {
                        Date nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                        Monitor.criarMonitor(cpf, nome, nascimento, email, endereco, matricula, disciplina);
                        System.out.println("Monitor cadastrado com sucesso!");
                        Persistencia.salvar(Monitor.getListaMonitores(), "monitores.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao cadastrar monitor: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Atualizar Monitor...");
                    System.out.print("Digite o CPF do monitor a ser atualizado: ");
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
                    System.out.print("Digite a nova disciplina: ");
                    String disciplina = scanner.nextLine();

                    try {
                        Date nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
                        Monitor.atualizarMonitor(cpf, nome, nascimento, email, endereco, matricula, disciplina);
                        System.out.println("Monitor atualizado com sucesso!");
                        Persistencia.salvar(Monitor.getListaMonitores(), "monitores.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao atualizar monitor: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Removendo Monitor...");
                    System.out.print("Digite o CPF do monitor a ser removido: ");
                    String cpf = scanner.nextLine();
                    Monitor.removerMonitorPorCPF(cpf);
                    System.out.println("Monitor removido com sucesso!");
                    Persistencia.salvar(Monitor.getListaMonitores(), "monitores.dat");
                    System.out.println("Dados salvos com sucesso.");
                }
                case 4 -> Monitor.listarMonitores();
                case 5 -> {
                    System.out.print("Digite o CPF do monitor: ");
                    String cpf = scanner.nextLine();
                    Monitor monitor = Monitor.obtemMonitorPorCPF(cpf);
                    if (monitor != null) {
                        System.out.println(monitor.obterInformacoes());
                    } else {
                        System.out.println("Monitor não encontrado.");
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
