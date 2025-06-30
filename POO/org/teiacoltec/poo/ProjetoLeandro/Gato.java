package ProjetoLeandro;

public class Gato extends Mamifero implements InterfaceAnimalDomestico {
    protected String cordoolho;
    Gato(String nome, int idade, String som, String tipoPelo, String cordoolho) {
        super(nome, idade, som, tipoPelo);
        this.cordoolho = cordoolho;
    }
    public String getolho() {
        return cordoolho;
    }
    public void setRaca(String cordoolho) {  
        this.cordoolho = cordoolho;
    }

    public void levarParaPassear(){
        System.out.println(nome+" está passeando nos telhados!");
    }
    public void Brincar(){
        System.out.println(nome+" está brincando com o noveelo de lã!");
    }
    public void movimentar_na_terra(){
        System.out.println(nome+" andando sobre quatro patas sem fazer barulho!");
    }
}
