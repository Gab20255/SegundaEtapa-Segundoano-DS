package tp1;

public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException() {
        super("Pessoa não encontrada na turma.");
    }

    public PessoaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
