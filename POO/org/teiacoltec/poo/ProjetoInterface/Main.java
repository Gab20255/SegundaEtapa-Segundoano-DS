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
        List<Animal> animais= new ArrayList<Animal>();
        animais.add(l);
        animais.add(a);
        animais.add(c);
        animais.add(n);
        Zoologico zoo= new Zoologico(animais);
        Zoologico zoo2= new Zoologico(animais);
        try{
        Animal b=zoo.buscarAnimal("Viado");
        System.out.println("Animal encontrado "+b.get_nome());
        }
        catch(AnimalNaoEncontradoException e){
            System.out.println("Animal não encontrado nesse zoológico!\n");
        }
        try{
            zoo.AdicionarAnimal(l);
            System.out.println("Animal Adcionado com sucesso!");
        }
        catch(JaExisteAnimalException f){
            System.out.println("Esse animal já existe nesse zoológico");
        }
        zoo.ListarAnimais();
        ExibirAnimal(l);
        ExibirAnimal(n);
        ExibirAnimal(c);
        ExibirAnimal(a);
        l.emitir_som(7);
        interagirComAnimalDomestico(l);
        interagirComAnimalDomestico(a);
        try {
    FileOutputStream fileOut = new FileOutputStream("Zoologicos.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(zoo);
    out.close();
    fileOut.close();
    System.out.println("Zoológico salvo com sucesso!");
    } catch (IOException e) {
    e.printStackTrace();
    }
    try {
    FileOutputStream fileOut = new FileOutputStream("Zoologicos.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(zoo2);
    out.close();
    fileOut.close();
    System.out.println("Zoológico salvo com sucesso!");
    } catch (IOException e) {
    e.printStackTrace();
} 
try {
    FileInputStream fileIn = new FileInputStream("Zoologicos.ser");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    Zoologico zooLido = (Zoologico) in.readObject();
    in.close();
    fileIn.close();

    System.out.println("Zoológico carregado:");
    zooLido.ListarAnimais();
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
}
