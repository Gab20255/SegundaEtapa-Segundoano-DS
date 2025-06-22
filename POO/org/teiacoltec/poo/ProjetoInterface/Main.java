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
        Cachorro l= new Cachorro("MAX", 7, "Auau", "Macio", "Golden", 01);
        Gato a= new Gato("Felix", 10, "Miaauu", "Macio", "Olho Verde",01);
        Papagaio c= new Papagaio("Louro", 10, "Oi meu nome é louro", 0.6, "Eu amo JAVA!",02);
        Cobra n= new Cobra("Naja", 50,"sssss", "Flexivel", 6,01);
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
        try{
            System.out.println(n.get_id_zoo());
            zoo2.AdicionarAnimal(c);
            zoo.AdicionarAnimal(l);
            zoo.AdicionarAnimal(a);
            zoo.AdicionarAnimal(n);
            zoo2.AdicionarAnimal(n);
            System.out.println("Animal Adcionado com sucesso!");
            System.out.println(n.get_id_zoo());
        }
        catch(JaExisteAnimalException f){
            System.out.println("Esse animal já existe nesse zoológico");
        }
        catch(zooerradoException g){
            System.out.println(g.getMessage());
            for(int i=0; i<zoologicos.size(); i++){
            if(zoologicos.get(i).get_id_zoo()==n.get_id_zoo()){
                try{
                zoologicos.get(i).removerAnimal(n.get_nome());
                n.set_id_zoo(2);
                }
                catch(AnimalNaoEncontradoException e){
            System.out.println("Animal não encontrado nesse zoológico!\n");
        }
        try{
            zoo2.AdicionarAnimal(n);
        }
        catch(JaExisteAnimalException f){
            System.out.println("Esse animal já existe nesse zoológico");
        }
        catch(zooerradoException h){
            System.out.println(h.getMessage());
        }
            }
        }
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

    for (Zoologico z : zoos) {
        int i=1;
        System.out.println("Zoológico "+i+" carregado:\n");
        i++;
        z.ListarAnimais();
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
}
