/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import java.util.List;
import br.ufpr.ru.modelo.Consumidor;

/**
 *
 * @author fabio
 */
public interface BuscaConsumidor {
    
    Consumidor buscarConsumidor(int id);
    
    List<Consumidor> listarConsumidores();
    
    List<Consumidor> listarConsumidoresAtivos();
    
    List<Consumidor> listarConsumidores(String nome);
    
}
