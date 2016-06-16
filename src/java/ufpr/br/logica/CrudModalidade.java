/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.logica;

import java.util.List;
import ufpr.br.modelo.Modalidade;

/**
 *
 * @author fabio
 */
public interface CrudModalidade {

     void cadastraModalidade(Modalidade modalidade);

    void alteraModalidade(Modalidade modalidade);

    void ativaModalidade(int id);

    void desativaModalidade(int id);

    Modalidade buscaModalidade(int id);

    List<Modalidade> lista();

    List<Modalidade> lista(String descricao);

}
