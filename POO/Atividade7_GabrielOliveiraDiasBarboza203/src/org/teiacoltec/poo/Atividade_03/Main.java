package org.teiacoltec.poo.Atividade_03;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(new Pares(lock));
        Thread t2 = new Thread(new Impares(lock));

        t1.start();
        t2.start();
    }
}