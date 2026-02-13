package com.weg.olamundo.repository;

import com.weg.olamundo.Conexao.Conexao;
import com.weg.olamundo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {


    public List<Usuario> listarUser () throws SQLException {
        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT id, nome, email FROM `User`";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email")
                    );
                    lista.add(usuario);
                }
        }
        return lista;
    }

    public Usuario salvarUser (Usuario user) throws SQLException {
        String sql = "INSERT INTO User (nome, email) VALUES (?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                user.setId(rs.getInt(1));
                return user;
            }
        }
        return null;
    }

    public void atualizarUsuario (Usuario user) throws SQLException { // Não precisa passar o ID também, pq isso fazemos no service
        // Aqui continua com throws normal
        String sql = "UPDATE User SET nome = ?, email = ? WHERE id = ? ";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());

            stmt.executeUpdate();
        }
    }

    public Usuario buscarCttPorID(int id) throws SQLException {

        String sql = "SELECT nome, email FROM User WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario user = new Usuario(
                        id,
                        rs.getString("nome"),
                        rs.getString("email"));
                return user;
            }
        }
        return null;
    }

    public void deletarCttPorID(int id) throws SQLException {
        String sql = "DELETE FROM User WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        }
    }

    public boolean contatoExiste(int id) throws SQLException {
            String sql = "SELECT id FROM `User` WHERE id = ?";

            try (Connection conn = Conexao.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return true;
                }
            }
            return false;
        }

}
