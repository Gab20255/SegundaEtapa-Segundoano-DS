package ProjetoInterface;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String nome;
    protected int idade;
    protected String som;
    protected int id_zoo;

    Animal(String nome, int idade, String som, int id_zoo) {
        this.nome = nome;
        this.idade = idade;
        this.som = som;
        this.id_zoo= id_zoo;
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