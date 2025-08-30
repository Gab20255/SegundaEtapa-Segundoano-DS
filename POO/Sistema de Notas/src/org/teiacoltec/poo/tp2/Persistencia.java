package org.teiacoltec.poo.tp2;

import java.io.*;

public class Persistencia {

    public static void salvar(Object objeto, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + nomeArquivo + " (" + e.getMessage() + ")");
        }
    }

    public static Object carregar(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar: " + nomeArquivo + " (" + e.getMessage() + ")");
            return null;
        }
    }
}
