/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author fabio
 */
@Entity
public class Credito {
    @Id
    @GeneratedValue
    private int id;
    private double saldo;

    public Credito() {

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
