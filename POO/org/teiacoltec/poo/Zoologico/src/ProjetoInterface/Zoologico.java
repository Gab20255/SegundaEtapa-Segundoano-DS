package ProjetoInterface;
import java.io.Serializable;
import java.util.*;

import ProjetoInterface.Classes_de_Animais.Animal;
import ProjetoInterface.Excecoes.AnimalNaoEncontradoException;
import ProjetoInterface.Excecoes.JaExisteAnimalException;
import ProjetoInterface.Excecoes.zooerradoException;
public class Zoologico implements Serializable {
    protected List<Animal> animais= new ArrayList<Animal>();
    protected int id_zoo;
    private static final long serialVersionUID = 3L;
    Zoologico( int id_zoo){
        this.id_zoo=id_zoo;
    }
    public void AdicionarAnimal(Animal animalAdicional) throws JaExisteAnimalException, zooerradoException{
        if(animalAdicional.get_id_zoo()==-1){
            animalAdicional.set_id_zoo(this.id_zoo);
        }
            if(animalAdicional.get_id_zoo()!=id_zoo){
                animalAdicional.set_id_zoo(id_zoo);
                throw new zooerradoException("O animal está mudando de zoologico");
            }
            if(animais.contains(animalAdicional)){
                throw new JaExisteAnimalException("Este animal já existe nesse zoológico!\n");
            }
        animais.add(animalAdicional);
        
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
    public void removerAnimal(String nome_do_animal_procurado)throws AnimalNaoEncontradoException{
        Animal Animal_removido=buscarAnimal(nome_do_animal_procurado);
        animais.remove(Animal_removido);
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
