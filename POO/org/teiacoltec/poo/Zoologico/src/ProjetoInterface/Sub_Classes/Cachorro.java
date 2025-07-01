package ProjetoInterface.Sub_Classes;

import ProjetoInterface.Interfaces.InterfaceAnimaldomestico;
import ProjetoInterface.Interfaces.InterfaceAnimalterrestre;
import ProjetoInterface.Classes_de_Animais.Mamifero;

public class Cachorro extends Mamifero implements InterfaceAnimaldomestico, InterfaceAnimalterrestre{
    protected String raca;
    public Cachorro(String nome, int idade, String som, String tipoDePelo, String raca){
        super(nome,idade,som,tipoDePelo);
        this.id_zoo=-1;
        this.raca=raca;
        this.set_Caracteristica(raca);
        this.set_tipo("Cachorro");
    }
    public void Brincar(){
        System.out.println(nome+" esta brincando com o graveto");
    }
    public void levarParaPassear(){
        System.out.println(nome+" esta  passeando no parque ecológico");
    }
    public void movimentar(){
        System.out.println(nome+"Esta correndo");
    }
    public String get_raca(){
        return this.raca;
    }
    public void set_raca(String raca){
        this.raca= raca;
    }
    public void set_Caracteristica(String caracteristica) {
        super.set_Caracteristica(caracteristica);
        this.raca = caracteristica;
    }
}

