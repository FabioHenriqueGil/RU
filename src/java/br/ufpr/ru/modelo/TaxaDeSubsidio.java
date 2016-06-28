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
public class TaxaDeSubsidio {
    Modalidade modalidade;
    Produto produto;
    double desconto;

    public TaxaDeSubsidio(Modalidade modalidade, Produto produto, double desconto) {
        this.modalidade = modalidade;
        this.produto = produto;
        this.desconto = desconto;
    }

    public TaxaDeSubsidio() {
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    
    
}
