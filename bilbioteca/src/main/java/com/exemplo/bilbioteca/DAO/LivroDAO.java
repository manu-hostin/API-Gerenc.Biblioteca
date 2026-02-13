package com.exemplo.bilbioteca.DAO;

import com.exemplo.bilbioteca.conexao.Conexao;
import com.exemplo.bilbioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroDAO {

    public Livro cadastrarLivro (Livro livro) throws SQLException {
        String query = "INSERT INTO livro (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, livro.getAutor());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                livro.setId(rs.getInt(1));
                return livro;
            }
        }
        return null;
    }

    public List<Livro> obterLivros () throws SQLException {
        String query = "SELECT id, titulo, autor, ano_publicacao FROM livro";

        List<Livro> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao"));
                lista.add(livro);
            }
        }
        return lista;
    }

    public Livro obterLivroByID (int id) throws SQLException {
        String query = "SELECT titulo, autor, ano_publicacao FROM livro WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Livro (
                        id,
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano_publicacao")
                );

            }
        }
        return null;
    }

    public boolean atualizarLivro(int id, Livro livro) throws SQLException {
        String query = "UPDATE livro SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            stmt.setInt(4, id);

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas > 0){
                return true;
            }
        }
        return false;
    }

    public boolean deletarLivro(int id) throws SQLException {
        String query = "DELETE FROM livro WHERE id = ?";

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
