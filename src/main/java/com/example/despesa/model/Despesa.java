package com.example.despesa.model;

import org.springframework.cglib.core.Local;


public class Despesa {

    private int id;
    private String nome;
    private int preco;
    private int idCategoria;
    private String descricao;

    public Despesa(int id, String nome, int preco, int idCategoria, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public Despesa() {

    }

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int categoria) {
        this.idCategoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
