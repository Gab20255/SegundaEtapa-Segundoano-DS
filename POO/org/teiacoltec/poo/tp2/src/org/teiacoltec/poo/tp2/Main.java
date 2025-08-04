package org.teiacoltec.poo.tp2;
import java.util.Date;
import java.util.Calendar;
import org.teiacoltec.poo.tp2.Classe_Turmas_Atividades_Tarefas.Tarefa;
import org.teiacoltec.poo.tp2.Classe_Turmas_Atividades_Tarefas.Turma;
import org.teiacoltec.poo.tp2.Classe_Turmas_Atividades_Tarefas.Atividade;
import org.teiacoltec.poo.tp2.Classes_pessoas.Aluno;
import org.teiacoltec.poo.tp2.Classes_pessoas.Professor;
import org.teiacoltec.poo.tp2.Classes_pessoas.Monitor;

public class Main {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2009, Calendar.MAY, 15);
        Date nascimento = cal.getTime();
        Aluno aluno1= new Aluno("13375617623", "Gabriel Oliveira", "gabruielodb@gmail.com", "Bairro Santa monica",nascimento , "2024", "Desenvolvimento de Sistemas");
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2010, Calendar.JANUARY, 15);
        Date nascimento2 = cal2.getTime();
        Aluno aluno2= new Aluno("15275203667", "Ellen Ferreira", "Ellen@gmail.com", "Bairro California",nascimento2 , "2025", "Automação Industrial");
        Calendar cal3 = Calendar.getInstance();
        cal3.set(1900, Calendar.JULY, 15);
        Date nascimento3 = cal3.getTime();
        Professor Professor= new Professor("000000000001", "Arnaldo Vaz", "Arnaldoodb@gmail.com", "Bairro São Luíz",nascimento3 , "1960", "Física");
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2000, Calendar.JULY, 15);
        Date nascimento4 = cal4.getTime();
        Monitor Monitor= new Monitor("17569856432", "Anakin", "Anakinodb@gmail.com", "Bairro São José",nascimento4 , "2018", "Automação Industrial");
        cal.set(2025, Calendar.FEBRUARY, 10);
        Date inicioTurma = cal.getTime();
        cal.set(2028, Calendar.DECEMBER, 1);
        Date fimTurma = cal.getTime();
        cal.set(2025, Calendar.FEBRUARY, 10);
        Date inicioAtividade = cal.getTime();
        cal.set(2025, Calendar.MARCH, 1);
        Date fimAtividade = cal.getTime();
        cal.set(2025, Calendar.APRIL, 10);
        Date inicioAtividade2 = cal.getTime();
        cal.set(2025, Calendar.MAY, 1);
        Date fimAtividade2 = cal.getTime();
        Turma turma = new Turma("106","NTI", inicioTurma, fimTurma);
        turma.adicionarParticipante(aluno2);
        turma.adicionarParticipante(aluno1);
        turma.adicionarParticipante(Professor);
        turma.adicionarParticipante(Monitor);
        Turma subturma1 = new Turma(turma,"Segundo ano", "Desenvolvimento de Sistemas 4 ano ", inicioTurma, fimTurma);
        turma.associaSubturma(subturma1);
        Turma subturma2 = new Turma(turma,"Primeiro ano", "Automação Industrial 3 ano ", inicioTurma, fimTurma);
        turma.associaSubturma(subturma2);
        subturma2.adicionarParticipante(aluno2);
        subturma1.adicionarParticipante(aluno1);
        Atividade Trabalho_final= new Atividade("Trabalho final de programação", inicioAtividade, fimAtividade, 20.0f, "Construir um programa que simule o Ifood");
        Atividade Banco_de_Dados= new Atividade("Projeto PHP", inicioAtividade2, fimAtividade2, 25.0f, "Criar um banco de Dados de uma Academia");
        Atividade IP= new Atividade("Projeto C", inicioAtividade, fimAtividade, 15.0f, "Criar um mercado livre em C");
        turma.associaAtividade(Trabalho_final);
        subturma1.associaAtividade(Banco_de_Dados);
        subturma2.associaAtividade(IP);
        turma.obterInformacoes(turma);
        Tarefa tarefateste1= new Tarefa( aluno2, IP, 20.0f, turma);
        Tarefa teste2= new Tarefa(aluno2, Trabalho_final, 0, subturma2);
        Tarefa teste3= new Tarefa(aluno1, Banco_de_Dados, 25.0f, subturma1);
        for(Tarefa b : tarefateste1.obtemTarefasDaPessoa(aluno2)){
            if(b.getAluno().getNome()==aluno2.getNome()){
                System.out.println("");
            }
        }
        teste3.obterInformacoes(teste3);
    }
}