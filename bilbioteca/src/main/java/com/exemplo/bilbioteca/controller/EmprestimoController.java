package com.exemplo.bilbioteca.controller;

import com.exemplo.bilbioteca.model.Emprestimo;
import com.exemplo.bilbioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping("/emprestimo/cadastrar")
    public Emprestimo postEmprestimo (@RequestBody Emprestimo emprestimo) {
        try {
            emprestimo = service.cadastrarEmprestimo(emprestimo);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return emprestimo;
    }

    @GetMapping("/emprestimo/listar")
    public List<Emprestimo> getEmprestimos () {
        List<Emprestimo> lista = new ArrayList<>();
        try {
            lista = service.listarEmprestimos();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return lista;
    }

    @GetMapping("/emprestimo/listar/{id}")
    public List<Emprestimo> getEmprestimos (@PathVariable int id) {
        List<Emprestimo> lista = new ArrayList<>();
        try {
            lista = service.listarEmprestimosID(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return lista;
    }

    @PutMapping("/emprestimo/atualizar/{id}")
    public boolean putEmprestimos (@RequestBody Emprestimo emprestimo, @PathVariable int id){
        try {
            return service.atualizarEmprestimo(emprestimo, id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/emprestimo/deletar/{id}")
    public boolean deleteEmprestimo (@PathVariable int id){
        try {
            return service.deletarEmprestimo(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
