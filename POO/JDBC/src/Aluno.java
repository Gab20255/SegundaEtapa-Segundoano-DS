public class Aluno{
    private int matricula;
    private String nome;
    private String idade;
    private String curso;
    private String senha;

    Aluno(int matricula, String nome, String idade, String curso, String senha){
        this.matricula=matricula;
        this.nome= nome;
        this.idade= idade;
        this.curso= curso;
        this.senha= senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}