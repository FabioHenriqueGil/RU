/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import br.ufpr.ru.modelo.CreditoCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author fabio
 */
public class CreditoCaixaDao implements IDao<CreditoCaixa> {

    private Connection connection;

    public CreditoCaixaDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void inserir(CreditoCaixa obj) {
        String sql = "insert into CreditoCaixa (Credito_id, Caixa_id, valor, inserir) values(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, obj.getCredito().getId());
            stmt.setInt(2, obj.getCaixa().getId());
            stmt.setDouble(3, obj.getValor());
            stmt.setBoolean(4, obj.isInserir());
            stmt.execute();

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona vinculo");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(CreditoCaixa obj) {
        String sql = "update CreditoCaixa set valor=?,inserir=? where Credito_id="
                + obj.getCredito().getId() + " and Caixa_id=" + obj.getCaixa().getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, obj.getValor());
            stmt.setBoolean(2, obj.isInserir());

            stmt.execute();

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona credito no caixa");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(CreditoCaixa obj) {
        String sql = "delete from CreditoCaixa where Credito_id="
                + obj.getCredito().getId() + " and Caixa_id=" + obj.getCaixa().getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar credito do caixa");
            throw new RuntimeException(e);
        }
    }

    @Override
    public CreditoCaixa buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CreditoCaixa> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CreditoCaixa> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CreditoCaixa> listar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
