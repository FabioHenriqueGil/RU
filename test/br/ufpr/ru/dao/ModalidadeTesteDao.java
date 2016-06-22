/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.dao.VinculoDao;
import br.ufpr.ru.dao.ModalidadeDao;
import java.util.List;
import org.junit.Test;
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Credito;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class ModalidadeTesteDao {

    @Test
    public void teste() {

//
        ModalidadeDao md = new ModalidadeDao();

        VinculoDao vd = new VinculoDao();

        List<Vinculo> vb = vd.listar("Docente");
       Modalidade m = new Modalidade("Franqueado",vb);//md.buscar(1);
      //  Modalidade m = new Modalidade("Funcionario");
        md.inserir(m);
        

        for (Vinculo vinculo : vd.listar(m)) {
            System.out.println("Vinculo = "+vinculo.getDescricao());
        }

    }
}
