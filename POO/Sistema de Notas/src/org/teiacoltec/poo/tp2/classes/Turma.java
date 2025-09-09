package org.teiacoltec.poo.tp2.classes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import org.teiacoltec.poo.tp2.excecoes.*;

public class Turma implements Serializable {
    private final int id;
    private  String nome;
    private String descricao;
    private Date inicio;
    private Date fim;
    private static ArrayList<Pessoa> participantes = new ArrayList<>();
    private Turma turma_pai;
    private final ArrayList<Turma> turmas_filhas;
    private static ArrayList<Atividade> atividades = new ArrayList<>();
    private static transient  ArrayList<Turma> turmas = new ArrayList<>();

    public static void setTurmas(ArrayList<Turma> lista) {
        turmas.clear();
        turmas.addAll(lista);
    }

    public  String getNome() {
        return this.nome;
    }
    public ArrayList<Pessoa> getPessoa(){
        return Turma.participantes;
    }
    public static ArrayList<Turma> getTurmas(){
        return turmas;
    }
    public ArrayList<Turma> getTurmasFilhas(){
        return this.turmas_filhas;
    }

    public ArrayList<Atividade> getAtividades(){
        return Turma.atividades;
    }
    
    public Turma turma_pai(){
        return this.turma_pai;

    }
    public String getDescricao() {
        return this.descricao;
    }

    public Date getInicio(){
        return this.inicio;
    }

    public Date getFim(){
        return this.fim;
    }


