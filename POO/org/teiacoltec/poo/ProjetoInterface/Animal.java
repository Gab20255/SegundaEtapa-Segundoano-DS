package ProjetoInterface;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String nome;
    protected int idade;
    protected String som;
    protected int id_zoo;

    public Animal(String nome, int idade, String som) {
        this.nome = nome;
        this.idade = idade;
        this.som = som;
        this.id_zoo = -1;
    }

    public String get_nome() {
        return nome;
    }

    public int get_idade() {
        return idade;
    }

    public void emitir_som() {
        System.out.println(som);
    }

    public int get_id_zoo() {
        return id_zoo;
    }

    public void set_id_zoo(int id_zoo) {
        this.id_zoo = id_zoo;
    }
}
