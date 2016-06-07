/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author fabio
 */
@Entity
public class Vinculo {
    @Id
    @GeneratedValue
    private int id;
    private String descricao;

    public Vinculo(String descricao) {
        this.descricao = descricao;
        
    }
    
    
    
}
