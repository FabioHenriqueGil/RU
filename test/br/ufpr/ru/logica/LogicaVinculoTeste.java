/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.VinculoDao;
import org.junit.Test;
import br.ufpr.ru.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class LogicaVinculoTeste {
    
    private VinculoDao vinculoDao;
    @Test
    public void teste() {
        LogicaVinculo lv = new LogicaVinculo(vinculoDao);
        
        Vinculo v = new Vinculo("TESTE");       
        
    
        lv.cadastraVinculo(v);
        
        System.out.println("br.ufpr.ru.logica.LogicaVinculoTeste.teste()   chegou aqui");
        
        
        
    }
}
