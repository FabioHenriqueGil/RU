/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.dao.VinculoDao;
import org.junit.Test;
import br.ufpr.ru.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class VinculoTesteDao {

    @Test
    public void teste() {

        VinculoDao vd = new VinculoDao();
        Vinculo v1 = new Vinculo("Discente em Computação");
        Vinculo v2 = new Vinculo("Discente em Agronomia");
        Vinculo v3 = new Vinculo("Discente em Veterinaria");
        Vinculo v4 = new Vinculo("Docente de Engenharias");
        Vinculo v5 = new Vinculo("Docente de Humanas");

//        vd.inserir(v1);
//        vd.inserir(v2);
//        vd.inserir(v3);
//        vd.inserir(v4);
//        vd.inserir(v5);
        v5 = vd.buscar(15);
        v5.setAtivo(false);
        vd.alterar(v5);
    }

}
