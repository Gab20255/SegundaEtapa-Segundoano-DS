package ProjetoInterface.Classes_de_Animais;

import java.io.Serializable;

import ProjetoInterface.Zoologico;

public abstract class Animal implements Serializable {
    protected String nome;
    protected int idade;
    protected String som;
    protected int id_zoo;
    private Zoologico zoologicoAtual;
    protected String tipo;
    protected String Caracteristica;
    public Zoologico getZoologicoAtual() {
        return zoologicoAtual;
    }

    public void setZoologicoAtual(Zoologico zoo) {
        this.zoologicoAtual = zoo;
    }

    public Animal(String nome, int idade, String som, String tipo, String Caracteristica) {
        this.nome = nome;
        this.idade = idade;
        this.som = som;
        this.tipo=tipo;
        this.Caracteristica=Caracteristica;
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
    public void set_tipo(String tipo) {
        this.tipo = tipo;
    }
    public String get_tipo() {
        return tipo;
    }
    public void set_Caracteristica(String Caracteristica) {
        this.Caracteristica = Caracteristica;
    }
    public String get_Caracteristica() {
        return Caracteristica;
    }
    public void set_id_zoo(int id_zoo) {
        this.id_zoo = id_zoo;
    }
    
}

