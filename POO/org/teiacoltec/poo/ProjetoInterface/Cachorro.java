package ProjetoInterface;

public class Cachorro extends Mamifero implements InterfaceAnimaldomestico, InterfaceAnimalterrestre{
    protected String raca;
    public Cachorro(String nome, int idade, String som, String tipoDePelo, String raca){
        super(nome,idade,som,tipoDePelo);
        this.raca=raca;
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
}
