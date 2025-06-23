package ProjetoInterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cachorro l= new Cachorro("MAX", 7, "Auau", "Macio", "Golden");
        Gato a= new Gato("Felix", 10, "Miaauu", "Macio", "Olho Verde");
        Papagaio c= new Papagaio("Louro", 10, "Oi meu nome é louro", 0.6, "Eu amo JAVA!");
        Cobra n= new Cobra("Naja", 50,"sssss", "Flexivel", 6);
        a.emitir_som();
        List<Zoologico> zoologicos= new ArrayList<Zoologico>();
        Zoologico zoo= new Zoologico( 01);
        Zoologico zoo2= new Zoologico(02);
        zoologicos.add(zoo);
        zoologicos.add(zoo2);
        try{
        Animal b=zoo.buscarAnimal("Viado");
        System.out.println("Animal encontrado "+b.get_nome());
        }
        catch(AnimalNaoEncontradoException e){
            System.out.println("Animal não encontrado nesse zoológico!\n");
        }
        try {
    zoo2.AdicionarAnimal(c);
} catch (JaExisteAnimalException | zooerradoException e) {
    System.out.println(e.getMessage());
}

try {
    zoo.AdicionarAnimal(l);
} catch (JaExisteAnimalException | zooerradoException e) {
    System.out.println(e.getMessage());
}

try {
    zoo.AdicionarAnimal(a);
} catch (JaExisteAnimalException | zooerradoException e) {
    System.out.println(e.getMessage());
}

try {
    zoo.AdicionarAnimal(a); // tentativa duplicada, deve cair na exceção
} catch (JaExisteAnimalException | zooerradoException e) {
    System.out.println(e.getMessage());
}

try {
    zoo.AdicionarAnimal(n);
} catch (JaExisteAnimalException | zooerradoException e) {
    System.out.println(e.getMessage());
}

try {
    zoo.AdicionarAnimal(n); // aqui deve dar erro de ID
} catch (JaExisteAnimalException | zooerradoException e) {
    System.out.println(e.getMessage());
    transferirAnimal(n,zoo2, zoologicos );
}

        zoo.ListarAnimais();
        System.out.println("Zoologico 2 \n");
        zoo2.ListarAnimais();
        try {
    FileOutputStream fileOut = new FileOutputStream("Zoologicos.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(zoologicos);
    out.close();
    fileOut.close();
    System.out.println("Zoológicos salvos com sucesso!");
    } catch (IOException e) {
    e.printStackTrace();
    }
try {
    FileInputStream fileIn = new FileInputStream("Zoologicos.ser");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    List<Zoologico> zoos = (List<Zoologico>) in.readObject(); 

    int i = 1;
    for (Zoologico z : zoos) {
    System.out.println("Zoológico " + i + " carregado:\n");
    z.ListarAnimais();
    i++;
}


    in.close();
    fileIn.close();
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}

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
    public static void transferirAnimal(Animal animal, Zoologico destino, List<Zoologico> zoologicos) {
    if (animal.get_id_zoo() == destino.get_id_zoo()) {
        System.out.println("Animal já está neste zoológico.");
        return;
    }
    
    for (Zoologico z : zoologicos) {
        if (z.get_id_zoo() == animal.get_id_zoo()) {
            try {
                z.removerAnimal(animal.get_nome());
                System.out.println("Animal removido do zoológico antigo.");
            } catch (AnimalNaoEncontradoException e) {
                System.out.println("Animal não encontrado no zoológico antigo.");
            }
            break;
        }
    }
    
    animal.set_id_zoo(destino.get_id_zoo());
    try {
        destino.AdicionarAnimal(animal);
        System.out.println("Animal adicionado ao novo zoológico com sucesso.");
    } catch (JaExisteAnimalException | zooerradoException e) {
        System.out.println("Erro ao adicionar animal no novo zoológico: " + e.getMessage());
    }
}

}
