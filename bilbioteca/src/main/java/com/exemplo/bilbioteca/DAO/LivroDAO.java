package com.exemplo.bilbioteca.DAO;

import com.exemplo.bilbioteca.conexao.Conexao;
import com.exemplo.bilbioteca.model.Livro;

import java.sql.*;

public class LivroDAO {

    public Livro cadastrarLivro (Livro livro) throws SQLException {
        String query = "INSERT INTO livro (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, livro.getAutor());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            ResultSet rs = stmt.getGeneratedKeys();
            stmt.executeUpdate();

            if (rs.next()) {
                livro.setId(rs.getInt(1));
                return livro;
            }
        }
        return null;
    }
}
