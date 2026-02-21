package com.exemplo.bilbioteca.controller;

import com.exemplo.bilbioteca.dto.EmprestimoRequisicaoDTO;
import com.exemplo.bilbioteca.dto.EmprestimoRespostaDTO;
import com.exemplo.bilbioteca.model.Emprestimo;
import com.exemplo.bilbioteca.model.Usuario;
import com.exemplo.bilbioteca.service.EmprestimoService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/biblioteca")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController (EmprestimoService service) {
        this.service = service;
    }

    @PostMapping("/emprestimo/cadastrar")
    public EmprestimoRespostaDTO postEmprestimo (@RequestBody EmprestimoRequisicaoDTO emprestimoRequisicaoDTO) {
        try {
            return service.cadastrarEmprestimo(emprestimoRequisicaoDTO);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/emprestimo/listar")
    public List<EmprestimoRespostaDTO> getEmprestimos () {
        List<Emprestimo> lista = new ArrayList<>();
        try {
            return service.listarEmprestimos();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
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
    @PutMapping("/emprestimo/{id}/devolucao")
    public boolean putDevolucao (@RequestBody Emprestimo emprestimo, @PathVariable int id){
        try {
            return service.registrarDevolucao(emprestimo.getData_devolucao(), id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping ("/usuarios/{id}/emprestimos")
    public List<Emprestimo> getEmprestimosUser (@PathVariable int id){
        try {
            return service.listarEmprestimosDoUser(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
