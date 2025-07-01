package ProjetoInterface.Classes_DAO;

import ProjetoInterface.Sub_Classes.Cachorro;
import ProjetoInterface.Classes_de_Animais.Mamifero;
import ProjetoInterface.Conexao.Conexao;
import ProjetoInterface.Conexao.FalhaConexaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CachorroDAO {

    public void inserir(Cachorro cachorro) throws FalhaConexaoException {
        String sql = "INSERT INTO Animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cachorro.get_nome());
            ps.setInt(2, cachorro.get_idade());
            ps.setString(3, cachorro.get_som());
            ps.setString(4, "Cachorro");  // Ou "Mamifero" se preferir
            ps.setString(5, cachorro.get_raca()); // caracteristica = raça
            ps.setInt(6, cachorro.get_id_zoo());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    cachorro.setId(idGerado);
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir Cachorro: " + e.getMessage());
        }
    }

    public List<Cachorro> listarTodos() throws FalhaConexaoException {
        List<Cachorro> cachorros = new ArrayList<>();
        String sql = "SELECT * FROM Animal WHERE tipo = 'Cachorro'";

        try (Connection conn = Conexao.obtemConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cachorro c = new Cachorro(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    "", // tipoDePelo? Ajuste aqui se precisar
                    rs.getString("caracteristica") // raça
                );
                c.setId(rs.getInt("id"));
                c.set_id_zoo(rs.getInt("id_zoo"));
                cachorros.add(c);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar Cachorros: " + e.getMessage());
        }
        return cachorros;
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

