package Zoologico.src.ProjetoInterface.Classes_DAO;

import Zoologico.src.ProjetoInterface.Classes_de_Animais.Animal;
import Zoologico.src.ProjetoInterface.Conexao.Conexao;
import Zoologico.src.ProjetoInterface.Conexao.FalhaConexaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void inserir(Animal animal) throws FalhaConexaoException {
        String sql = "INSERT INTO Animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, animal.get_nome());
            ps.setInt(2, animal.get_idade());
            ps.setString(3, animal.get_som());
            ps.setString(4, animal.get_tipo());
            ps.setString(5, animal.get_Caracteristica());
            ps.setInt(6, animal.get_id_zoo());
            
            ps.executeUpdate();

            // Se quiser, pode capturar o id gerado:
            try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                animal.setId(idGerado);  // seta o id que veio do banco no objeto
        }
}
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir Animal: " + e.getMessage());
        }
    }

    public List<Animal> listarTodos() throws FalhaConexaoException {
        List<Animal> animais = new ArrayList<>();
        String sql = "SELECT * FROM Animal";
        
        try (Connection conn = Conexao.obtemConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                // Como Animal é abstrata, não instanciamos diretamente aqui.
                // Retornaremos os dados básicos em um Animal "genérico" para exemplo.
                Animal animal = new Animal(rs.getString("nome"),
                                           rs.getInt("idade"),
                                           rs.getString("som"),
                                           rs.getString("tipo"),
                                           rs.getString("caracteristica")) {
                };
                animal.set_id_zoo(rs.getInt("id_zoo"));
                animais.add(animal);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar Animais: " + e.getMessage());
        }
        return animais;
    }

    public void atualizar(Animal animal) throws FalhaConexaoException {
        String sql = "UPDATE Animal SET nome = ?, idade = ?, som = ?, tipo = ?, caracteristica = ?, id_zoo = ? WHERE nome = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, animal.get_nome());
            ps.setInt(2, animal.get_idade());
            ps.setString(3, animal.get_som());
            ps.setString(4, animal.get_tipo());
            ps.setString(5, animal.get_Caracteristica());
            ps.setInt(6, animal.get_id_zoo());
            ps.setString(7, animal.get_nome()); // Atualiza pelo nome, pode mudar para id se tiver
            
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao atualizar Animal: " + e.getMessage());
        }
    }

    public void deletar(String nome) throws FalhaConexaoException {
        String sql = "DELETE FROM Animal WHERE nome = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao deletar Animal: " + e.getMessage());
        }
    }
    public void salvar(Animal animal) throws FalhaConexaoException {
    String sql = "INSERT INTO animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.obtemConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, animal.get_nome());
        stmt.setInt(2, animal.get_idade());
        stmt.setString(3, animal.get_som());
        stmt.setString(4, animal.get_tipo());
        stmt.setString(5, animal.get_Caracteristica());
        stmt.setInt(6, animal.get_id_zoo());

        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao salvar animal: " + e.getMessage());
    }
}
    public List<Animal> buscarPorZoologico(int id_zoo) throws FalhaConexaoException {
    List<Animal> animais = new ArrayList<>();

    String sql = "SELECT * FROM animal WHERE id_zoo = ?";

    try (Connection conn = Conexao.obtemConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id_zoo);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String som = rs.getString("som");
                String tipo = rs.getString("tipo");
                String caracteristica = rs.getString("caracteristica");

                Animal animal = new Animal(nome, idade, som, tipo, caracteristica) {}; // Classe anônima, se for abstrata
                animal.set_id_zoo(id_zoo);
                animais.add(animal);
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar animais do zoológico: " + e.getMessage());
    }

    return animais;
}

}
