package org.teiacoltec.poo.Atividade_4;

public class Contador {
    private long val = 0;
    public synchronized void incrementar() {
        val++;
    }

    public long get_valor() {
        return val;
    }
}
