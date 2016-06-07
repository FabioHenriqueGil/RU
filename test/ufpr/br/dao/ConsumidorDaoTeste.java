/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ufpr.br.modelo.Consumidor;
import ufpr.br.modelo.Modalidade;
import ufpr.br.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class ConsumidorDaoTeste {

    @Test
    public void teste() {
        
        Consumidor c = new Consumidor(new Modalidade("Franqueado"),
                new Vinculo("Computacao"), "Fabio", "GRR20146060");
        
        ConsumidorDao cd = new ConsumidorDao();
        
        cd.inserir(c);

    }

}
