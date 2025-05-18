package tp1;

import java.time.LocalDate;

public class Turma {
    protected int ID;
    protected String nome;
    protected String descricao;
    protected LocalDate inicio;
    protected LocalDate fim;
    protected Pessoa[] participantes;
    protected Turma turma_pai;
    protected Turma[] turmas_filhas;

     public Turma(int ID, String nome, String descricao, LocalDate inicio, LocalDate fim, Turma turma_pai) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.turma_pai = turma_pai;
        this.participantes = new Pessoa[0];
        this.turmas_filhas = new Turma[0];
    }

    public Turma(Turma turmaPai) {
        this.turma_pai = turmaPai;
        this.participantes = new Pessoa[0];
        this.turmas_filhas = new Turma[0];
    }

    public Pessoa[] obtemListaParticipantes() {
        return participantes;
    }

    public void adcionarParticipante(Pessoa p) throws PessoaJaParticipanteException{
        if (participa(p)) {
            throw new PessoaJaParticipanteException();
        }
        Pessoa[] novo= new Pessoa[participantes.length+1];
        for(int i=0; i<participantes.length; i++){
            novo[i]=participantes[i];
        }
        novo[participantes.length]=p;
        participantes=novo;
    }
    public void removerParticipante(Pessoa p) throws PessoaNaoEncontradaException{
        int aux=-1;
        for(int i=0; i<participantes.length; i++){
            if(p.equals(participantes[i])){
                aux=i;
                break;
            }
        }
        if (aux==-1) {
            throw new PessoaNaoEncontradaException();
        }
        Pessoa[] novo= new Pessoa[participantes.length-1];
        for(int j=0, i=0; j<novo.length; i++){
            if(i!=aux){
                novo[j]= participantes[i];
                j++;
            }
        }
        participantes=novo;
    }
    public boolean participa(Pessoa p){
    for(int i=0; i<participantes.length; i++){
        if(participantes[i].equals(p)){
                return true;
        }
     }
    return false;
    }
    public void associaSubturma(Turma t) {
    t.turma_pai = this;
    Turma[] novaLista = new Turma[turmas_filhas.length + 1];
    for (int i = 0; i < turmas_filhas.length; i++) {
        novaLista[i] = turmas_filhas[i];
    }
    novaLista[turmas_filhas.length] = t;
    turmas_filhas = novaLista;
    }

}
