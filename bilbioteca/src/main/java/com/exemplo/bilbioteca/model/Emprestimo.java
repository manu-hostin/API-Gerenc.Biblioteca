package com.exemplo.bilbioteca.model;

public class Emprestimo {

    private int id;
    private int livro_id;
    private int usuario_id;
    private int data_emprestimo;
    private int data_devolucao;
    public Emprestimo() {
    }
    public Emprestimo(int id, int livro_id, int usuario_id, int data_emprestimo, int data_devolucao) {
        this.id = id;
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(int data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public int getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(int data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
