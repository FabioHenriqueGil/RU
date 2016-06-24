/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.ProdutoDao;
import java.util.List;
import br.ufpr.ru.modelo.Produto;

/**
 *
 * @author fabio
 */
public class LogicaProduto implements CrudProduto {

    private ProdutoDao dao = new ProdutoDao();

    @Override
    public void cadastraVinculo(Produto produto) {
        dao.inserir(produto);
    }

    @Override
    public void alteraProduto(Produto produto) {
        dao.alterar(produto);
    }

    @Override
    public void ativaProduto(int id) {
        Produto p = this.buscaProduto(id);
        p.setAtivo(true);
        dao.alterar(p);
    }

    @Override
    public void desativaProduto(int id) {
        Produto p = this.buscaProduto(id);
        p.setAtivo(false);
        dao.alterar(p);
    }

    @Override
    public Produto buscaProduto(int id) {
        return dao.buscar(id);
    }

    @Override
    public List<Produto> listaAtivos() {
        return dao.listarAtivos();
    }

    @Override
    public List<Produto> lista() {
        return dao.listar();
    }

    @Override
    public List<Produto> lista(String filtro) {
        return dao.listar(filtro);
    }

}
