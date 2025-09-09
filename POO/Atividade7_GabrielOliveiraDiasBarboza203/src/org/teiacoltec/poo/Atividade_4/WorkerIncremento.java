package org.teiacoltec.poo.Atividade_4;

public class WorkerIncremento implements Runnable {
    private final int id;
    private final Contador contador;
    private final int repeticoes;

    public WorkerIncremento(int id, Contador contador, int repeticoes) {
        this.id = id;
        this.contador = contador;
        this.repeticoes = repeticoes;
    }

    @Override
    public void run() {
        for (int i = 0; i < repeticoes; i++) {
            contador.incrementar();
        }
        System.out.println("Thread " + id + " terminou de incrementar");
    }
}
