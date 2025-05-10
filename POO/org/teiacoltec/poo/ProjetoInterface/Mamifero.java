package ProjetoInterface;

public class Mamifero extends Animal {
    protected String tipoDePelo;
    public Mamifero(String nome, int idade, String som, String tipoDePelo) {
        super(nome, idade, som); // Chama o construtor da superclasse
        this.tipoDePelo=tipoDePelo;
    }
    public void Amamentar(){
        System.out.println(nome+"Está amamentando");
    }
    public String getTipoDePelo(){
        return tipoDePelo;
    }
    public void setTipoDePelo(String tipoDePelo){
        this.tipoDePelo= tipoDePelo;
    }
}
