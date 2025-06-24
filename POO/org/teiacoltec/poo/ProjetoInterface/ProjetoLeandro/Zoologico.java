package org.teiacoltec.poo.ProjetoLeandro;

public class Zoologico {
    final private String nome;
    private Animal[] listaAnimais;
    public Zoologico(String nome){
        this.nome=nome;
        this.listaAnimais=listaAnimais;
    }
    public Animal Buscar_Animal(String nome_do_animal) throws AnimalNaoEncontradoExcepition{
        for(Animal a: this.listaAnimais){
            if(a.get_nome().compareTo(nome_do_animal)==0){
                return a;
            }
        }
        return null;
    }
    public void listarAnimais(){
        System.out.println("Zoologico "+nome+"\n");
        System.out.println("Animais:\n");
        for(int i=0; i<listaAnimais.length; i++){
            exibirAmimal(listaAnimais[i]);
        }
    }
    public void AdicionarAnimal(Animal animal_adicionado)throws AnimalNaoEncontradoExcepition{
        
    }
}
