package tp1;

public class PessoaJaParticipanteException extends Exception {
    public PessoaJaParticipanteException() {
        super("Pessoa já é participante da turma.");
    }

    public PessoaJaParticipanteException(String mensagem) {
        super(mensagem);
    }
}
