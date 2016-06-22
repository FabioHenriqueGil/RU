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
public class Credito {
    private int id;
    private double saldo;

    public Credito() {
        this.saldo = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposita(double valor) {
        setSaldo(getSaldo() + valor);
    }

    public void saca(double valor) {
        setSaldo(getSaldo() - valor);
    }

}
