/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.logica;

import org.junit.Test;
import ufpr.br.modelo.Modalidade;

/**
 *
 * @author fabio
 */
public class LogicaModalidadeTeste {
    
    @Test
    public void teste() {
        LogicaModalidade lm = new LogicaModalidade();
        Modalidade m = lm.buscaModalidade(6);
        m.setDescricao("Funcionário");
        lm.alteraModalidade(m);
        lm.desativaModalidade(m.getId());
        
        
        
    }
}
