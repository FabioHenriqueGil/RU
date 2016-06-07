/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author fabio
 */
@Entity 
public class Consumidor {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String grr;
    @ManyToOne(cascade = javax.persistence.CascadeType.PERSIST)
    private Vinculo vinculo;
    @ManyToOne(cascade = javax.persistence.CascadeType.PERSIST)
    private Modalidade modalidade;
    @OneToOne(cascade = javax.persistence.CascadeType.ALL)
    private Credito credito;
    
    public Consumidor(Modalidade modalidade, Vinculo vinculo, String nome) {
        this.credito = new Credito();
        this.modalidade = modalidade;
        this.vinculo = vinculo;
        this.nome = nome;

    }

    public Consumidor(Modalidade modalidade, Vinculo vinculo, String nome, String grr) {
        this.credito = new Credito();
        this.modalidade = modalidade;
        this.vinculo = vinculo;
        this.nome = nome;
        this.grr = grr;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGrr() {
        return grr;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public Credito getCredito() {
        return credito;
    }

}
