package tp1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Turma turma = new Turma(1, "Matemática", "Turma de Matemática", LocalDate.now(), LocalDate.now().plusMonths(4), null);

        Pessoa aluno = new Aluno("12345678900", "João", LocalDate.of(2005, 5, 20), "joao@email.com", "Rua A", "M123", "Matemática");

        // Tentar adicionar participante
        try {
            turma.adcionarParticipante(aluno);
            System.out.println("Participante adicionado com sucesso.");
        } catch (PessoaJaParticipanteException e) {
            System.out.println("Erro ao adicionar participante: " + e.getMessage());
        }

        // Tentar adicionar novamente para causar exceção
        try {
            turma.adcionarParticipante(aluno);
        } catch (PessoaJaParticipanteException e) {
            System.out.println("Erro ao adicionar participante: " + e.getMessage());
        }

        // Tentar remover participante
        try {
            turma.removerParticipante(aluno);
            System.out.println("Participante removido com sucesso.");
        } catch (PessoaNaoEncontradaException e) {
            System.out.println("Erro ao remover participante: " + e.getMessage());
        }

        // Tentar remover novamente para causar exceção
        try {
            turma.removerParticipante(aluno);
        } catch (PessoaNaoEncontradaException e) {
            System.out.println("Erro ao remover participante: " + e.getMessage());
        }
    }
    public static void imprimirInformacoes(Pessoa p){
        System.out.println(p.obterInformacoes());
    }
    public static void imprimirInformacoes(Atividade a){
        System.out.println("------------\nInformacoes da Atividade:"+"\nID::"+a.getID()+"\nNome: "+a.getNome()+"\nDescrição: "+a.getDescricao()+"\nInício: "+ a.getInicio()+"\nFim: "+a.getFim()+"------------");
    }
    public static void imprimirInformacoes(Turma turma) {
        System.out.println("ID: " + turma.ID);
        System.out.println("Nome: " + turma.nome);
        System.out.println("Descrição: " + turma.descricao);
        System.out.println("Início: " + turma.inicio);
        System.out.println("Fim: " + turma.fim);
        
        System.out.println("Turma Pai: " + (turma.turma_pai != null ? turma.turma_pai.nome : "Nenhuma"));
        
        System.out.println("Participantes:");
        if (turma.participantes != null && turma.participantes.length > 0) {
            for (Pessoa p : turma.participantes) {
                System.out.println(" - " + p.getNome() + " (" + p.getCpf() + ")");
            }
        } else {
            System.out.println("Nenhum participante.");
        }
        
        System.out.println("Turmas Filhas:");
        if (turma.turmas_filhas != null && turma.turmas_filhas.length > 0) {
            for (Turma sub : turma.turmas_filhas) {
                System.out.println(" - " + sub.nome);
            }
        } else {
            System.out.println("Nenhuma turma filha.");
        }
    }
}
