/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.VendaDao;
import br.ufpr.ru.modelo.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabio
 */
@Service
public class LogicaVenda implements CrudVenda {

    VendaDao dao;

    @Autowired
    public LogicaVenda(VendaDao dao) {

        this.dao = dao;
    }

    @Override
    public void cadastraVenda(Venda venda) {
        dao.inserir(venda);
    }

    @Override
    public void alteraVenda(Venda venda) {
        dao.alterar(venda);
    }

    public Venda buscaVenda(Integer idVenda) {
        return dao.buscar(idVenda);
    }

}
