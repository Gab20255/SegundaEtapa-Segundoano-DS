package org.teiacoltec.poo.Atividade_4;

public class TesteThread04 {
    public static void main(String[] args) throws InterruptedException {
        final int THREADS = 5;
        final int REPETICOES = 100_000; 
        Contador contador = new Contador();

        Thread[] ts = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            ts[i] = new Thread(new WorkerIncremento(i + 1, contador, REPETICOES));
            ts[i].start();
        }
        for (Thread t : ts) {
            t.join();
        }

        long esperado = (long) THREADS * REPETICOES; // 500.000
        System.out.println("Valor final do contador: " + contador.get_valor());
        System.out.println("Esperado: " + esperado);
    }
}
