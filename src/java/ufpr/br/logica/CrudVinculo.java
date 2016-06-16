/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.logica;

import java.util.List;
import ufpr.br.modelo.Modalidade;
import ufpr.br.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public interface CrudVinculo {

    void cadastraVinculo(Vinculo vinculo);

    void alteraVinculo(Vinculo vinculo);

    void ativaVinculo(int id);

    void desativaVinculo(int id);

    Vinculo buscaVinculo(int id);

    List<Vinculo> lista(Modalidade modalidade);

}
