package ProjetoInterface;

public class Mamifero extends Animal {

    public Mamifero(String nome, int idade, String som, String caracteristica) {
        super(nome, idade, som, "Mamifero", caracteristica);
    }
    
    public void Amamentar() {
        System.out.println(nome + " Está amamentando");
    }
}

