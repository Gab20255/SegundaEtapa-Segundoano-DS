package Zoologico.src.ProjetoInterface.Classes_de_Animais;

public class Ave extends Animal {
    protected double Envergadura;
    public Ave(String nome, int idade, String som, double Envergadura) {
        super(nome, idade, som, "Ave", String.valueOf(Envergadura)); // Chama o construtor da superclasse
        this.id_zoo = -1;
        this.Envergadura=Envergadura;
    }
    public void Voar(){
        System.out.println(nome+"Está Voando");
    }
    public double get_Envergadura(){
        return this.Envergadura;
    }
    public void setEnvergadura(double Envergadura){
        this.Envergadura= Envergadura;
    }
}

