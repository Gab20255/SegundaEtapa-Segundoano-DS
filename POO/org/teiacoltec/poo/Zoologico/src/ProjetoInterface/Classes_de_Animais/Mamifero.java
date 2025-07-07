package Zoologico.src.ProjetoInterface.Classes_de_Animais;

public class Mamifero extends Animal {
    protected String tipoDePelo;
    public Mamifero(String nome, int idade, String som, String tipoDePelo) {
        super(nome, idade, som, "Mamifero", tipoDePelo); // Chama o construtor da superclasse
        this.id_zoo=-1;
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


