package ProjetoInterface.Sub_Classes;
import ProjetoInterface.Interfaces.InterfaceAnimaldomestico;
import ProjetoInterface.Interfaces.InterfaceAnimalterrestre;
import ProjetoInterface.Classes_de_Animais.Mamifero;
public class Gato extends Mamifero implements InterfaceAnimalterrestre, InterfaceAnimaldomestico {
    protected String olho;
    public Gato(String nome, int idade, String som, String tipoDePelo, String olho){
        super(nome,idade,som,tipoDePelo);
        this.id_zoo=-1;
        this.olho=olho;
        this.set_Caracteristica(olho);
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
    public String get_olho(){
        return this.olho;
    }
    public void set_olho(String olho){
        this.olho= olho;
    }
    public void set_Caracteristica(String caracteristica) {
        super.set_Caracteristica(Caracteristica);
        this.olho = Caracteristica;
    }
}
