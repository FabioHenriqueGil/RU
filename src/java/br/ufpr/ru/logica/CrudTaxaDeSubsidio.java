/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.modelo.TaxaDeSubsidio;
import java.util.List;

/**
 *
 * @author fabio
 */
public interface CrudTaxaDeSubsidio {

    void cadastraTaxa(TaxaDeSubsidio taxa);

    void alteraTaxa(TaxaDeSubsidio taxa);

    TaxaDeSubsidio buscaTaxa(int modalidade_id, int vinculo_id);

    List<TaxaDeSubsidio> lista();

    List<TaxaDeSubsidio> listaAtivos();

}
