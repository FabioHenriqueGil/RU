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
public class VendaItem {
    private Venda venda;
    private Produto produto;
    private int qtd;
    private double precoUnit;

    public VendaItem() {
    }

    public VendaItem(Venda venda, Produto produto, int qtd, double precoUnit) {
        this.venda = venda;
        this.produto = produto;
        this.qtd = qtd;
        this.precoUnit = precoUnit;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }
    
    
    
    
    
}
