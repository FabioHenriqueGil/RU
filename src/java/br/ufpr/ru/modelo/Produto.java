/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.modelo;

/**
 *
 * @author fabio
 */
public class Produto {
    
     private int id;
    private String descricao;
    private double precoPadrao;
    private double precoVenda;

    public Produto( String descricao, double precoPadrao) {
        this.descricao = descricao;
        this.precoPadrao = precoPadrao;

    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoPadrao() {
        return precoPadrao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoPadrao(double precoPadrao) {
        this.precoPadrao = precoPadrao;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    
    
}
