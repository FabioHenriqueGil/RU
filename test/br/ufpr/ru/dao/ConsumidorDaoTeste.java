/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

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

/**
 *
 * @author fabio
 */
public class ConsumidorDaoTeste {

    @Test
    public void teste() {

//        Credito c = new Credito();
//        Modalidade m = new Modalidade("Franqueado");
//        Vinculo v = new Vinculo("Computação");
        //CreditoDao cd = new CreditoDao();
//        
//        c.deposita(50);
//        cd.inserir(c);
//
         ModalidadeDao md = new ModalidadeDao();
//        md.inserir(m);
//        
        VinculoDao vd = new VinculoDao();
         Consumidor f = new Consumidor(md.buscar(7), vd.buscar(11), "Daniel", "grr20145680");
//        vd.inserir(v);
        ConsumidorDao cd = new ConsumidorDao();
          cd.inserir(f);
          f.deposita(23);
          cd.alterar(f);
//       // Consumidor c = cd.buscar(5);
//        c.setGrr("grr20146060");
//        c.setNome("Fabio");
//        
//        cd.alterar(c);
        //cd.deletar();

        List<Consumidor> lc = cd.listar();

        for (Consumidor c : lc) {
            System.out.println("ID=" + c.getId() + "\nNOME=" + c.getNome()
                    + "\nGRR=" + c.getGrr() + "\nMODALIDADE=" + c.getModalidade().getDescricao()
                    + "\nVINCULO=" + c.getVinculo().getDescricao() + "\nSALDO=R$" + c.getCredito().getSaldo()+"\n----");
        }

    }

}
