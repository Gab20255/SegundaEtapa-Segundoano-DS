package org.teiacoltec.poo;
import org.teiacoltec.poo.Classes.Cliente;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.teiacoltec.poo.Enumeracao.Status;
public class chat {
    public static void main(String[] args) {
        Cliente c1 = new Cliente( "Gabriel", null, Color.BLUE, Status.ONLINE);
        Cliente c2 = new Cliente( "Ana", null, Color.RED, Status.PENDENTE);
        Cliente c3 = new Cliente("Bruno", null, Color.GREEN, Status.AUSENTE);
        Cliente c4 = new Cliente( "Carla", null, Color.ORANGE, Status.OFFLINE);
        Cliente c5 = new Cliente( "Helton", null, Color.YELLOW, Status.OFFLINE);
        Map<Integer, Cliente> Clientes = new HashMap<>();
        Clientes.put(c1.get_ID(), c1);
        Clientes.put(c2.get_ID(), c2);
        Clientes.put(c3.get_ID(), c3);
        Clientes.put(c4.get_ID(), c4);
        Clientes.put(c5.get_ID(), c5);
        //teste
        System.out.println("Clientes Oniline:"+contar_clientes_online(Clientes));
        ordena_clientes_apelido(Clientes);
        List<Cliente> ordenados = ordena_clientes_apelido(Clientes);
        for (Cliente c : ordenados) {
            System.out.println(c.get_apelido());
        }
        List<Cliente> ordenados2 = ordenar_Por_Status_Apelido(Clientes);
        for (Cliente c : ordenados2) {
            System.out.println(c.get_apelido());
        }
    }

    public static long contar_clientes_online(Map<Integer, Cliente> clientes){
        return clientes.values().stream().filter(c -> c.get_status()== Status.ONLINE).count();
    }
    public static List<Cliente> ordena_clientes_apelido(Map<Integer, Cliente> clientes){
    List<Cliente> listaClientes = new ArrayList<>(clientes.values());
    listaClientes.sort((c1, c2) -> c1.get_apelido().compareTo(c2.get_apelido()));
    return listaClientes;
}

    public static List<Cliente> ordenar_Por_Status_Apelido(Map<Integer, Cliente> mapaClientes) {
    Collection<Cliente> clientes = mapaClientes.values();

    List<Cliente> online = clientes.stream()
                                   .filter(c -> c.get_status() == Status.ONLINE)
                                   .sorted(Comparator.comparing(Cliente::get_apelido))
                                   .collect(Collectors.toList()); 

    List<Cliente> ausente = clientes.stream()
                                    .filter(c -> c.get_status() == Status.AUSENTE)
                                    .sorted(Comparator.comparing(Cliente::get_apelido))
                                    .collect(Collectors.toList());

    List<Cliente> offline = clientes.stream()
                                    .filter(c -> c.get_status() == Status.OFFLINE)
                                    .sorted(Comparator.comparing(Cliente::get_apelido))
                                    .collect(Collectors.toList());

    List<Cliente> resultado = new ArrayList<>();
    resultado.addAll(online);
    resultado.addAll(ausente);
    resultado.addAll(offline);

    return resultado;
}


}
