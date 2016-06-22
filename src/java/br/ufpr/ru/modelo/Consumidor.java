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
public class Consumidor {

    private int id;
    private String nome;
    private String grr;
    private Vinculo vinculo;
    private Modalidade modalidade;
    private Credito credito;
    boolean ativo = false;

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

    public Consumidor(int id) {
        this.credito = new Credito();
        this.id = id;
    }

    public Consumidor() {
        this.credito = new Credito();

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

    public void saca(double valor) {
        this.credito.saca(valor);
    }

    public void deposita(double valor) {
        this.credito.deposita(valor);

    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }
}
