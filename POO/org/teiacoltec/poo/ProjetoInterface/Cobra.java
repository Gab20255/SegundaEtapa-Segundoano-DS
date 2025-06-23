package ProjetoInterface;

public class Cobra extends Reptil implements InterfaceAnimalAquatico, InterfaceAnimalterrestre {

    public Cobra(String nome, int idade, String som, String tipoDeEscama, String IntensidadedeVeneno) {
        super(nome, idade, som, tipoDeEscama);
    }

    public void nadar() {
        System.out.println(nome + " Está nadando para caçar...");
    }

    public void pegarcorrenteza() {
        System.out.println(nome + " Está pegando a correnteza do Rio São Francisco");
    }

    public void flutuar() {
        System.out.println(nome + " Está flutuando");
    }

    public void movimentar() {
        System.out.println(nome + " está rastejando pela floresta");
    }
}

