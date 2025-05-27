package Zoologico;

public abstract class Animal {
    protected String nome;
    protected int idade;
    protected String som;

    Animal(String nome, int idade, String som) {
        this.nome = nome;
        this.idade = idade;
        this.som = som;
    }
    public void emitir_som(){
        System.out.println(som);
    }
    public void emitir_som(int Intensidade){
        if (Intensidade>5){
            System.out.println(som+"...Esse foi um som de alta intensidade");
        }
        else{
            System.out.println(som+"...Esse foi um som de baixa intensidade");
        }
    }
    public String get_nome(){
        return this.nome;
    }
    public int get_idade(){
        return this.idade;
    }
    public void set_nome(String nome) {
        this.nome = nome;
    }

    public void set_idade(int idade) {
        this.idade = idade;
    }

    public void set_som(String som) {
        this.som = som;
    }
}