package ProjetoInterface;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String nome;
    protected int idade;
    protected String som;
    protected int id_zoo;
    protected String tipo;            // Novo atributo para o tipo do animal
    protected String caracteristica;

    public Animal(String nome, int idade, String som, String tipo, String caracteristica) {
        this.nome = nome;
        this.idade = idade;
        this.som = som;
        this.tipo = tipo;
        this.caracteristica = caracteristica;
        this.id_zoo = -1;
    }

    public String get_som() {
        return som;
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

    public void set_caracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String get_id_caracteristica() {
        return caracteristica;
    }

    public void set_id_zoo(int id_zoo) {
        this.id_zoo = id_zoo;
    }

    public String get_tipo() {
        return tipo;
    }

    public void set_tipo(String tipo) {
        this.tipo = tipo;
    }
}

