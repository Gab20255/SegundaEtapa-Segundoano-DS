package Zoologico.src.ProjetoInterface;
import java.io.Serializable;
import java.util.*;

import Zoologico.src.ProjetoInterface.Classes_de_Animais.Animal;
import Zoologico.src.ProjetoInterface.Excecoes.AnimalNaoEncontradoException;
import Zoologico.src.ProjetoInterface.Excecoes.JaExisteAnimalException;
public class Zoologico implements Serializable {
    final private  List<Animal> animais= new ArrayList<Animal>();
    private int id_zoo;
    private static final long serialVersionUID = 108L;
    public Zoologico( int id_zoo){
        this.id_zoo=id_zoo;
    }
    public void AdicionarAnimal(Animal animal) throws JaExisteAnimalException{
        if(animal.get_id_zoo()==-1){
            animal.set_id_zoo(this.id_zoo);
        }
           Zoologico antigo = animal.getZoologicoAtual();
    if (antigo != null && antigo != this) {
        try{
        antigo.removerAnimal(animal);
        }
        catch(AnimalNaoEncontradoException F){
            System.out.println("Animal não existe nesse");
        }
    }
    animal.setZoologicoAtual(this);
    animal.set_id_zoo(this.id_zoo);
    animais.add(animal);
        
            if(animais.contains(animal)){
                throw new JaExisteAnimalException("Este animal já existe nesse zoológico!\n");
            }
        
        
    }
    public Animal buscarAnimal(String nome_do_animal_procurado) throws AnimalNaoEncontradoException{
        int id_animal_buscado=-1;
        for(int i=0; i<animais.size(); i++){
            if(animais.get(i)!=null && animais.get(i).get_nome().equals(nome_do_animal_procurado)){
                id_animal_buscado=i;
                break;
            }
        }
        if(id_animal_buscado==-1){
            throw new AnimalNaoEncontradoException("Não encontrado");
        }
        return animais.get(id_animal_buscado);
    }
    public void removerAnimal(Animal a)throws AnimalNaoEncontradoException{
        Animal Animal_removido=buscarAnimal(a.get_nome());
        Animal_removido.set_id_zoo(-1);
        if(a!=Animal_removido){
            throw  new AnimalNaoEncontradoException("Deu ruim");      }
        else{
        animais.remove(Animal_removido);
        }
    }
    public void ListarAnimais(){
        for(int i=0;i<animais.size(); i++){
            if(animais.get(i)!=null){
            System.out.println("Animal 0"+(i+1)+":"+animais.get(i).getClass().getSimpleName()+" "+animais.get(i).get_nome()+"\n");
            }
        }
    }
    public void set_id_zoo(int id_zoo) {
        this.id_zoo= id_zoo;
    }

    public int get_id_zoo() {
        return id_zoo;
    }
}
