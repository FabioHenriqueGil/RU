/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import java.util.List;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;

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
    
    List<Vinculo> listaAtivos();
    
    List<Vinculo> listaAtivos(Modalidade modalidade);

    List<Vinculo> lista(Modalidade modalidade);

}
