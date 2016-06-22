/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.logica.LogicaVinculo;
import org.junit.Test;
import br.ufpr.ru.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class LogicaVinculoTeste {
    
    @Test
    public void teste() {
        LogicaVinculo lv = new LogicaVinculo();
        
        Vinculo v = new Vinculo("Tecnico em informática");
        //lv.cadastraVinculo(v);
        
        v.setDescricao("Técnico em Informática");
        
        //lv.alteraVinculo(v);

        Vinculo testeV = lv.buscaVinculo(15);
        
        lv.ativaVinculo(testeV.getId());
        
        
    }
}
