/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.TipoDeReceitaDao;
import br.ufpr.ru.modelo.TipoDeReceita;
import java.util.List;

/**
 *
 * @author fabio
 */
public class LogicaTipoDeReceita implements CrudTipoDeReceita {

    TipoDeReceitaDao dao = new TipoDeReceitaDao();

    @Override
    public void cadastraTipoDeReceita(TipoDeReceita tipoDeReceita) {
        dao.inserir(tipoDeReceita);
    }

    @Override
    public void alteraTipoDeReceita(TipoDeReceita tipoDeReceita) {
        dao.alterar(tipoDeReceita);
    }

    @Override
    public TipoDeReceita buscaTipoDeReceita(int id) {
        return dao.buscar(id);
    }

    @Override
    public List<TipoDeReceita> lista() {
        return dao.listar();
    }

}
