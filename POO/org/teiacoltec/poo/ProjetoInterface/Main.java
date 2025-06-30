package ProjetoInterface;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            Random random = new Random();

            

            // Cria dois zoológicos
            Zoologico zoo1 = new Zoologico(1);
            Zoologico zoo2 = new Zoologico(2);

            

            System.out.println("Zoológicos criados!");

            // Gera 5 animais aleatórios
            for (int i = 0; i < 5; i++) {
                Animal animal = null;

                int tipoAnimal = random.nextInt(3); // 0-Mamifero, 1-Ave, 2-Reptil
                String nome = "Animal" + (i + 1);
                int idade = random.nextInt(10) + 1; // idade de 1 a 10
                String som = "Som" + (i + 1);

                switch (tipoAnimal) {
                    case 0:
                        animal = new Mamifero(nome, idade, som, "Pelo macio");
                        animal.set_tipo("Mamifero");
                        break;
                    case 1:
                        animal = new Ave(nome, idade, som, "Envergadura 1.5m");
                        animal.set_tipo("Ave");
                        break;
                    case 2:
                        animal = new Reptil(nome, idade, som, "Escama rugosa");
                        animal.set_tipo("Reptil");
                        break;
                }

                // Decide aleatoriamente em qual zoo vai
                int zooEscolhido = random.nextInt(2) + 1; // 1 ou 2
                if (zooEscolhido == 1) {
                    zoo1.AdicionarAnimal(animal);
                } else {
                    zoo2.AdicionarAnimal(animal);
                }

                System.out.println("Animal criado: " + animal.get_nome() + " - Tipo: " + animal.get_tipo());
            }

            // Salva os zoológicos no banco (e os animais)
           

            // Lista os animais de cada zoológico
            System.out.println("\n=== Animais do Zoológico 1 ===");
            zoo1.ListarAnimais();

            System.out.println("\n=== Animais do Zoológico 2 ===");
            zoo2.ListarAnimais();

            // Testa emissão de som dos animais do zoo1
            System.out.println("\n=== Sons dos Animais do Zoológico 1 ===");
            for (Animal a : zoo1.animais) {
                System.out.print(a.get_nome() + ": ");
                a.emitir_som();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

