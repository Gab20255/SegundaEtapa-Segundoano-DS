package ProjetoInterface;

public class Zoologico {
    protected Animal[] animais= new Animal[5];
    protected int lotacao=0;
    Zoologico(Animal[] animais){
        this.animais=animais;
        this.lotacao=animais.length;
    }
    public void AdicionarAnimal(Animal animalAdicional) throws JaExisteAnimalException{
        for(int i=0; i<animais.length;i++){
            if(animais[i]!=null && animais[i].equals(animalAdicional) ){
                throw new JaExisteAnimalException("Este animal já existe nesse zoológico!\n");
            }
            if(animais[i]==null){
                lotacao=i+1;
                animais[i]=animalAdicional;
                break;
            }
        }
    }
    public Animal buscarAnimal(String nome_do_animal_procurado) throws AnimalNaoEncontradoException{
        int id_animal_buscado=-1;
        for(int i=0; i<lotacao; i++){
            if(animais[i]!=null && animais[i].get_nome().equals(nome_do_animal_procurado)){
                id_animal_buscado=i;
                break;
            }
        }
        if(id_animal_buscado==-1){
            throw new AnimalNaoEncontradoException("Animal não encontrado, ele não está nesse zoo!\n");
        }
        return animais[id_animal_buscado];
    }
    public void removerAnimal(String nome_do_animal_procurado)throws AnimalNaoEncontradoException{
        Animal Animal_removido=buscarAnimal(nome_do_animal_procurado);
        for(int i=0; i<lotacao; i++){
            if(animais[i].equals(Animal_removido)){
                animais[i]=animais[lotacao-1];
                animais[lotacao-1]=null;
                lotacao--;
                break;
            }
        }
    }
    public void ListarAnimais(){
        for(int i=0;i<lotacao; i++){
            if(animais[i]!=null){
            System.out.println("Animal 0"+(i+1)+":"+animais[i].getClass().getSimpleName()+" "+animais[i].get_nome()+"\n");
            }
        }
    }
}
