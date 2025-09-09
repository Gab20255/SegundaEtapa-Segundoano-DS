package org.teiacoltec.poo.Atividade_03;

public class Impares implements Runnable {
    
    private final Object lock;

    public Impares(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run(){
        for(int i=1; i<=10; i+=2){
            if(i%2!=0){
                synchronized (lock) {
                System.out.println("Ímpar: " + i);
                lock.notify();
            
            try{
                if(i<10){
                    lock.wait();
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        }

    }    
}
}
