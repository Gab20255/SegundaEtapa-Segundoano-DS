package Atividade_02;

public class Main {
    public static void main(String[] args) {
        Impares teste_i= new Impares();
        Pares teste_p= new Pares();
        Thread thread_i= new Thread(teste_i);
        Thread thread_p= new Thread(teste_p);
        thread_i.start();
        thread_p.start();
    }
}
