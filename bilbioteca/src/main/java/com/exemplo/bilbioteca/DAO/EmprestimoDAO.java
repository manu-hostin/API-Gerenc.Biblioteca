package com.exemplo.bilbioteca.DAO;

import com.exemplo.bilbioteca.conexao.Conexao;
import com.exemplo.bilbioteca.controller.EmprestimoController;
import com.exemplo.bilbioteca.model.Emprestimo;
import com.exemplo.bilbioteca.model.Livro;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmprestimoDAO {


    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String query = "INSERT INTO emprestimo (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setInt(2, emprestimo.getUsuario_id());
            stmt.setDate(3, java.sql.Date.valueOf(emprestimo.getData_emprestimo()));
            stmt.setDate(4, java.sql.Date.valueOf(emprestimo.getData_devolucao()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                emprestimo.setId(rs.getInt(1));
                return emprestimo;
            }
        }
        return null;
    }

    public List<Emprestimo> listarEmprestimos() throws SQLException {
        String query = "SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao FROM emprestimo";

        List<Emprestimo> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Emprestimo emp = new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("livro_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao").toLocalDate()
                );
                lista.add(emp);
            }
        }
        return lista;
    }
    public List<Emprestimo> listarEmprestimosID(int id) throws SQLException {
        String query = "SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao FROM emprestimo WHERE id = ?";

        List<Emprestimo> lista = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Emprestimo emp = new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("livro_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao").toLocalDate()
                );
                lista.add(emp);
            }
        }
        return lista;
    }

    public boolean atualizarEmprestimo(Emprestimo emprestimo, int id) throws SQLException{
        String query = "UPDATE emprestimo SET livro_id = ?, usuario_id = ?, data_emprestimo = ?, data_devolucao = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setInt(2, emprestimo.getUsuario_id());
            stmt.setDate(3, java.sql.Date.valueOf(emprestimo.getData_emprestimo()));
            stmt.setDate(4, java.sql.Date.valueOf(emprestimo.getData_devolucao()));
            stmt.setInt(5, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            }
        }
        return false;
    }
}
