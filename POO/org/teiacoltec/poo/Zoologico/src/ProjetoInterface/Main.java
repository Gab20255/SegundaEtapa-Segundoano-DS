package ProjetoInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ProjetoInterface.Classes_de_Animais.Animal;
import ProjetoInterface.Sub_Classes.Cachorro;
import ProjetoInterface.Sub_Classes.Gato;

public class Main {
    private static final String ARQUIVO = "zoologicos.dat";

    public static void main(String[] args) {
        // Verifica se já existe arquivo salvo
        List<Zoologico> todosOsZoos = carregarZoologicos();
        if (todosOsZoos == null) {
            // Cria zoológicos novos se não existir arquivo
            todosOsZoos = new ArrayList<>();
            todosOsZoos.add(new Zoologico(1));
            todosOsZoos.add(new Zoologico(2));
        }

        Zoologico zoo1 = todosOsZoos.get(0);
        Zoologico zoo2 = todosOsZoos.get(1);

        // Cria animais
        Cachorro max = new Cachorro("Max", 5, "AUAU", "Macio", "Golden");
        Gato felix = new Gato("Felix", 4, "MIAU", "Muito macio", "Verde");

        adicionarAnimalAoZoologico(zoo1, max);
        adicionarAnimalAoZoologico(zoo1, felix);

        System.out.println("\nZoológico atual do Max: " + max.get_id_zoo());

        System.out.println("\nMovendo Max para zoo2...");
        adicionarAnimalAoZoologico(zoo2, max);

        System.out.println("Zoológico atual do Max: " + max.get_id_zoo());

        // Listar zoológicos
        System.out.println("\n--- Zoológico 1 ---");
        zoo1.ListarAnimais();

        System.out.println("\n--- Zoológico 2 ---");
        zoo2.ListarAnimais();

        // Serializar no final
        salvarZoologicos(todosOsZoos);
    }

    private static void adicionarAnimalAoZoologico(Zoologico zoo, Animal animal) {
        try {
            zoo.AdicionarAnimal(animal);
            System.out.println(animal.get_nome() + " adicionado ao Zoológico " + zoo.get_id_zoo());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar " + animal.get_nome() + ": " + e.getMessage());
        }
    }

    private static void salvarZoologicos(List<Zoologico> zoologicos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(zoologicos);
            System.out.println("\nZoológicos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar zoológicos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Zoologico> carregarZoologicos() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) return null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            System.out.println("Zoológicos carregados do arquivo.");
            return (List<Zoologico>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar zoológicos: " + e.getMessage());
            return null;
        }
    }
}

