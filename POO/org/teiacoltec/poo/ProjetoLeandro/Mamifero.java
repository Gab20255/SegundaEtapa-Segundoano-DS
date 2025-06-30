package org.teiacoltec.poo.ProjetoLeandro;

public class Mamifero extends Animal{
    protected String TipoPelo;
    Mamifero(String nome, int idade, String som, String tipoPelo) {
        super(nome, idade, som);
        this.TipoPelo = tipoPelo;
    }
    public String getTipoPelo() {
        return TipoPelo;
    }
    public void setTipoPelo(String tipoPelo) {
        this.TipoPelo = tipoPelo;
    }
    public void Amamentar(){
        System.out.println(nome + " está amamentando");
    }
    
}
