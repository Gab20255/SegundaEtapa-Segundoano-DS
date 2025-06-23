package ProjetoInterface;

public class Gato extends Mamifero implements InterfaceAnimalterrestre, InterfaceAnimaldomestico {
    public Gato(String nome, int idade, String som, String tipoDePelo){
        super(nome,idade,som,tipoDePelo);
    }
    public void Brincar(){
        System.out.println(nome+" esta brincando com o novelo de lã");
    }
    public void levarParaPassear(){
        System.out.println(nome+" esta  passeando no parque ecológico");
    }
    public void movimentar(){
        System.out.println(nome+"Esta andando lentamente");
    }

}
