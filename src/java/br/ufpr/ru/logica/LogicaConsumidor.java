/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import java.util.List;
import br.ufpr.ru.dao.ConsumidorDao;
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabio
 */

@Service
public class LogicaConsumidor implements CadastraConsumidor, BuscaConsumidor {

    private ConsumidorDao dao ;
@Autowired
    public LogicaConsumidor(ConsumidorDao dao) {
        
        this.dao = dao;
    }
    
    
 
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
        consumidor.setAtivo(true);
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

    @Override
    public List<Consumidor> listarConsumidoresAtivos() {
        return dao.listarAtivos();
    }

}
