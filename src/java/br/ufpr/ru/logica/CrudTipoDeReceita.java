/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.modelo.TipoDeReceita;
import java.util.List;

/**
 *
 * @author fabio
 */
public interface CrudTipoDeReceita {

    void cadastraTipoDeReceita(TipoDeReceita tipoDeReceita);

    void alteraTipoDeReceita(TipoDeReceita tipoDeReceita);

    TipoDeReceita buscaTipoDeReceita(int id);

    List<TipoDeReceita> lista();

}
