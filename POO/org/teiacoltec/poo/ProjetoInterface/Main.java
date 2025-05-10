package ProjetoInterface;

public class Main {
    public static void main(String[] args) {
        Cachorro l= new Cachorro("MAX", 7, "Auau", "Macio", "Golden");
        Gato a= new Gato("Felix", 10, "Miaauu", "Macio", "Olho Verde");
        Papagaio c= new Papagaio("Louro", 10, "Oi meu nome é louro", 0.6, "Eu amo JAVA!");
        Cobra n= new Cobra("Naja", 50,"sssss", "Flexivel", 6);
        Zoologico zoo= new Zoologico(10);
        try{
            zoo.adicionarAnimal(a);
            zoo.buscarAnimal("Gabriel");
            zoo.removerAnimal(n);
            zoo.adicionarAnimal(a);
        }
        catch(JaExisteAnimalException | AnimalNaoEncontradoException e) {
            System.err.println("Erro ao criar animal");
        }
        ExibirAnimal(l);
        ExibirAnimal(n);
        ExibirAnimal(c);
        ExibirAnimal(a);
        l.emitir_som(7);
        interagirComAnimalDomestico(l);
        interagirComAnimalDomestico(a);
    }
    public static void ExibirAnimal(Animal animal){
        System.out.println("Nome: " + animal.get_nome());
        System.out.println("Idade: " + animal.get_idade());
        System.out.print("Som: ");
        animal.emitir_som();
    }
    public static void interagirComAnimalDomestico(InterfaceAnimaldomestico animal) {
        animal.levarParaPassear();
        animal.Brincar();
    }
}
