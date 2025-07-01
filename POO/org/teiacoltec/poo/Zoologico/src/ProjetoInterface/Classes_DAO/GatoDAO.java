package ProjetoInterface.Classes_DAO;

import ProjetoInterface.Sub_Classes.Gato;
import ProjetoInterface.Classes_de_Animais.Mamifero;
import ProjetoInterface.Conexao.Conexao;
import ProjetoInterface.Conexao.FalhaConexaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GatoDAO {

    public void inserir(Gato gato) throws FalhaConexaoException {
        String sql = "INSERT INTO Animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, gato.get_nome());
            ps.setInt(2, gato.get_idade());
            ps.setString(3, gato.get_som());
            ps.setString(4, "Gato");  // Ou "Mamifero" se preferir
            ps.setString(5, gato.get_olho()); // caracteristica = olho
            ps.setInt(6, gato.get_id_zoo());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    gato.setId(idGerado);
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir Gato: " + e.getMessage());
        }
    }

    public List<Gato> listarTodos() throws FalhaConexaoException {
        List<Gato> gatos = new ArrayList<>();
        String sql = "SELECT * FROM Animal WHERE tipo = 'Gato'";

        try (Connection conn = Conexao.obtemConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Gato g = new Gato(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    "", // tipoDePelo? Aqui teria que ajustar se necessário
                    rs.getString("caracteristica") // olho
                );
                g.setId(rs.getInt("id"));
                g.set_id_zoo(rs.getInt("id_zoo"));
                gatos.add(g);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar Gatos: " + e.getMessage());
        }
        return gatos;
    }

    public void atualizar(Mamifero mamifero) throws FalhaConexaoException {
        String sql = "UPDATE Animal SET nome = ?, idade = ?, som = ?, caracteristica = ?, id_zoo = ? WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mamifero.get_nome());
            ps.setInt(2, mamifero.get_idade());
            ps.setString(3, mamifero.get_som());
            ps.setString(4, mamifero.getTipoDePelo());
            ps.setInt(5, mamifero.get_id_zoo());
            ps.setInt(6, mamifero.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao atualizar Mamífero: " + e.getMessage());
        }
    }

    public void deletar(int id) throws FalhaConexaoException {
        String sql = "DELETE FROM Animal WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao deletar Mamífero: " + e.getMessage());
        }
    }
}