    public int get_id(){
        return id;
    }

public Turma(int id, String nome, String descricao, Date inicio, Date fim, ArrayList<Pessoa> participantes) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.inicio = inicio;
    this.fim = fim;
    Turma.participantes = new ArrayList<>(participantes);
    this.turmas_filhas = new ArrayList<>();
    Turma.atividades = new ArrayList<>();
}


    public Turma(Turma turmaPai, int id, String nome, String descricao, Date inicio, Date fim, ArrayList<Pessoa> participantes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.turma_pai = turmaPai;
        this.turmas_filhas = new ArrayList<>();
        Turma.atividades = new ArrayList<>();
        if (participantes != null) {
            Turma.participantes = participantes;
        } else {
            Turma.participantes = new ArrayList<>();
        }
    }

    


    public ArrayList<Pessoa> obtemListaParticipantes()  {
        System.out.println("-----------------------------");
        System.out.println("Listagem de participantes:");
        System.out.println("------------------------------");
        return Turma.participantes;
    }

    public void removeParticipante(Pessoa p) throws PessoaJaParticipanteException, PessoaNaoEncontradaException {
        Pessoa alvo = null; 
        for (Pessoa a : participantes){
            if (p.getNome().compareToIgnoreCase(nome) == 0){
                alvo = a;
                break;
            }
        }
        if (alvo == null){
            throw new PessoaNaoEncontradaException ("Participante da turma não encontrado.");
        }
        participantes.remove(alvo);
    }

    public static void adicionaParticipante(Pessoa pessoa) throws PessoaJaParticipanteException{
        for(Pessoa p : participantes){
            if(( p.getNome()).compareToIgnoreCase(p.getNome()) == 0){
                throw new PessoaJaParticipanteException("A pessoa já existe na lista da turma");
            }
        }
        participantes.add(pessoa);
    }

    public static void adicionaParticipante(Aluno pessoa) throws PessoaJaParticipanteException{
        for(Pessoa p : participantes){
            if(( p.getNome()).compareToIgnoreCase(p.getNome()) == 0){
                throw new PessoaJaParticipanteException("A pessoa já existe na lista da turma");
            }
        }
        participantes.add(pessoa);
    }

    public static void adicionaParticipante(Professor pessoa) throws PessoaJaParticipanteException{
        for(Pessoa p : participantes){
            if(( p.getNome()).compareToIgnoreCase(p.getNome()) == 0){
                throw new PessoaJaParticipanteException("A pessoa já existe na lista da turma");
            }
        }
        participantes.add(pessoa);
    }
    
    public static void adicionaSeNaoEstiver(Turma turma, Pessoa pessoa) {
    for (Pessoa p : turma.obtemListaParticipantes()) {
        if (p.getCPF().equals(pessoa.getCPF())) {
            return; 
        }
    }
    try {
        Turma.adicionaParticipante(pessoa);
    } catch (PessoaJaParticipanteException e) {
        System.out.println("Pessoa já está na turma: " + pessoa.getNome());
    }
}

    public boolean participa(String nome){
        for(Pessoa p: participantes){
            if (p.getNome().compareToIgnoreCase(nome) == 0){
                return true;
            }
        }
        return false;
    }

    public void associaSubturma(Turma subturma) throws SubturmaJaAssociadaException {
        if (turmas_filhas.contains(subturma)){
            throw new SubturmaJaAssociadaException("Erro: A turma já foi associada.");
        }
        turmas_filhas.add(subturma);
        subturma.turma_pai = this;
    }


    public ArrayList<Professor> obtemListaProfessores(){
        ArrayList<Professor> professores = new ArrayList<>();
        for(Pessoa p : participantes){
            if (p instanceof Professor professor ){
                professores.add(professor); 
            }
        }
        return professores;
    }

    public ArrayList<Aluno> obtemListaAlunos(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        for(Pessoa p : participantes){
            if(p instanceof Aluno aluno){
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public ArrayList<Monitor> obtemListaMonitores() { 
        ArrayList<Monitor> monitores = new ArrayList<>();
        for(Pessoa p : participantes){
            if(p instanceof Monitor monitor){
                monitores.add(monitor);
            }
        }
        return monitores;
    }

    public void associaAtividade(Atividade att) throws AtividadeJaAssociadaATurmaException {
        if (atividades.contains(att)) {
            throw new AtividadeJaAssociadaATurmaException(" ERRO: A atividade já stá associada a uma turma."); 
        } else {
            atividades.add(att);
            att.setTurma(this); 
        }
    }


    public void desassociaAtividade(Atividade att) throws AtividadeNaoAssociadaATurmaException{
        if(!atividades.contains(att)){
            throw new AtividadeNaoAssociadaATurmaException(" ERRO: Atividade não associada a turma");
        } else {
            atividades.remove(att);
        }
    }

    public ArrayList<Atividade> obtemAtividadesDaTurma(boolean completa){
        ArrayList<Atividade> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a.getCompleta() == completa){
                lista.add(a);
            }
        }
        return lista;
    }

    public ArrayList<Atividade> obtemAtividadesDaTurma(boolean completa, Date inicio, Date fim){
        ArrayList<Atividade> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            Date data_inicio = a.getInicio();
            Date data_fim = a.getFim();

            boolean prazo = false;

            if ((inicio.after(data_inicio) || (inicio.equals(data_inicio)) && (fim.before(data_fim)) || (fim.equals(data_fim)))) prazo = true; 

            if ((a.getCompleta() && prazo)){
                lista.add(a);
            }
        }
        return lista;
    }

    
    public static ArrayList<Atividade> obtemAtividadesDaTurmaCompleta(boolean completa){
        completa = true;
        ArrayList<Atividade> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a.getCompleta() == completa){
                lista.add(a);
            }
        }
        return lista;
    }

    public ArrayList<Atividade> obtemAtividadesDaTurmaCompleta(boolean completa, Date inicio, Date fim){
        completa = true;
        ArrayList<Atividade> lista = new ArrayList<>();
        for (Atividade a : atividades) {
            Date data_inicio = a.getInicio();
            Date data_fim = a.getFim();

            boolean prazo = false;

            if ((inicio.after(data_inicio) || (inicio.equals(data_inicio)) && (fim.before(data_fim)) || (fim.equals(data_fim)))) prazo = true; 

            if ((a.getCompleta() && prazo)){
                lista.add(a);
            }
        }
        return lista;
    }

    public static Turma obtemTurmaPorID(int id) throws TurmaNaoExisteException{
        for (Turma t : turmas){
            if (t.get_id() == id){
                return t;
            }
        }

        throw new TurmaNaoExisteException("Turma com o ID informado não foi encontrada.");

    }

    public ArrayList<Turma> obtemTurmasDaPessoa(Pessoa pessoa) {
        ArrayList<Turma> resultado = new ArrayList<>();
        for (Turma turma : turmas) {
            if (turma.participa(pessoa.getNome())) {
                resultado.add(turma);
            }
        }
        return resultado;
    }

    public String imprimirInformacoes(Turma turma){
            String info = "";
            info += "ID: " + turma.get_id() + " \n";
            info += "Nome: " + turma.getNome() + " \n";
            info += "Descrição " + turma.getDescricao() + " \n";
            info += "Data início: " + turma.getInicio() + " \n";
            info += "Data final:" + turma.getFim() + " \n";
            for (Pessoa p : participantes){
            info += p.obterInformacoes() + " \n";
        }
            return info;
        }


    public static Turma criarTurma(int id, String nome, String descricao, Date inicio, Date fim, ArrayList<Pessoa> participantes) throws TurmaJaExisteException {
        for (Turma t : turmas) {
            if (t.get_id() == id) {
                throw new TurmaJaExisteException("Já existe uma turma com o ID informado.");
            }

        }
        Turma novaTurma = new Turma(id, nome, descricao, inicio, fim, participantes);
        turmas.add(novaTurma);
        return novaTurma;
    }
    

    //Turma sem participantes
    public static Turma criarTurma(int id, String nome, String descricao, Date inicio, Date fim) throws TurmaJaExisteException {
        for (Turma t : turmas) {
            if (t.get_id() == id) {
                throw new TurmaJaExisteException("Já existe uma turma com o ID informado.");
            }
        }
        ArrayList<Pessoa> participantesList = new ArrayList<>();
        Turma novaTurma = new Turma(id, nome, descricao, inicio, fim, participantesList);
        turmas.add(novaTurma);
        return novaTurma;
    }

    public static void atualizarTurma(int id, String novoNome, String novaDescricao, Date novoInicio, Date novoFim) throws TurmaNaoExisteException {
        Turma turmaParaAtualizar = null;
        for (Turma t : turmas) {
            if (t.get_id() == id) {
                turmaParaAtualizar = t;
                break;
            }
        }

        if (turmaParaAtualizar == null) {
            throw new TurmaNaoExisteException("Turma não encontrada para atualização.");
        }
        turmaParaAtualizar.nome = novoNome;
        turmaParaAtualizar.descricao = novaDescricao;
        turmaParaAtualizar.inicio = novoInicio;
        turmaParaAtualizar.fim = novoFim;
    }

    public static void deletarTurma(int id) throws TurmaNaoExisteException {
        Turma turmaParaRemover = null;
        for (Turma t : turmas) {
            if (t.get_id() == id) {
                turmaParaRemover = t;
                break;
            }
        }

        if (turmaParaRemover == null) {
        throw new TurmaNaoExisteException("Turma não encontrada para exclusão.");
        }

        turmas.remove(turmaParaRemover);
    }


    public static void ListarTurmas() {
        System.out.println("-----------------------------");
        System.out.println("Listagem de turmas:");
        System.out.println("------------------------------");
        for (Turma t : turmas) {
            System.out.println(t.imprimirInformacoes(t));
        }
    }
    
    public static void removerAtividade(Atividade atividade) throws AtividadeNaoAssociadaATurmaException {
        for (Turma t : turmas) {
            if (Turma.atividades.contains(atividade)) {
                t.desassociaAtividade(atividade);
                return;
            }
        }
        throw new AtividadeNaoAssociadaATurmaException("Atividade não associada a nenhuma turma.");
    }

}
