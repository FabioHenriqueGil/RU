/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import javax.sql.DataSource;

import br.ufpr.ru.dao.VinculoDao;
import br.ufpr.ru.dao.ConsumidorDao;
import br.ufpr.ru.dao.ModalidadeDao;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Credito;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;
import com.mysql.jdbc.Connection;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabio
 */

public class ConsumidorDaoTeste {

    private Connection connection;

    @Test
    public void teste() {

        ConsumidorDao cd = new ConsumidorDao(connection);
        VinculoDao vd = new VinculoDao(connection);
        ModalidadeDao md = new ModalidadeDao(connection);
        CreditoDao crd = new CreditoDao(connection);

        Credito c = new Credito();
        Modalidade m = new Modalidade("Teste");
        Vinculo v = new Vinculo("Teste");

        md.inserir(m);
        //  vd.inserir(v);

//        md.inserir(m);
//        
        // Consumidor f = new Consumidor(md.buscar(7), vd.buscar(9), "TESTE", "GRRteste");
//        vd.inserir(v);
        // cd.inserir(f);
        //f.deposita(23);
        //cd.alterar(f);
//       // Consumidor c = cd.buscar(5);
//        c.setGrr("grr20146060");
//        c.setNome("Fabio");
//        
//        cd.alterar(c);
        //cd.deletar();
    }

}
