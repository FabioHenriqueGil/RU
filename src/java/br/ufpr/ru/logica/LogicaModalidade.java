/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import java.util.List;
import br.ufpr.ru.dao.ModalidadeDao;
import br.ufpr.ru.modelo.Modalidade;

/**
 *
 * @author fabio
 */
public class LogicaModalidade implements CrudModalidade {

    private ModalidadeDao dao = new ModalidadeDao();

    @Override
    public void cadastraModalidade(Modalidade modalidade) {
        modalidade.setAtivo(true);
        dao.inserir(modalidade);
    }

    @Override
    public void alteraModalidade(Modalidade modalidade) {        
        dao.alterar(modalidade);
    }

    @Override
    public void ativaModalidade(int id) {
        Modalidade m = dao.buscar(id);
        m.setAtivo(true);
        dao.alterar(m);

    }

    @Override
    public void desativaModalidade(int id) {
        Modalidade m = dao.buscar(id);
        m.setAtivo(false);
        dao.alterar(m);
    }

    @Override
    public Modalidade buscaModalidade(int id) {
        return dao.buscar(id);
    }

    @Override
    public List<Modalidade> lista() {
        return dao.listar();
    }

    @Override
    public List<Modalidade> lista(String descricao) {
        return dao.listar(descricao);
    }

}
