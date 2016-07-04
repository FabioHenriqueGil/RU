/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.ConsumidorDao;
import br.ufpr.ru.dao.ModalidadeDao;
import br.ufpr.ru.dao.VinculoDao;
import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.logica.LogicaModalidade;
import br.ufpr.ru.logica.LogicaConsumidor;
import org.junit.Test;
import br.ufpr.ru.modelo.Consumidor;
import java.sql.Connection;

/**
 *
 * @author fabio
 */
public class LogicaConsumidorTeste {
    private ConsumidorDao consumidorDao;
    @Test
    public void teste() {
        
        System.out.println("br.ufpr.ru.logica.LogicaConsumidorTeste.teste() ffffff");
        
        LogicaConsumidor lc = new LogicaConsumidor(consumidorDao);
        
        Consumidor c = new Consumidor();
        
         
        c.deposita(304);
        
        c.setNome("DANIEL ANTONIO KARLING");
        
        lc.alterarConsumidor(c);
        System.out.println(c.getId());
        System.out.println(lc.buscarConsumidor(9).getNome());
        System.out.println(lc.buscarConsumidor(9).getCredito().getSaldo());
        
        
       
        
        
        
        
        
                
    }
}
