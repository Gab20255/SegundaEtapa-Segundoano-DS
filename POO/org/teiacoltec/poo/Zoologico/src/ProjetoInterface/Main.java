package ProjetoInterface;

import java.util.ArrayList;
import java.util.List;

import ProjetoInterface.Classes_de_Animais.Animal;
import ProjetoInterface.Excecoes.JaExisteAnimalException;
import ProjetoInterface.Excecoes.zooerradoException;
import ProjetoInterface.Interfaces.InterfaceAnimaldomestico;
import ProjetoInterface.Sub_Classes.Gato;
import ProjetoInterface.Sub_Classes.Cachorro;
public class Main {
    public static void main(String[] args) {
        Zoologico zoologico= new Zoologico(2);
        Zoologico zoologico2= new Zoologico(3);
        List<Zoologico> ZOOS= new ArrayList<Zoologico>();
        ZOOS.add(zoologico);
        ZOOS.add(zoologico2);
        Cachorro max= new Cachorro("Max", 5, "AUAU", "Macio", "Golden");
        Gato felix= new Gato("Felix", 4, "MIaaau", "Muito macio", "Verde");
        try{
        zoologico.AdicionarAnimal(felix);
        }
        catch(JaExisteAnimalException e){
            System.out.println("Deu ruim\n");
        }
        catch(zooerradoException f){
            for(int i=0; i<ZOOS.size(); i++){
                if(ZOOS.get(i).get_id_zoo())
            }
        }
        try{
        zoologico.AdicionarAnimal(max);
        }
        catch(JaExisteAnimalException e){
            System.out.println("Deu ruim\n");
        }
        catch(zooerradoException f){
            System.out.println("Deu ruim\n");
        }
        System.out.println(max.get_id_zoo());
        try{
        zoologico2.AdicionarAnimal(max);
        }
        catch(JaExisteAnimalException e){
            System.out.println("Deu ruim\n");
        }
        catch(zooerradoException f){
            System.out.println("Deu ruim\n");
        }
        System.out.println(max.get_id_zoo());
    }
    public static void exibirAmimal(Animal animal){
        System.out.println("Dados do Animal\n---------------------");
        System.out.println("Nome do Animal: "+animal.get_nome());
        System.out.println("Som do Animal: "+animal.get_som());
        System.out.println("Idade:"+animal.get_idade()+"\n---------------------\n");
    }
    public static void InteragircomAnimalDomestico(InterfaceAnimaldomestico animal){
        animal.levarParaPassear();
        animal.Brincar();
    }
}
