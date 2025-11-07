package org.teiacoltec.poo.Atividade_01;
public class Main{
    public static void main(String[] args) {
        Gab_Thread teste= new Gab_Thread();
        Thread thread= new Thread(teste);
        thread.start();
    }
}