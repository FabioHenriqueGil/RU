/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import br.ufpr.ru.modelo.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabio
 */
@Repository
public class CaixaDao implements IDao<Caixa> {

    private Connection connection;

    @Autowired
    public CaixaDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public CaixaDao(Connection connection) {
        this.connection = connection;
    }

    
    
    @Override
    public void inserir(Caixa obj) {
        String sql = "insert into Caixa (saldo) values(?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, obj.getSaldo());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int idcx = 0;
            if (rs.next()) {
                idcx = rs.getInt(1);

            }
            obj.setId(idcx);

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona caixa");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Caixa obj) {
        String sql = "update Caixa set saldo=? where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, obj.getSaldo());
            if (obj.getId() != 0) {
                stmt.execute();
            }
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no altera caixa");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Caixa obj) {
        String sql = "delete from Caixa where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar caixa");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Caixa buscar(int id) {
        Caixa caixa = new Caixa();
        String sql = "select * from Caixa where id =" + id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                caixa.setId(resultado.getInt("id"));
                caixa.setSaldo(resultado.getDouble("saldo"));
            }

            // fecha conexão
            resultado.close();
            stmt.close();
            return caixa;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Caixa> listar() {
        List<Caixa> caixas = new ArrayList<Caixa>();
        String sql = "select * from Caixa";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Caixa caixa = new Caixa();
                caixa.setId(resultado.getInt("id"));
                caixa.setSaldo(resultado.getDouble("saldo"));
                caixas.add(caixa);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return caixas;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Caixa> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Caixa> listar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
