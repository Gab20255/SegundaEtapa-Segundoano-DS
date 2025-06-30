package org.teiacoltec.poo.ProjetoLeandro;

public class AnimalNaoEncontradoExcepition extends Exception{
    public AnimalNaoEncontradoExcepition(String nome){
    super("Animal "+nome+ "nao esta presente no zoologico!");
    }    
}
