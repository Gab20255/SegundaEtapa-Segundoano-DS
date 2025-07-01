package ProjetoInterface.Classes_DAO;

import ProjetoInterface.Zoologico;
import ProjetoInterface.Conexao.Conexao;
import ProjetoInterface.Conexao.FalhaConexaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZoologicoDAO {

    // Insere um Zoologico na tabela 'Zoologico'
    public void inserir(Zoologico zoo) throws FalhaConexaoException {
        String sql = "INSERT INTO Zoologico (id) VALUES (?)";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, zoo.get_id_zoo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir Zoologico: " + e.getMessage());
        }
    }

    // Busca Zoologico pelo id
    public Zoologico buscarPorId(int id) throws FalhaConexaoException {
        String sql = "SELECT * FROM Zoologico WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Zoologico(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao buscar Zoologico: " + e.getMessage());
        }
        return null; // se não encontrar
    }

    // Lista todos os zoologicos
    public List<Zoologico> listarTodos() throws FalhaConexaoException {
        List<Zoologico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Zoologico";
        try (Connection conn = Conexao.obtemConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Zoologico(rs.getInt("id")));
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar Zoologicos: " + e.getMessage());
        }
        return lista;
    }

    // Remove zoologico pelo id
    public void remover(int id) throws FalhaConexaoException {
        String sql = "DELETE FROM Zoologico WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao remover Zoologico: " + e.getMessage());
        }
    }

    // Opcional: Método para atualizar o id do zoologico (se necessário)
    public void atualizar(Zoologico zoo) throws FalhaConexaoException {
        String sql = "UPDATE Zoologico SET id = ? WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, zoo.get_id_zoo());
            ps.setInt(2, zoo.get_id_zoo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao atualizar Zoologico: " + e.getMessage());
        }
    }
    public void salvar(Zoologico zoo) throws FalhaConexaoException {
        String sql = "INSERT INTO zoologico (id_zoo) VALUES (?)";

        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, zoo.get_id_zoo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar Zoológico: " + e.getMessage());
        }
    }
}

