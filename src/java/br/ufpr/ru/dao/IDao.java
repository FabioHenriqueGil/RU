/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import java.util.List;

/**
 *
 * @author fabio
 */
public interface IDao<T>{
    void inserir(T obj);
    void alterar(T obj);
    void deletar(T obj);
    T buscar(int id);
    List<T> listar();
    List<T> listar(String filtro);
}
