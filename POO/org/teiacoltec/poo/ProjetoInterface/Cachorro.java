package ProjetoInterface;

public class Cachorro extends Mamifero implements InterfaceAnimaldomestico, InterfaceAnimalterrestre {

    public Cachorro(String nome, int idade, String som, String tipoDePelo, String raca) {
        super(nome, idade, som, tipoDePelo);
    }

    public void Brincar() {
        System.out.println(nome + " está brincando com o graveto");
    }

    public void levarParaPassear() {
        System.out.println(nome + " está passeando no parque ecológico");
    }

    public void movimentar() {
        System.out.println(nome + " Está correndo");
    }
}

