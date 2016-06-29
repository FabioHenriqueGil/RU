/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.VendaDao;
import br.ufpr.ru.modelo.Venda;

/**
 *
 * @author fabio
 */
public class LogicaVenda implements CrudVenda {

    VendaDao dao = new VendaDao();

    @Override
    public void cadastraVenda(Venda venda) {
        dao.inserir(venda);
    }

    @Override
    public void alteraVenda(Venda venda) {
        dao.alterar(venda);
    }

}
