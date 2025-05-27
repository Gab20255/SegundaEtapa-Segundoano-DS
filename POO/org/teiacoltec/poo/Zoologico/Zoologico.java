package Zoologico;
import java.util.ArrayList;

public class Zoologico {
    protected ArrayList<Animal> animais;
    protected int capacidade;

    public Zoologico(int capacidade) {
        this.animais = new ArrayList<>();
        this.capacidade = capacidade;
    }

    public void adicionarAnimal(Animal animal) throws JaExisteAnimalException, AnimalNaoEncontradoException  {
         for (Animal a : animais) {
            if (a.get_nome().equalsIgnoreCase(animal.get_nome())) {
                throw new JaExisteAnimalException("Animal '" + animal.get_nome() + "' já existe.");
            }
        }
        animais.add(animal);
        capacidade++;
    }
    

    public void removerAnimal(Animal animal) throws AnimalNaoEncontradoException, JaExisteAnimalException {
        int aux=-1;
        for(int i=0; i<animais.size();i++){
            if(animais.get(i).get_nome().equalsIgnoreCase(animal.get_nome())){
                animais.remove(i);
                capacidade--;
                aux=1;
                break;
            }
        }
        if(aux==-1){
            throw new AnimalNaoEncontradoException("Animal '" + animal.get_nome() + "' não encontrado no zoológico.");
        }
    }

    public int buscarAnimal(String nome) throws AnimalNaoEncontradoException, JaExisteAnimalException {
        int index=-1;
        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).get_nome().equalsIgnoreCase(nome)) {
                index=i;
            }
        }
        if(index==-1){
            throw new AnimalNaoEncontradoException("Não há como buscar");
        }
        return index;
    }

    public void listarAnimais() {
    for (Animal animal : animais) {
        if (animal != null) {
            System.out.println("- " + animal.get_nome() + " (" + animal.getClass().getSimpleName() + ")");
        }        
    }
    }
}

