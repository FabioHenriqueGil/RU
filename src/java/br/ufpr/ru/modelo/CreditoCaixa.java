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
public class CreditoCaixa {

    private Credito credito;
    private Caixa caixa;
    private double valor;
    private boolean inserir;

    public CreditoCaixa() {
    }

    public CreditoCaixa(Credito credito, Caixa caixa, double valor, boolean inserir) {
        this.credito = credito;
        this.caixa = caixa;
        this.valor = valor;
        this.inserir = inserir;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isInserir() {
        return inserir;
    }

    public void setInserir(boolean inserir) {
        this.inserir = inserir;
    }

}
