package Zoologico;
import java.io.*;
import java.util.ArrayList;
public class ZoologicoManager {
    private static final String arq = "zoologicos.dat";
    private ArrayList<Zoologico> zoologicos;
    public ZoologicoManager() {
        zoologicos = carregarZoologicos();
    }
    public void adicionarZoologico(Zoologico z) {
        zoologicos.add(z);
    }
    public ArrayList<Zoologico> getZoologicos() {
        return zoologicos;
    }
     public void salvarZoologicos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arq))) {
            out.writeObject(zoologicos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar zoológicos: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
      private ArrayList<Zoologico> carregarZoologicos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arq))) {
            return (ArrayList<Zoologico>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); 
        }
    }
}

