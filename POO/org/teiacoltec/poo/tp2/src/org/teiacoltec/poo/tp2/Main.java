package org.teiacoltec.poo.tp2;
import java.util.Date;
import java.util.Calendar;

import org.teiacoltec.poo.tp2.Classe_Turmas_Atividades_Tarefas.Turma;
import org.teiacoltec.poo.tp2.Classes_pessoas.Aluno;
import org.teiacoltec.poo.tp2.Classes_pessoas.Professor;
import org.teiacoltec.poo.tp2.Classes_pessoas.Monitor;
import org.teiacoltec.poo.tp2.Classes_pessoas.Pessoa;

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
        Professor.obterInformacoes(Professor);
        aluno1.obterInformacoes(aluno1);
        aluno2.obterInformacoes(aluno2);
        Monitor.obterInformacoes(Monitor);
        cal.set(2025, Calendar.FEBRUARY, 10);
        Date inicioTurma = cal.getTime();
        cal.set(2028, Calendar.DECEMBER, 1);
        Date fimTurma = cal.getTime();
        cal.set(2025, Calendar.FEBRUARY, 10);
        Date inicioAtividade = cal.getTime();

        cal.set(2025, Calendar.MARCH, 1);
        Date fimAtividade = cal.getTime();
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
        turma.obterInformacoes(turma);

    }
}