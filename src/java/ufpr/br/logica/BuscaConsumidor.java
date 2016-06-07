/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.logica;

import ufpr.br.modelo.Consumidor;

/**
 *
 * @author fabio
 */
public interface BuscaConsumidor {
    
    Consumidor buscarConsumidor(int id);
    
    Consumidor buscarConsumidor(String nome);
    
}
