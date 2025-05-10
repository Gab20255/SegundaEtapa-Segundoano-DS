package ProjetoInterface;

public class Zoologico {
    protected Animal[] animais;
    protected int quantidadeDeAnimais;

    public Zoologico(int capacidade) {
        animais = new Animal[capacidade];
        quantidadeDeAnimais = 0;
    }

    public void adicionarAnimal(Animal animal) throws JaExisteAnimalException, AnimalNaoEncontradoException  {
        int a=0;
        if(a==-1){
            throw new JaExisteAnimalException("Animal '" + animal.get_nome() + "' já existe.");
        }
        animais[quantidadeDeAnimais] = animal;
        quantidadeDeAnimais++;
    }

    public void removerAnimal(Animal animal) throws AnimalNaoEncontradoException, JaExisteAnimalException {
        int index = buscarAnimal(animal.get_nome());
        if (index != -1) {
            for (int i = index; i < quantidadeDeAnimais - 1; i++) {
                animais[i] = animais[i + 1];
            }
            animais[quantidadeDeAnimais - 1] = null;
            quantidadeDeAnimais--;
        } else {
            throw new AnimalNaoEncontradoException("Animal '" + animal.get_nome() + "' não encontrado no zoológico.");
        }
    }

    public int buscarAnimal(String nome) throws AnimalNaoEncontradoException, JaExisteAnimalException {
        int index=-1;
        for (int i = 0; i < quantidadeDeAnimais; i++) {
            if (animais[i].get_nome().equalsIgnoreCase(nome)) {
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

