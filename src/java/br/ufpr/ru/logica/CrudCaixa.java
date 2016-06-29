/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.logica;

import br.ufpr.ru.modelo.Caixa;

/**
 *
 * @author fabio
 */
public interface CrudCaixa {
    
    void cadastraCaixa(Caixa caixa);
    
    Caixa buscaCaixa(int id);
    
    double consultaSaldo(int id);
    
    void deposita(Caixa caixa, double valor);
    
    boolean saca(Caixa caixa, double valor);
    
}
