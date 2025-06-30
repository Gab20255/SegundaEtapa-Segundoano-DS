package ProjetoInterface;

import ProjetoInterface.Classes_de_Animais.Animal;
import ProjetoInterface.Excecoes.JaExisteAnimalException;
import ProjetoInterface.Excecoes.zooerradoException;
import ProjetoInterface.Interfaces.InterfaceAnimaldomestico;
import ProjetoInterface.Sub_Classes.Gato;
import ProjetoInterface.Sub_Classes.Cachorro;
public class Main {
    public static void main(String[] args) {
        Zoologico zoologico= new Zoologico(2);
        Cachorro max= new Cachorro("Max", 5, "AUAU", "Macio", "Golden");
        Gato felix= new Gato("Felix", 4, "MIaaau", "Muito macio", "Verde");
        try{
        zoologico.AdicionarAnimal(felix);
        }
        catch(JaExisteAnimalException e){
            System.out.println("Deu ruim\n");
        }
        catch(zooerradoException f){
            System.out.println("Deu ruim\n");
        }
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
