package ProjetoInterface.Classes_DAO;

import ProjetoInterface.Classes_de_Animais.Ave;
import ProjetoInterface.Conexao.Conexao;
import ProjetoInterface.Conexao.FalhaConexaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AveDAO {

    public void inserir(Ave ave) throws FalhaConexaoException {
        String sql = "INSERT INTO Animal (nome, idade, som, tipo, caracteristica, id_zoo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, ave.get_nome());
            ps.setInt(2, ave.get_idade());
            ps.setString(3, ave.get_som());
            ps.setString(4, ave.get_tipo());  // deve ser "Ave"
            ps.setString(5, String.valueOf(ave.get_Envergadura())); // característica armazenada como string
            ps.setInt(6, ave.get_id_zoo());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    ave.setId(idGerado);
                }
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao inserir Ave: " + e.getMessage());
        }
    }

    public List<Ave> listarTodos() throws FalhaConexaoException {
        List<Ave> aves = new ArrayList<>();
        String sql = "SELECT * FROM Animal WHERE tipo = 'Ave'";

        try (Connection conn = Conexao.obtemConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ave a = new Ave(
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("som"),
                    Double.parseDouble(rs.getString("caracteristica"))  // converte string para double
                );
                a.setId(rs.getInt("id"));
                a.set_id_zoo(rs.getInt("id_zoo"));
                aves.add(a);
            }
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao listar Aves: " + e.getMessage());
        }
        return aves;
    }

    public void atualizar(Ave ave) throws FalhaConexaoException {
        String sql = "UPDATE Animal SET nome = ?, idade = ?, som = ?, caracteristica = ?, id_zoo = ? WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ave.get_nome());
            ps.setInt(2, ave.get_idade());
            ps.setString(3, ave.get_som());
            ps.setString(4, String.valueOf(ave.get_Envergadura()));
            ps.setInt(5, ave.get_id_zoo());
            ps.setInt(6, ave.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao atualizar Ave: " + e.getMessage());
        }
    }

    public void deletar(int id) throws FalhaConexaoException {
        String sql = "DELETE FROM Animal WHERE id = ?";
        try (Connection conn = Conexao.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new FalhaConexaoException("Erro ao deletar Ave: " + e.getMessage());
        }
    }
}
