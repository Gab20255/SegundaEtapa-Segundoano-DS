package ProjetoInterface.Sub_Classes;
import ProjetoInterface.Interfaces.InterfaceAnimaldomestico;
import ProjetoInterface.Interfaces.InterfaceanimalAereo;



import ProjetoInterface.Classes_de_Animais.Ave;

public class Papagaio extends Ave implements InterfaceAnimaldomestico, InterfaceanimalAereo {
    protected String Falarepetitiva;
    public Papagaio(String nome, int idade, String som, double Envergadura, String Falarepetitiva){
        super(nome, idade, som, Envergadura);
        this.id_zoo=-1;
        this.Falarepetitiva= Falarepetitiva;
        this.set_Caracteristica(Falarepetitiva);
    }
    public void Brincar(){
        System.out.println(nome+" está brincando de pular em seu vivero");
    }
    public void levarParaPassear(){
        System.out.println(nome+" esta passeando no céu da cidade de BH");
    }
    public void planar(){
        System.out.println(nome+" está planando num dia ensolarado para pousar em seu dono");
    }
    public void razante(){
        System.out.println(nome+" está fazendo um razante para pegar uma fruta");
    }
    public String get_Falarepetitiva(){
        return this.Falarepetitiva;
    }
    public void set_Falarepetitiva(String Falarepetitiva){
        this.Falarepetitiva= Falarepetitiva;
    }
    public void set_Caracteristica(String caracteristica) {
        super.set_Caracteristica(Caracteristica);
        this.Falarepetitiva = Caracteristica;
    }

}

