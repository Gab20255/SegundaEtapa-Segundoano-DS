package ProjetoInterface;

import java.sql.*;
import java.util.ArrayList;

public class ZoologicoDAO {

    public void inserir(Zoologico zoo) throws FalhaConexaoException {
        String sql = "INSERT INTO zoologico (id_zoo) VALUES (?)";

        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, zoo.get_id_zoo());
            stmt.executeUpdate();

            AnimalDAO animalDAO = new AnimalDAO();
            for (Animal a : zoo.animais) {
                animalDAO.inserir(a);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir zoológico: " + e.getMessage());
        }
    }

    public Zoologico buscarPorId(int id_zoo) throws FalhaConexaoException {
        String sqlZoo = "SELECT * FROM zoologico WHERE id_zoo = ?";
        Zoologico zoo = null;

        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement stmtZoo = conn.prepareStatement(sqlZoo)) {

            stmtZoo.setInt(1, id_zoo);
            ResultSet rsZoo = stmtZoo.executeQuery();

            if (rsZoo.next()) {
                zoo = new Zoologico(id_zoo);

                String sqlAnimais = "SELECT * FROM animal WHERE id_zoo = ?";
                PreparedStatement stmtAnimais = conn.prepareStatement(sqlAnimais);
                stmtAnimais.setInt(1, id_zoo);
                ResultSet rsAnimais = stmtAnimais.executeQuery();

                AnimalDAO animalDAO = new AnimalDAO();
                while (rsAnimais.next()) {
                    String tipo = rsAnimais.getString("tipo");
                    Animal a = animalDAO.criarAnimalDoResultSet(rsAnimais, tipo);
                    if (a != null) {
                        a.set_id_zoo(id_zoo);
                        zoo.animais.add(a);
                    }
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao buscar zoológico: " + e.getMessage());
        }
        return zoo;
    }

    public void deletar(int id_zoo) throws FalhaConexaoException {
        String sqlAnimais = "DELETE FROM animal WHERE id_zoo = ?";
        String sqlZoo = "DELETE FROM zoologico WHERE id_zoo = ?";

        try (Connection conn = Conexao.obtemConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmtAnimais = conn.prepareStatement(sqlAnimais);
                 PreparedStatement stmtZoo = conn.prepareStatement(sqlZoo)) {

                stmtAnimais.setInt(1, id_zoo);
                stmtAnimais.executeUpdate();

                stmtZoo.setInt(1, id_zoo);
                stmtZoo.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao deletar zoológico: " + e.getMessage());
        }
    }
}

