package com.exemplo.bilbioteca.DAO;

import com.exemplo.bilbioteca.conexao.Conexao;
import com.exemplo.bilbioteca.model.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDAO {

    public Usuario cadastrarUsuario(Usuario user) throws SQLException {
        String query = "INSERT INTO usuario (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                user.setId(rs.getInt(1));
                return user;
            }
        }
        return null;
    }

    public List<Usuario> listarUsuarios () throws SQLException {
        String query = "SELECT id, nome, email FROM usuario";

        List<Usuario> users = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"));
                users.add(user);
            }
        }
        return users;
    }

    public Usuario listarUsuarioID(int id) throws SQLException {
        String query = "SELECT id, nome, email FROM usuario WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            // Não precisa de executeUpdate pq n esta inserindo nada
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"));
            }
        }
        return null;
    }

    public boolean atualizarUsuarios(Usuario user, int id) throws SQLException {
        String query = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean deletarUser(int id) throws SQLException {
        String query = "DELETE FROM usuario WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            }
        }
        return false;

    }
}
