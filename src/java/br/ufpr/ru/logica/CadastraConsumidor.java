/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public interface CadastraConsumidor {

    Consumidor novoConsumidor(Modalidade modalidade, Vinculo vinculo, String nome, String grr);

    void cadastrarConsumidor(Consumidor consumidor);

    void alterarConsumidor(Consumidor consumidor);

    void ativaConsumidor(int id);

    void desativaConsumidor(int id);
}
