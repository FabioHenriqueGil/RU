/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.CaixaDao;
import br.ufpr.ru.modelo.Caixa;
import java.util.List;

/**
 *
 * @author fabio
 */
public class LogicaCaixa implements CrudCaixa {

    CaixaDao dao = new CaixaDao();

    @Override
    public void cadastraCaixa(Caixa caixa) {
        dao.inserir(caixa);
    }

    @Override
    public Caixa buscaCaixa(int id) {
        return dao.buscar(id);
    }

    @Override
    public double consultaSaldo(int id) {
        return dao.buscar(id).getSaldo();
    }

    @Override
    public void deposita(Caixa caixa, double valor) {
        double saldo = dao.buscar(caixa.getId()).getSaldo();
        saldo = saldo + valor;
        caixa.setSaldo(saldo);
        dao.alterar(caixa);
    }

    @Override
    public boolean saca(Caixa caixa, double valor) {
        double saldo = dao.buscar(caixa.getId()).getSaldo();
        if (saldo >= valor) {
            saldo = saldo - valor;
            caixa.setSaldo(saldo);
            dao.alterar(caixa);
            return true;
        }
        return false;
    }

    public List<Caixa> lista() {
        return dao.listar();
    }

}
