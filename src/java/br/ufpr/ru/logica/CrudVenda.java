/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.modelo.Venda;

/**
 *
 * @author fabio
 */
public interface CrudVenda {
    
   void cadastraVenda(Venda venda);
   
   void alteraVenda(Venda venda);   
    
}
