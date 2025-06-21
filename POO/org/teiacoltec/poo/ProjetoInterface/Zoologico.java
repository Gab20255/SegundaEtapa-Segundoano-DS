package ProjetoInterface;
import java.io.Serializable;
import java.util.*;
public class Zoologico implements Serializable {
    protected List<Animal> animais= new ArrayList<Animal>();
    private static final long serialVersionUID = 3L;
    Zoologico(List<Animal> animais){
        this.animais=animais;
    }
    public void AdicionarAnimal(Animal animalAdicional) throws JaExisteAnimalException{
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
            throw new AnimalNaoEncontradoException("Animal não encontrado, ele não está nesse zoo!\n");
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
}
