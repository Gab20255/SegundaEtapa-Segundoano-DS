package org.teiacoltec.poo.tp2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.teiacoltec.poo.tp2.classes.Aluno;
import org.teiacoltec.poo.tp2.classes.Atividade;
import org.teiacoltec.poo.tp2.classes.Monitor;
import org.teiacoltec.poo.tp2.classes.Pessoa;
import org.teiacoltec.poo.tp2.classes.Professor;
import org.teiacoltec.poo.tp2.classes.Tarefa;
import org.teiacoltec.poo.tp2.classes.Turma;
import org.teiacoltec.poo.tp2.excecoes.AtividadeJaAssociadaATurmaException;
import org.teiacoltec.poo.tp2.excecoes.AtividadeNaoPertenceATurmaException;
import org.teiacoltec.poo.tp2.excecoes.PessoaNaoEncontradaException;
import org.teiacoltec.poo.tp2.excecoes.TarefaNaoExisteException;
import org.teiacoltec.poo.tp2.excecoes.TurmaJaExisteException;
import org.teiacoltec.poo.tp2.excecoes.TurmaNaoExisteException;

public class TesteSistemadeNotas {

    public static void testa_professor() {
        System.out.println("====================================");
        System.out.println("         TESTE DA CLASSE PROFESSOR      ");
        System.out.println("====================================");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date nascimento, nascimento2;

        try {
            nascimento = sdf.parse("01/01/1980");
            nascimento2 = sdf.parse("01/01/1981");
        } catch (java.text.ParseException e) {
            System.err.println("Erro ao converter data.");
            return;
        }

        try {
            Professor.criarProfessor("48982093842", "Leandro Maia", nascimento, "leandromaia@gmail.com", "Rua dos Professores", "140942841", "Ciências da Computação");
            Professor.criarProfessor("48982093843", "Kelly", nascimento2, "kelly@gmail.com", "Rua dos Professores", "140942842", "Matemática");
            Professor.listarProfessores();

            Professor.atualizarProfessor("48982093842", "Leandro Maia Silva", nascimento, "leandromaia@gmail.com", "Rua dos Professores", "140942841", "Ciências da Computação");
            Professor.removerProfessorPorCPF("48982093843");
            System.out.println("\n=== LISTA DE PROFESSORES APÓS ATUALIZAÇÃO E REMOÇÃO ===");
            Professor.listarProfessores();

            System.out.println("\n=== BUSCA DE PROFESSOR POR CPF ===");
            Professor Leandro = Professor.obtemProfessorPorCPF("48982093842");
            System.out.println(Leandro.obterInformacoes());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void testaTurma() throws Exception {
        System.out.println("=========== TESTES DA CLASSE TURMA ===========");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date inicio = sdf.parse("01/03/2025");
        Date fim = sdf.parse("30/11/2025");

        Professor villani = new Professor("11111111111", "Villani", sdf.parse("01/01/1980"), "villani@ufmg.br", "Rua 1", "P001", "Engenharia");
        Professor kelly = new Professor("22222222222", "Kelly", sdf.parse("01/01/1981"), "kelly@ufmg.br", "Rua 2", "P002", "Computação");
        Aluno rafael = new Aluno("33333333333", "Rafael Valdivio", sdf.parse("01/01/2006"), "rafael@gmail.com", "Rua 3", "A001", "TDS");
        Aluno duda = new Aluno("44444444444", "Duda", sdf.parse("01/01/2007"), "duda@gmail.com", "Rua 4", "A002", "TDS");

        ArrayList<Pessoa> participantes = new ArrayList<>();
        participantes.add(villani);
        participantes.add(rafael);

        Turma turma = Turma.criarTurma(1, "Turma A", "Turma Teste", inicio, fim, participantes);

        System.out.println("\n--- Informações da turma ---");
        System.out.println(turma.imprimirInformacoes(turma));

        Turma.adicionaSeNaoEstiver(turma, kelly);
        Turma.adicionaSeNaoEstiver(turma, duda);

        System.out.println("\nDuda participa? " + turma.participa("Duda"));

        System.out.println("\n--- Lista de Alunos ---");
        for (Aluno a : turma.obtemListaAlunos()) {
            System.out.println(a.getNome());
        }

        System.out.println("\n--- Lista de Professores ---");
        for (Professor p : turma.obtemListaProfessores()) {
            System.out.println(p.getNome());
        }

        ArrayList<Pessoa> subturmaParticipantes = new ArrayList<>();
        subturmaParticipantes.add(duda);

        Turma subturma = new Turma(turma, 2, "Turma Sub", "Subturma de teste", inicio, fim, subturmaParticipantes);
        turma.associaSubturma(subturma);

        System.out.println("\n--- Subturmas associadas ---");
        for (Turma t : turma.getTurmasFilhas()) {
            System.out.println("Subturma: " + t.getNome());
        }

        Turma turmaBuscada = Turma.obtemTurmaPorID(1);
        System.out.println("\nTurma buscada por ID: " + turmaBuscada.getNome());

        ArrayList<Turma> turmasDoRafael = turma.obtemTurmasDaPessoa(rafael);
        System.out.println("\nTurmas do Rafael:");
        for (Turma t : turmasDoRafael) {
            System.out.println(t.getNome());
        }

        Turma.atualizarTurma(1, "Turma A+", "Atualizada", sdf.parse("01/02/2025"), sdf.parse("01/12/2025"));
        System.out.println("\n--- Após atualização ---");
        System.out.println(turma.imprimirInformacoes(turma));

        try {
            Turma.deletarTurma(1);
        } catch (TurmaNaoExisteException e) {
            System.out.println("Erro ao deletar turma: " + e.getMessage());
        }

        System.out.println("\nTurma 1 deletada com sucesso.");

        Atividade a1 = new Atividade(101, "Atividade 1", "Desc A1", sdf.parse("05/07/2024"), sdf.parse("15/07/2024"));
        Atividade a2 = new Atividade(102, "Atividade 2", "Desc A2", sdf.parse("10/07/2024"), sdf.parse("25/07/2024"));
        a1.setCompleta(true);
        a2.setCompleta(false);

        Atividade.adicionarAtividade(a1);
        Atividade.adicionarAtividade(a2);

        turma.associaAtividade(a1);
        turma.associaAtividade(a2);

        System.out.println(" Atividades da turma (completa=true):");
        Date inicioFiltro = new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2024");
        Date fimFiltro = new SimpleDateFormat("dd/MM/yyyy").parse("31/07/2024");
        for (Atividade a : turma.obtemAtividadesDaTurma(true, inicioFiltro, fimFiltro)) {
            System.out.println("- " + a.imprimirInformacoes());
        }

        System.out.println(" Atividades completas da turma (usando método 'completa=true' fixo):");
        for (Atividade a : turma.obtemAtividadesDaTurmaCompleta(true, inicioFiltro, fimFiltro)) {
            System.out.println("- " + a.imprimirInformacoes());
        }

        System.out.println("\n=========== FIM DOS TESTES DE TURMA ===========");
    }

    public static void testaAtividades() {
        System.out.println("====================================");
        System.out.println("         TESTE DA CLASSE ATIVIDADE  ");
        System.out.println("====================================");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date inicio1, fim1, inicio2, fim2;

        try {
            inicio1 = sdf.parse("10/08/2025");
            fim1 = sdf.parse("17/08/2025");

            inicio2 = sdf.parse("12/08/2025");
            fim2 = sdf.parse("19/08/2025");
        } catch (ParseException e) {
            System.out.println("Erro ao converter datas: " + e.getMessage());
            return;
        }

        Atividade.criarAtividade(1, "Prova POO", "Prova sobre conceitos de POO", inicio1, fim1);
        Atividade.criarAtividade(2, "Trabalho Final", "Projeto prático com todas as classes", inicio2, fim2);

        System.out.println("\n=== LISTA DE ATIVIDADES ===");
        for (Atividade a : Atividade.getListaAtividades()) {
            System.out.println(a.imprimirInformacoes());
        }

        Atividade.atualizarAtividade(1, "Prova POO - Atualizada", "Inclui exceções e herança", inicio1, fim1);

        System.out.println("\n=== LISTA APÓS ATUALIZAÇÃO ===");
        for (Atividade a : Atividade.getListaAtividades()) {
            System.out.println(a.imprimirInformacoes());
        }

        Atividade.removerAtividadePorId(2);

        System.out.println("\n=== LISTA APÓS REMOÇÃO ===");
        for (Atividade a : Atividade.getListaAtividades()) {
            System.out.println(a.imprimirInformacoes());
        }
    }

    public static void testaMonitores() {
        System.out.println("====================================");
        System.out.println("        TESTE DA CLASSE MONITOR     ");
        System.out.println("====================================");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date nascimento1, nascimento2;

        try {
            nascimento1 = sdf.parse("01/02/2005");
            nascimento2 = sdf.parse("03/05/2006");
        } catch (java.text.ParseException e) {
            System.err.println("Erro ao converter data.");
            return;
        }

        try {
            Monitor.criarMonitor("001", "Lucas Alves", nascimento1, "lucas@ufmg.br", "Rua A", "M001", "Matemática");
            Monitor.criarMonitor("002", "Duda", nascimento2, "duda@ufmg.br", "Rua B", "M002", "Física");

            System.out.println("\n--- Monitores Cadastrados ---");
            Monitor.listarMonitores();

            Monitor.atualizarMonitor("002", "Maria Eduarda", nascimento2, "duda@ufmg.br", "Rua B", "M002", "Física");

            System.out.println("\n--- Após Atualização ---");
            Monitor.listarMonitores();

            Monitor.removerMonitorPorCPF("001");

            System.out.println("\n--- Após Remoção ---");
            Monitor.listarMonitores();

            System.out.println("\n--- Busca por CPF ---");
            Monitor buscado = Monitor.obtemMonitorPorCPF("002");
            if (buscado != null) {
                System.out.println("Monitor encontrado:");
                System.out.println(buscado.obterInformacoes());
            } else {
                System.out.println("Monitor não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void testaTarefa() {
        System.out.println("====================================");
        System.out.println("         TESTE DA CLASSE TAREFA     ");
        System.out.println("====================================");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date nascimento, inicio, fim;

        try {
            nascimento = sdf.parse("15/03/2005");
            inicio = sdf.parse("01/07/2025");
            fim = sdf.parse("15/07/2025");
        } catch (java.text.ParseException e) {
            System.err.println("Erro ao converter datas.");
            return;
        }

        try {
            Aluno aluno = new Aluno("123", "Rafael Valdivio", nascimento, "rafael@gmail.com", "Rua A", "a2024952040", "TI");

            Atividade atividade = new Atividade(1, "Trabalho de Java", "TP2 com DAO", inicio, fim);

            ArrayList<Pessoa> participantes = new ArrayList<>();
            participantes.add(aluno);
            Turma turma = Turma.criarTurma(100, "Turma POO", "Turma da disciplina de POO", inicio, fim, participantes);
            turma.associaAtividade(atividade);

            Tarefa tarefaCriada = Tarefa.criarTarefa(1, aluno, turma, atividade, 9.5f);

            System.out.println("\n--- Tarefa Criada ---");
            System.out.println(Tarefa.imprimirInformacoesTarefa(tarefaCriada));

            Atividade novaAtividade = new Atividade(2, "Prova de POO", "Avaliação final", inicio, fim);
            turma.associaAtividade(novaAtividade);

            Tarefa.atualizarTarefa(1, aluno, novaAtividade, 8.0f);

            System.out.println("\n--- Tarefa Atualizada ---");
            Tarefa tAtualizada = Tarefa.obtemTarefaporID(1);
            System.out.println(Tarefa.imprimirInformacoesTarefa(tAtualizada));

            Tarefa.deletarTarefa(1);
            System.out.println("\nTarefa removida com sucesso.");

            System.out.println("\n--- Lista de Tarefas após remoção ---");
            for (Tarefa t : Tarefa.getTarefas()) {
                System.out.println(Tarefa.imprimirInformacoesTarefa(t));
            }

        } catch (AtividadeJaAssociadaATurmaException | AtividadeNaoPertenceATurmaException | TarefaNaoExisteException | TurmaJaExisteException | TurmaNaoExisteException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static void testaAlunos() throws PessoaNaoEncontradaException {
        System.out.println("====================================");
        System.out.println("         TESTE DA CLASSE ALUNO      ");
        System.out.println("====================================");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date nascimento, nascimento2;

        try {
            nascimento = sdf.parse("01/01/2005");
            nascimento2 = sdf.parse("01/01/2007");
        } catch (java.text.ParseException e) {
            System.err.println("Erro ao converter data.");
            return;
        }

        try {
            Aluno.criarAluno("123456789", "Rafael Valdivio", nascimento, "rafaelvaldivio@gmail.com", "Rua Programadores Cafezeiros", "a2024952040", "Desenvolvimento de Sistemas");
            Aluno.criarAluno("13291831", "Gabriel Oliveira", nascimento2, "gabrieloliveira@gmail.com", "Rua dos Programadores", "a2024952041", "Desenvolvimento de Sistemas");

            System.out.println("\n=== LISTA DE ALUNOS CADASTRADOS ===");
            Aluno.listarAlunos();

            Aluno.atualizarAluno("123456789", "Rafael Valdivio Siqueira Santos", nascimento, "rafaelvaldivio@gmail.com", "Rua Programadores Cafezeiros", "a2024952040", "Desenvolvimento de Sistemas");
            Aluno.removerAlunoPorCPF("13291831");

            System.out.println("\n=== LISTA DE ALUNOS APÓS ATUALIZAÇÃO E REMOÇÃO ===");
            Aluno.listarAlunos();

            System.out.println("\n=== BUSCA DE ALUNO POR CPF ===");
            Aluno rafa = Aluno.obtemAlunoPorCPF("123456789");
            System.out.println(rafa.obterInformacoes());

            Main.imprimirInformacoes(rafa);
            Tarefa.obtemTarefasDaPessoa(rafa);

        } catch (PessoaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
