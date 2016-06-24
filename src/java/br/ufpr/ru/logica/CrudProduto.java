/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import java.util.List;
import br.ufpr.ru.modelo.Produto;

/**
 *
 * @author fabio
 */
public interface CrudProduto {

    void cadastraVinculo(Produto produto);

    void alteraProduto(Produto produto);

    void ativaProduto(int id);

    void desativaProduto(int id);

    Produto buscaProduto(int id);
    
    List<Produto> listaAtivos();

    List<Produto> lista();
    
    List<Produto> lista(String filtro);

}
