package org.teiacoltec.poo.Atividade_03;
class Pares implements Runnable {
    private final Object lock;
 

    public Pares(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            synchronized (lock) {
                System.out.println("Par: " + i);
                lock.notify(); // Acorda a outra thread
                try {
                    if (i < 10) {
                        lock.wait(); // Espera a vez
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

