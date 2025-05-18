package tp1;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    protected String matricula;
    protected String Curso;
    Aluno(String cpf, String nome, LocalDate nascimento, String email, String endereco, String matricula, String Curso){
        super(cpf, nome, nascimento,email,endereco);
        this.matricula=matricula;
        this.Curso=Curso;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;    
    }
    @Override
    public String obterInformacoes(){
        return super.obterInformacoes() +"------------\nInformacoes do Aluno:"+"\nMatricula:"+matricula+"\nCurso: "+Curso+"------------";
    }
}

