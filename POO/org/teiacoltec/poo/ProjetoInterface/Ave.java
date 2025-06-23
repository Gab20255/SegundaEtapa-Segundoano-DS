package ProjetoInterface;

public class Ave extends Animal {
    public Ave(String nome, int idade, String som, String caracteristica) {
        super(nome, idade, som, "Ave", caracteristica);
    }

    public void Voar() {
        System.out.println(nome + " Está Voando");
    }
}

