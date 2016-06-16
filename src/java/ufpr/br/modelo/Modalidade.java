/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class Modalidade {

    private int id;
    private String descricao;
    List<Vinculo> vinculosBloqueados;
    boolean ativo = true;

    public Modalidade(String descricao, List<Vinculo> vb) {
        this.descricao = descricao;
        this.vinculosBloqueados = vb;
    }

    public Modalidade(String descricao) {
        this.descricao = descricao;
        this.vinculosBloqueados = new ArrayList<>();
    }

    public Modalidade() {
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vinculo> getVinculosBloqueados() {
        return vinculosBloqueados;
    }

    public void setVinculosBloqueados(List<Vinculo> vinculosBloqueados) {
        this.vinculosBloqueados = vinculosBloqueados;
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
