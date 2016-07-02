/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.dao.TaxaDeSubsidioDao;
import br.ufpr.ru.modelo.TaxaDeSubsidio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabio
 */

@Service
public class LogicaTaxaDeSubsidio implements CrudTaxaDeSubsidio{

    private TaxaDeSubsidioDao dao ;
    @Autowired
       public LogicaTaxaDeSubsidio(TaxaDeSubsidioDao dao) {
        
        this.dao = dao;
    }
    
    
    @Override
    public void cadastraTaxa(TaxaDeSubsidio taxa) {
     dao.inserir(taxa);
    }

    @Override
    public void alteraTaxa(TaxaDeSubsidio taxa) {
        dao.alterar(taxa);
    }

    @Override
    public TaxaDeSubsidio buscaTaxa(int modalidade_id, int vinculo_id) {
        return dao.buscar(modalidade_id, vinculo_id);
    }

    @Override
    public List<TaxaDeSubsidio> lista() {
        return dao.listar();
    }

    @Override
    public List<TaxaDeSubsidio> listaAtivos() {
        return dao.listarAtivos();
    }
    
}
