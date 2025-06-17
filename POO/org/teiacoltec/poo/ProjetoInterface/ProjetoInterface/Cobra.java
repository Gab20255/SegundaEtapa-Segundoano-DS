package ProjetoInterface.ProjetoInterface;

public class Cobra extends Reptil implements InterfaceAnimalAquatico, InterfaceAnimalterrestre {
    protected int IntensidadedeVeneno;
    public Cobra(String nome, int idade, String som, String tipoDeEscama, int IntensidadedeVeneno){
        super(nome, idade, som, tipoDeEscama);
        this.IntensidadedeVeneno=IntensidadedeVeneno;
    }
    public int get_IntensidadedeVeneno(){
        return this.IntensidadedeVeneno;
    }
    public void set_IntensidadedeVeneno(int IntensidadedeVeneno){
        this.IntensidadedeVeneno=IntensidadedeVeneno;
    }
    public void nadar(){
        System.out.println(nome+" Está nadando para caçar...");
    }
    public void pegarcorrenteza(){
        System.out.println(nome+" Está pegando a correnteza do Rio São Francisco");
    }
    public void flutuar(){
        System.out.println(nome+" Esta fultuando");
    }
    public void movimentar(){
        System.out.println(nome+" esta rastejando pela floresta");
    }
}
