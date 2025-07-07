package Zoologico.src.ProjetoInterface;

import java.util.List;
import java.util.Random;

import Zoologico.src.ProjetoInterface.Classes_de_Animais.*;
import Zoologico.src.ProjetoInterface.Sub_Classes.*;
import Zoologico.src.ProjetoInterface.Classes_DAO.*;
import Zoologico.src.ProjetoInterface.Excecoes.*;

public class Main {
    public static void main(String[] args) {
        try {
            ZoologicoDAO zoologicoDAO = new ZoologicoDAO();
            AnimalDAO animalDAO = new AnimalDAO();

            Random random = new Random();

            // Criar dois zoológicos e salvar no banco
            Zoologico zoo1 = new Zoologico(1);
            Zoologico zoo2 = new Zoologico(2);

            zoologicoDAO.salvar(zoo1);
            zoologicoDAO.salvar(zoo2);

            // Criar alguns animais aleatórios
            for (int i = 0; i < 5; i++) {
                Animal animal;
                int tipo = random.nextInt(3); // 0=mamifero,1=ave,2=reptil

                switch (tipo) {
                    case 0: // Mamífero
                        animal = new Cachorro("Cachorro" + i, random.nextInt(15), "Auau", "Curto", "Golden");
                        break;
                    case 1: // Ave
                        animal = new Papagaio("Papagaio" + i, random.nextInt(15), "Fala", 1.2 + i * 0.1, "Fala repetitiva " + i);
                        break;
                    default: // Réptil
                        animal = new Reptil("Reptil" + i, random.nextInt(15), "Som Reptil", "Escamas " + i);
                        break;
                }

                // Escolhe zoológico aleatório para adicionar
                Zoologico zooEscolhido = (random.nextBoolean()) ? zoo1 : zoo2;

                // Define id_zoo e zoologicoAtual para o animal
                animal.set_id_zoo(zooEscolhido.get_id_zoo());
                animal.setZoologicoAtual(zooEscolhido);

                // Adiciona animal no zoológico em memória e banco
                try {
                    zooEscolhido.AdicionarAnimal(animal);
                    animalDAO.salvar(animal);
                    System.out.println("Animal " + animal.get_nome() + " adicionado ao Zoológico " + zooEscolhido.get_id_zoo());
                } catch (JaExisteAnimalException e) {
                    System.out.println("Animal já existe no zoológico: " + animal.get_nome());
                }
            }

            // Buscar e listar animais de cada zoológico do banco
            System.out.println("\nAnimais no Zoológico 1:");
            List<Animal> animaisZoo1 = animalDAO.buscarPorZoologico(1);
            for (Animal a : animaisZoo1) {
                exibirAnimal(a);
            }

            System.out.println("\nAnimais no Zoológico 2:");
            List<Animal> animaisZoo2 = animalDAO.buscarPorZoologico(2);
            for (Animal a : animaisZoo2) {
                exibirAnimal(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exibirAnimal(Animal animal) {
        System.out.println("Nome: " + animal.get_nome() +
                ", Tipo: " + animal.get_tipo() +
                ", Característica: " + animal.get_Caracteristica() +
                ", Idade: " + animal.get_idade());
    }
}



