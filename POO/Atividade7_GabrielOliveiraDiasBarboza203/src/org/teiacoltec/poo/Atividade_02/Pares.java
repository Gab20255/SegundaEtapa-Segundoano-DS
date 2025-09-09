package Atividade_4.org.teiacoltec.poo.Atividade_02;

public class Pares implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if (i%2==0) { 
                System.out.println(i);
            }
            try {
                int intervalo = (int) (Math.random() * 1001); 
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

