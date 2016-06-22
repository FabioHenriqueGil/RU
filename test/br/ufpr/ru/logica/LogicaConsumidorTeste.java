/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.logica.LogicaVinculo;
import br.ufpr.ru.logica.LogicaModalidade;
import br.ufpr.ru.logica.LogicaConsumidor;
import org.junit.Test;
import br.ufpr.ru.modelo.Consumidor;

/**
 *
 * @author fabio
 */
public class LogicaConsumidorTeste {
    
    @Test
    public void teste() {
        LogicaConsumidor lc = new LogicaConsumidor();
        LogicaModalidade lm = new LogicaModalidade();
        LogicaVinculo lv = new LogicaVinculo();
                
        Consumidor c = lc.buscarConsumidor(6);
        
         
        c.deposita(304);
        c.saca(4);
        c.setNome("Fabio Henrique Gil");
        
        lc.alterarConsumidor(c);
        System.out.println(c.getId());
        System.out.println(lc.buscarConsumidor(6).getNome());
        System.out.println(lc.buscarConsumidor(6).getCredito().getSaldo());
        
        
        
        lc.desativaConsumidor(4);
        
        
        
        
        
                
    }
}
