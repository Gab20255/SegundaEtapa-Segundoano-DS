package Zoologico.src.ProjetoInterface.Classes_DAO;

import Zoologico.src.ProjetoInterface.Conexao.Conexao;
import Zoologico.src.ProjetoInterface.Conexao.FalhaConexaoException;
import Zoologico.src.ProjetoInterface.Classes_de_Animais.Reptil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReptilDAO {

    public void inserir(Reptil reptil) throws FalhaConexaoException {
        String sql = "INSERT INTO Animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, reptil.get_nome());
            ps.setInt(2, reptil.get_idade());
            ps.setString(3, reptil.get_som());
            ps.setString(4, reptil.get_tipo()); // "Reptil"
            ps.setString(5, reptil.get_tipoDeEscama()); // característica específica
            ps.setInt(6, reptil.get_id_zoo());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    reptil.setId(idGerado);
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir Réptil: " + e.getMessage());
        }
    }

    public List<Reptil> listarTodos() throws FalhaConexaoException {
        List<Reptil> repteis = new ArrayList<>();
        String sql = "SELECT * FROM Animal WHERE tipo = 'Reptil'";

        try (Connection conn = Conexao.obtemConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Reptil r = new Reptil(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    rs.getString("caracteristica") // tipoDeEscama
                );
                r.setId(rs.getInt("id"));
                r.set_id_zoo(rs.getInt("id_zoo"));
                repteis.add(r);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar Répteis: " + e.getMessage());
        }
        return repteis;
    }

    public void atualizar(Reptil reptil) throws FalhaConexaoException {
        String sql = "UPDATE Animal SET nome = ?, idade = ?, som = ?, caracteristica = ?, id_zoo = ? WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, reptil.get_nome());
            ps.setInt(2, reptil.get_idade());
            ps.setString(3, reptil.get_som());
            ps.setString(4, reptil.get_tipoDeEscama());
            ps.setInt(5, reptil.get_id_zoo());
            ps.setInt(6, reptil.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao atualizar Réptil: " + e.getMessage());
        }
    }

    public void deletar(int id) throws FalhaConexaoException {
        String sql = "DELETE FROM Animal WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao deletar Réptil: " + e.getMessage());
        }
    }
}
