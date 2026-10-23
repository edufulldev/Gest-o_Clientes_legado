package edu.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefone());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente buscarPorId(Long id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                if(rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    return cliente;
                }
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try(Connection conm = ConnectionFactory.getConnection();
        PreparedStatement statement = conm.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefone());
            statement.setLong(4, cliente.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
