/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.logica;

import ufpr.br.modelo.Consumidor;
import ufpr.br.modelo.Modalidade;
import ufpr.br.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class LogicaConsumidor implements CadastraConsumidor, BuscaConsumidor {

    @Override
    public Consumidor buscarConsumidor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consumidor buscarConsumidor(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastrarConsumidor(Consumidor consumidor) {
        
    }

    @Override
    public void alterarConsumidor(Consumidor consumidor) {

    }

    @Override
    public Consumidor novoConsumidor(Modalidade modalidade, Vinculo vinculo, String nome, String grr) {

        return new Consumidor(modalidade, vinculo, nome, grr = null);

    }
}
