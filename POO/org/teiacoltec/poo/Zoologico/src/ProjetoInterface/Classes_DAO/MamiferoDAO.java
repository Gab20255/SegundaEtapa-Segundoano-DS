package ProjetoInterface.Classes_DAO;

import ProjetoInterface.Classes_de_Animais.Mamifero;
import ProjetoInterface.Conexao.Conexao;
import ProjetoInterface.Conexao.FalhaConexaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MamiferoDAO {

    public void inserir(Mamifero mamifero) throws FalhaConexaoException {
        String sql = "INSERT INTO Animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, mamifero.get_nome());
            ps.setInt(2, mamifero.get_idade());
            ps.setString(3, mamifero.get_som());
            ps.setString(4, mamifero.get_tipo()); // deve ser "Mamifero"
            ps.setString(5, mamifero.getTipoDePelo()); // característica específica
            ps.setInt(6, mamifero.get_id_zoo());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    mamifero.setId(idGerado);
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir Mamífero: " + e.getMessage());
        }
    }

    public List<Mamifero> listarTodos() throws FalhaConexaoException {
        List<Mamifero> mamiferos = new ArrayList<>();
        String sql = "SELECT * FROM Animal WHERE tipo = 'Mamifero'";

        try (Connection conn = Conexao.obtemConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mamifero m = new Mamifero(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    rs.getString("caracteristica") // tipoDePelo armazenado aqui
                );
                m.setId(rs.getInt("id"));
                m.set_id_zoo(rs.getInt("id_zoo"));
                mamiferos.add(m);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar Mamíferos: " + e.getMessage());
        }
        return mamiferos;
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
