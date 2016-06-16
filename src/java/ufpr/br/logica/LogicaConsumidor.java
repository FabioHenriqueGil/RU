/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.logica;

import java.util.List;
import ufpr.br.dao.ConsumidorDao;
import ufpr.br.modelo.Consumidor;
import ufpr.br.modelo.Modalidade;
import ufpr.br.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class LogicaConsumidor implements CadastraConsumidor, BuscaConsumidor {

    private ConsumidorDao dao = new ConsumidorDao();

    @Override
    public Consumidor buscarConsumidor(int id) {
        return dao.buscar(id);
    }

    @Override
    public List<Consumidor> listarConsumidores() {
        return dao.listar();

    }

    @Override
    public List<Consumidor> listarConsumidores(String nome) {
        return dao.listar(nome);

    }

    @Override
    public void cadastrarConsumidor(Consumidor consumidor) {
        dao.inserir(consumidor);
    }

    @Override
    public void alterarConsumidor(Consumidor consumidor) {
        dao.alterar(consumidor);
    }

    @Override
    public Consumidor novoConsumidor(Modalidade modalidade, Vinculo vinculo, String nome, String grr) {
        return new Consumidor(modalidade, vinculo, nome, grr = null);
    }

    @Override
    public void ativaConsumidor(int id) {
        Consumidor c = dao.buscar(id);
        c.setAtivo(true);
        dao.alterar(c);
    }

    @Override
    public void desativaConsumidor(int id) {
        Consumidor c = dao.buscar(id);
        c.setAtivo(false);
        dao.alterar(c);
    }

}
