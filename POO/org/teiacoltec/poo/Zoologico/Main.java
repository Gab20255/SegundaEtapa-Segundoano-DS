package Zoologico;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ZoologicoManager manager = new ZoologicoManager();
        Random random = new Random();

        String[] nomes = {"Luna", "Simba", "Milo", "Kira", "Bidu"};
        String[] raças = {"Poodle", "Labrador", "Pitbull"};
        String[] olhos = {"Azul", "Verde", "Castanho"};
        String[] frases = {"Olá!", "Quer um biscoito?", "Tudo bem?"};
        String[] pelos = {"curto", "médio", "longo"};
        String[] escamas = {"brilhante", "áspera"};

        for (int i = 0; i < 10; i++) {
            if (manager.getZoologicos().isEmpty() || random.nextInt(10) < 3) {
                manager.adicionarZoologico(new Zoologico(10));
                System.out.println("Novo zoológico criado!");
            }
            Zoologico z = manager.getZoologicos().get(random.nextInt(manager.getZoologicos().size()));
            Animal a = null;
            String nome = nomes[random.nextInt(nomes.length)] + i;
            int idade = random.nextInt(15) + 1;
            String som = "Som" + i;

            int tipo = random.nextInt(4); // 0 = Cachorro, 1 = Gato, 2 = Papagaio, 3 = Cobra

            switch (tipo) {
                case 0:
                    a = new Cachorro(nome, idade, som, pelos[random.nextInt(pelos.length)], raças[random.nextInt(raças.length)]);
                    break;
                case 1:
                    a = new Gato(nome, idade, som, pelos[random.nextInt(pelos.length)], olhos[random.nextInt(olhos.length)]);
                    break;
                case 2:
                    a = new Papagaio(nome, idade, som, 0.4 + random.nextDouble(), frases[random.nextInt(frases.length)]);
                    break;
                case 3:
                    a = new Cobra(nome, idade, som, escamas[random.nextInt(escamas.length)], random.nextInt(10));
                    break;
            }
            try {
                z.adicionarAnimal(a);
                System.out.println("Animal adicionado: " + nome + " (" + a.getClass().getSimpleName() + ")");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        int contador = 1;
        for (Zoologico z : manager.getZoologicos()) {
            System.out.println("\nZoológico #" + contador++);
            z.listarAnimais();
        }

        manager.salvarZoologicos();
    }
    }

