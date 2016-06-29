/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.modelo;

import java.util.Calendar;

/**
 *
 * @author fabio
 */
public class Checkin {
    private int id;
    private Consumidor consumidor;
    private Calendar data;

    public Checkin() {
    }

    public Checkin(Consumidor consumidor, Calendar data) {
        this.consumidor = consumidor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    
    
    
}
