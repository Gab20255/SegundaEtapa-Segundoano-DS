package tp1;
import java.time.LocalDate;

public class Professor extends Pessoa {
    protected String matricula;
    protected String formacao;
    Professor(String cpf, String nome, LocalDate nascimento, String email, String endereco, String matricula, String formacao){
        super(cpf, nome, nascimento,email,endereco);
        this.matricula=matricula;
        this.formacao=formacao;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    @Override
    public String obterInformacoes(){
        return super.obterInformacoes() +"------------\nInformacoes do Professor:"+"\nMatricula:"+matricula+"\nFormação: "+formacao+"------------";
    }
}

