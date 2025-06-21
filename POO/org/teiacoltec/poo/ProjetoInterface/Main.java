package ProjetoInterface;
public class Main {
    public static void main(String[] args) {
        Cachorro l= new Cachorro("MAX", 7, "Auau", "Macio", "Golden");
        Gato a= new Gato("Felix", 10, "Miaauu", "Macio", "Olho Verde");
        Papagaio c= new Papagaio("Louro", 10, "Oi meu nome é louro", 0.6, "Eu amo JAVA!");
        Cobra n= new Cobra("Naja", 50,"sssss", "Flexivel", 6);
        Animal[] animais= new Animal[5];
        animais[0]=l;
        animais[1]=a;
        animais[2]=c;
        animais[3]=n;
        Zoologico zoo= new Zoologico(animais);
        try{
        Animal b=zoo.buscarAnimal("Naja");
        System.out.println("Animal encontrado"+b.get_nome());
        }
        catch(AnimalNaoEncontradoException e){
            System.out.println("Animal não encontrado nesse zoológico!\n");
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
