package ProjetoInterface;


public class Ave extends Animal {
    protected double Envergadura;
    public Ave(String nome, int idade, String som, double Envergadura) {
        super(nome, idade, som); // Chama o construtor da superclasse
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
