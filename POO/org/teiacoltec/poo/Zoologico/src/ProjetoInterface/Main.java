package ProjetoInterface;

import java.util.ArrayList;
import java.util.List;

import ProjetoInterface.Classes_de_Animais.Animal;
import ProjetoInterface.Excecoes.JaExisteAnimalException;
import ProjetoInterface.Interfaces.InterfaceAnimaldomestico;
import ProjetoInterface.Sub_Classes.Gato;
import ProjetoInterface.Sub_Classes.Cachorro;

public class Main {

    public static void main(String[] args) {
        // 1. Criar zoológicos
        Zoologico zoo1 = new Zoologico(1);
        Zoologico zoo2 = new Zoologico(2);
        List<Zoologico> todosOsZoos = new ArrayList<>();
        todosOsZoos.add(zoo1);
        todosOsZoos.add(zoo2);

        // 2. Criar animais
        Cachorro max = new Cachorro("Max", 5, "AUAU", "Macio", "Golden");
        Gato felix = new Gato("Felix", 4, "MIaaau", "Muito macio", "Verde");

        // 3. Adicionar animais ao zoo1
        adicionarAnimalAoZoologico(zoo1, felix);
        adicionarAnimalAoZoologico(zoo1, max);

        // 4. Exibir ID do zoológico atual de Max
        System.out.println("Zoológico atual de Max: " + max.get_id_zoo());

        // 5. Tentar mover Max para outro zoológico (zoo2)
        System.out.println("\nTentando mover Max para outro zoológico...");
        adicionarAnimalAoZoologico(zoo2, max);

        // 6. Verificar zoológico atualizado
        System.out.println("Zoológico atual de Max: " + max.get_id_zoo());

        // 7. Listar os animais dos zoológicos
        System.out.println("\n--- Zoológico 1 ---");
        zoo1.ListarAnimais();
        System.out.println("\n--- Zoológico 2 ---");
        zoo2.ListarAnimais();
    }

    // Método auxiliar para adicionar animal e tratar exceções
    private static void adicionarAnimalAoZoologico(Zoologico zoo, Animal animal) {
        try {
            zoo.AdicionarAnimal(animal);
            System.out.println(animal.get_nome() + " adicionado ao Zoológico " + zoo.get_id_zoo());
        } catch (JaExisteAnimalException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    // Método auxiliar (ainda útil)
    public static void exibirAmimal(Animal animal) {
        System.out.println("Dados do Animal\n---------------------");
        System.out.println("Nome do Animal: " + animal.get_nome());
        System.out.println("Som do Animal: " + animal.get_som());
        System.out.println("Idade: " + animal.get_idade() + "\n---------------------\n");
    }

    public static void InteragircomAnimalDomestico(InterfaceAnimaldomestico animal) {
        animal.levarParaPassear();
        animal.Brincar();
    }
}

