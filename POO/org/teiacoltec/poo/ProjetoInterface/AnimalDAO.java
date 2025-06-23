package ProjetoInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void inserir(Animal animal) throws FalhaConexaoException {
        String sql = "INSERT INTO animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.get_nome());
            stmt.setInt(2, animal.get_idade());
            stmt.setString(3, animal.get_som());
            stmt.setString(4, animal.get_tipo());
            stmt.setString(5, animal.get_id_caracteristica());
            stmt.setInt(6, animal.get_id_zoo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir animal: " + e.getMessage());
        }
    }

    public List<Animal> listar() throws FalhaConexaoException {
        String sql = "SELECT * FROM animal";
        List<Animal> animais = new ArrayList<>();

        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Animal animal = criarAnimalDoResultSet(rs, tipo);
                if (animal != null) {
                    animal.set_id_zoo(rs.getInt("id_zoo"));
                    animais.add(animal);
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar animais: " + e.getMessage());
        }
        return animais;
    }

    public void atualizar(Animal animal, int id) throws FalhaConexaoException {
        String sql = "UPDATE animal SET nome = ?, idade = ?, som = ?, tipo = ?, caracteristica = ?, id_zoo = ? WHERE id = ?";

        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.get_nome());
            stmt.setInt(2, animal.get_idade());
            stmt.setString(3, animal.get_som());
            stmt.setString(4, animal.get_tipo());
            stmt.setString(5, animal.get_id_caracteristica());
            stmt.setInt(6, animal.get_id_zoo());
            stmt.setInt(7, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao atualizar animal: " + e.getMessage());
        }
    }

    public void deletar(int id) throws FalhaConexaoException {
        String sql = "DELETE FROM animal WHERE id = ?";

        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao deletar animal: " + e.getMessage());
        }
    }

    public Animal criarAnimalDoResultSet(ResultSet rs, String tipo) throws SQLException {
        switch (tipo) {
            case "Mamifero":
                return new Mamifero(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    rs.getString("caracteristica")
                );
            case "Ave":
                // Se for papagaio, poderia criar um Papagaio separadamente, mas como papagaio tem atributos extras, para o DAO geral usa Ave simples
                return new Ave(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    rs.getString("caracteristica")
                );
            case "Reptil":
                return new Reptil(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    rs.getString("caracteristica")
                );
            default:
                return null;
        }
    }
}

