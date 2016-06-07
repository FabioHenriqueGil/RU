/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpr.br.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ufpr.br.modelo.Consumidor;

/**
 *
 * @author fabio
 */
public class ConsumidorDao implements IDao<Consumidor>{

    private EntityManager maneger;
    
    public ConsumidorDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ru");
        maneger = factory.createEntityManager();
    
    }

    
    
    @Override
    public void inserir(Consumidor obj) {
        maneger.getTransaction().begin();
        maneger.persist(obj);
        maneger.getTransaction().commit();
    }

    @Override
    public void alterar(Consumidor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Consumidor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consumidor buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consumidor> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consumidor> listar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
