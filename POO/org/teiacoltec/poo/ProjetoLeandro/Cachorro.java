package org.teiacoltec.poo.ProjetoLeandro;

public class Cachorro extends Mamifero implements InterfaceAnimalDomestico, InterfaceAnimalTerrestre {
    protected String raca;
    Cachorro(String nome, int idade, String som, String tipoPelo, String raca) {
        super(nome, idade, som, tipoPelo);
        this.raca = raca;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {  
        this.raca = raca;
    }
    public void levarParaPassear(){
        System.out.println(nome+" está passeando no parque!");
    }
    public void Brincar(){
        System.out.println(nome+" está brincando com o osso!");
    }
    public void movimentar_na_terra(){
        System.out.println(nome+" andando sobre quatro patas!");
    }
}
