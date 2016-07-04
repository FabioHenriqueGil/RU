/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class Venda {

    private int id;
    private Checkin checkin;
    private TipoDeReceita tipoDeReceita;
    private Caixa caixa;
    private List<Produto> listaDeProdutos;

    public Venda() {
    }

    public Venda(Checkin checkin, TipoDeReceita tipoDeReceita, Caixa caixa) {
        this.checkin = checkin;
        this.tipoDeReceita = tipoDeReceita;
        this.caixa = caixa;
        this.listaDeProdutos = new ArrayList<>();
    }

    public boolean addProduto(Produto produto) {
        for (Produto produto1 : listaDeProdutos) {
            if (produto.getId() == produto1.getId()) {
                if (produto.getPrecoPadrao() > produto.getPrecoVenda()) {
                    return false;
                }
                produto1.setQtd(produto1.getQtd() + 1);
                return true;
            }

        }
        this.listaDeProdutos.add(produto);
        return true;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Checkin getCheckin() {
        return checkin;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    public TipoDeReceita getTipoDeReceita() {
        return tipoDeReceita;
    }

    public void setTipoDeReceita(TipoDeReceita tipoDeReceita) {
        this.tipoDeReceita = tipoDeReceita;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public double getValorTotal() {
        double valor = 0;
        for (Produto produto : listaDeProdutos) {
            valor = valor + (produto.getPrecoVenda() * produto.getQtd());
        }
        return valor;

    }

    public void removeProduto(int idProduto) {

        for (int i = 0; i < listaDeProdutos.size(); i++) {
            if (listaDeProdutos.get(i).getId() == idProduto) {
                if (listaDeProdutos.get(i).getQtd() > 1) {
                    listaDeProdutos.get(i).setQtd(listaDeProdutos.get(i).getQtd() - 1);
                } else {
                    listaDeProdutos.remove(i);
                }
            }
        }

    }

}
