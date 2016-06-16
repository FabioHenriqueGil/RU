/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.dao;

import java.util.List;
import org.junit.Test;
import ufpr.br.modelo.Consumidor;
import ufpr.br.modelo.Credito;
import ufpr.br.modelo.Modalidade;
import ufpr.br.modelo.Vinculo;

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
