package ProjetoInterface;

public class Reptil extends Animal {
    protected String tipoDeEscama;
    public Reptil(String nome, int idade, String som, String tipoDeEscama, int id_zoo) {
        super(nome, idade, som); // Chama o construtor da superclasse
        this.tipoDeEscama=tipoDeEscama;
    }
    public void Ratejar(){
        System.out.println(nome+"Está Rastejando");
    }
    public String get_tipoDeEscama(){
        return this.tipoDeEscama;
    }
    public void setTipoDeEscama(String tipoDeEscama){
        this.tipoDeEscama= tipoDeEscama;
    }
    public String get_tipodeescama(){
        return this.tipoDeEscama;
    }
    public void set_tipodeescama(String tipoDeEscama){
        this.tipoDeEscama= tipoDeEscama;
    }
}
