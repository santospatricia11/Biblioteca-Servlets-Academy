package dao;

import dao.util.Conexao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Usuario;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsuarioDao {

    private Connection connection;

    private void conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = Conexao.getConexao();
        }
    }

    private void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Usuario inserirUsuario(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO usuario (nome, email,password) " + " VALUES (?, ?, ?)";

        conectar();

        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getPassword());

        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();
       long id = 0;
        if(resultSet.next())
            id = resultSet.getInt("id");
        statement.close();

        desconectar();

        usuario.setID(id);
        return usuario;
    }



}
