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
public interface CadastraConsumidor {

    Consumidor novoConsumidor(Modalidade modalidade, Vinculo vinculo, String nome, String grr);
    
    void cadastrarConsumidor(Consumidor consumidor);

    void alterarConsumidor(Consumidor consumidor);
}
