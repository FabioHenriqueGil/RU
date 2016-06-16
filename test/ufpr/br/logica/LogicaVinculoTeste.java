/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.logica;

import org.junit.Test;
import ufpr.br.modelo.Vinculo;

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
