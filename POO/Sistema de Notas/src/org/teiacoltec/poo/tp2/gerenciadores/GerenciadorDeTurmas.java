package org.teiacoltec.poo.tp2.gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.teiacoltec.poo.tp2.Persistencia;
import org.teiacoltec.poo.tp2.classes.Aluno;
import org.teiacoltec.poo.tp2.classes.Atividade;
import org.teiacoltec.poo.tp2.classes.Pessoa;
import org.teiacoltec.poo.tp2.classes.Turma;
import static org.teiacoltec.poo.tp2.classes.Turma.adicionaParticipante;
import static org.teiacoltec.poo.tp2.classes.Turma.criarTurma;
import org.teiacoltec.poo.tp2.excecoes.AtividadeJaAssociadaATurmaException;
import org.teiacoltec.poo.tp2.excecoes.AtividadeNaoAssociadaATurmaException;
import org.teiacoltec.poo.tp2.excecoes.PessoaJaParticipanteException;
import org.teiacoltec.poo.tp2.excecoes.TurmaJaExisteException;
import org.teiacoltec.poo.tp2.excecoes.TurmaNaoExisteException;

public class GerenciadorDeTurmas {

    public static void GerenciarTurmas(Scanner scanner)
            throws TurmaJaExisteException, TurmaNaoExisteException, PessoaJaParticipanteException, AtividadeNaoAssociadaATurmaException, AtividadeJaAssociadaATurmaException {
        boolean executando = true;

        while (executando) {
            System.out.println("\n===== Gerenciar Turmas =====");
            System.out.println("1. Cadastrar Turma");
            System.out.println("2. Atualizar Turma");
            System.out.println("3. Remover Turma");
            System.out.println("4. Listar Turmas");
            System.out.println("5. Buscar Turma por ID");
            System.out.println("6. Adicionar participante à Turma");
            System.out.println("7. Desassociar atividade de Turma");
            System.out.println("8. Listar atividades da Turma");
            System.out.println("9. Listar todas as atividades das Turmas");
            System.out.println("10. Associar atividade à Turma");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrando turma...");
                    System.out.print("Digite o ID da turma: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome da turma: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a descrição da turma: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a data de início (dd/MM/yyyy): ");
                    String dataInicio = scanner.nextLine();
                    System.out.print("Digite a data de fim (dd/MM/yyyy): ");
                    String dataFim = scanner.nextLine();

                    try {
                        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
                        Date fim = new SimpleDateFormat("dd/MM/yyyy").parse(dataFim);
                        criarTurma(id, nome, descricao, inicio, fim);
                        System.out.println("Turma cadastrada com sucesso!");

                        Persistencia.salvar(Turma.getTurmas(), "turmas.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao cadastrar turma: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("Atualizando turma...");
                    System.out.print("Digite o ID da turma: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a nova descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a nova data de início (dd/MM/yyyy): ");
                    String dataInicio = scanner.nextLine();
                    System.out.print("Digite a nova data de fim (dd/MM/yyyy): ");
                    String dataFim = scanner.nextLine();

                    try {
                        Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
                        Date fim = new SimpleDateFormat("dd/MM/yyyy").parse(dataFim);
                        Turma.atualizarTurma(id, nome, descricao, inicio, fim);
                        System.out.println("Turma atualizada com sucesso!");
                        Persistencia.salvar(Turma.getTurmas(), "turmas.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException | TurmaNaoExisteException e) {
                        System.out.println("Erro ao atualizar turma: " + e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.print("Digite o ID da turma a ser removida: ");
                    int id = scanner.nextInt();
                    try {
                        Turma.deletarTurma(id);
                        System.out.println("Turma removida com sucesso!");
                        Persistencia.salvar(Turma.getTurmas(), "turmas.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (TurmaNaoExisteException e) {
                        System.out.println("Erro ao remover turma: " + e.getMessage());
                    }
                }

                case 4 -> Turma.ListarTurmas();

                case 5 -> {
                    System.out.print("Digite o ID da turma: ");
                    int id = scanner.nextInt();
                    Turma turma = Turma.obtemTurmaPorID(id);
                    if (turma != null) {
                        System.out.println(turma.imprimirInformacoes(turma));
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                }

                case 6 -> {
                    System.out.print("Digite o CPF do participante: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o nome do participante: ");
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
                        Pessoa novo_participante = new Aluno(cpf, nome, nascimento, email, endereco, matricula, curso);
                        adicionaParticipante(novo_participante);
                        System.out.println("Participante adicionado com sucesso!");
                        Persistencia.salvar(Turma.getTurmas(), "turmas.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (ParseException e) {
                        System.out.println("Erro ao converter data: " + e.getMessage());
                    }
                }

                case 7 -> {
                    System.out.print("Digite o ID da turma: ");
                    int idTurma = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o ID da atividade: ");
                    int idAtividade = scanner.nextInt();
                    scanner.nextLine();

                    Turma turma = Turma.obtemTurmaPorID(idTurma);
                    Atividade atividade = Atividade.obterAtividadePorId(idAtividade);
                    if (turma != null) {
                        turma.desassociaAtividade(atividade);
                        System.out.println("Atividade desassociada com sucesso!");
                        Persistencia.salvar(Turma.getTurmas(), "turmas.dat");
                        System.out.println("Dados salvos com sucesso.");
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                }

                case 8 -> {
                    System.out.print("Digite o ID da turma: ");
                    int idTurma = scanner.nextInt();
                    scanner.nextLine();
                    Turma turma = Turma.obtemTurmaPorID(idTurma);
                    if (turma != null) {
                        System.out.println("Atividades da turma:");
                        for (Atividade a : turma.obtemAtividadesDaTurma(true)) {
                            System.out.println(a.imprimirInformacoes());
                        }
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                }

                case 9 -> {
                    System.out.println("Atividades de todas as turmas:");
                    for (Atividade a : Turma.obtemAtividadesDaTurmaCompleta(true)) {
                        System.out.println(a.imprimirInformacoes());
                    }
                }

                case 10 -> {
                    System.out.print("Digite o ID da turma: ");
                    int idTurma = scanner.nextInt();
                    scanner.nextLine();
                    Turma turma = Turma.obtemTurmaPorID(idTurma);
                    if (turma != null) {
                        System.out.print("Digite o ID da atividade: ");
                        int idAtividade = scanner.nextInt();
                        scanner.nextLine();
                        Atividade atividade = Atividade.obterAtividadePorId(idAtividade);
                        if (atividade != null) {
                            turma.associaAtividade(atividade);
                            System.out.println("Atividade associada à turma com sucesso!");
                            Persistencia.salvar(Turma.getTurmas(), "turmas.dat");
                            System.out.println("Dados salvos com sucesso.");
                        } else {
                            System.out.println("Atividade não encontrada.");
                        }
                    } else {
                        System.out.println("Turma não encontrada.");
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
