package com.exemplo.bilbioteca.controller;

import com.exemplo.bilbioteca.model.Emprestimo;
import com.exemplo.bilbioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

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


}
