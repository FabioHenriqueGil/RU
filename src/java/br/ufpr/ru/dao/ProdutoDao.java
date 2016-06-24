/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import br.ufpr.ru.modelo.Produto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class ProdutoDao implements IDao<Produto>{

    private Connection connection;

    public ProdutoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    @Override
    public void inserir(Produto obj) {
         String sql = "insert into Produto (descricao, precoPadrao) values(?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getDescricao());            
            stmt.setDouble(2, obj.getPrecoPadrao());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int idPro = 0;
            if (rs.next()) {
                idPro = rs.getInt(1);

            }
            obj.setId(idPro);

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona vinculo");
            throw new RuntimeException(e);
        }


    }

    @Override
    public void alterar(Produto obj) {
     
        String sql = "update Produto set descricao=?,precoPadrao=?, ativo=? where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPrecoPadrao());
            stmt.setBoolean(3, obj.isAtivo());
            if (obj.getId() != 0) {
                stmt.execute();
            }
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona vinculo");
            throw new RuntimeException(e);
        }}

    @Override
    public void deletar(Produto obj) {
        String sql = "delete from produto where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar vinculo");
            throw new RuntimeException(e);
        }
    
    }

    @Override
    public Produto buscar(int id) {
        Produto pro = new Produto();
        String sql = "select * from Produto where id =" + id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                pro.setId(resultado.getInt("id"));
                pro.setDescricao(resultado.getString("descricao"));
                pro.setPrecoPadrao(resultado.getDouble("precoPadrao"));
                pro.setAtivo(resultado.getBoolean("ativo"));
            }
            
            // fecha conexão
            resultado.close();
            stmt.close();
            return pro;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    
    }

    @Override
    public List<Produto> listar() {
        List<Produto> prods = new ArrayList<Produto>();
        String sql = "select * from Produto";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Produto pro = new Produto();
                pro.setId(resultado.getInt("id"));
                pro.setDescricao(resultado.getString("descricao"));
                pro.setPrecoPadrao(resultado.getDouble("precoPadrao"));
                pro.setAtivo(resultado.getBoolean("ativo"));
                prods.add(pro);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return prods;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    
    }

    @Override
    public List<Produto> listarAtivos() {
        List<Produto> prods = new ArrayList<Produto>();
        String sql = "select * from Produto where ativo = '1'";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Produto pro = new Produto();
                pro.setId(resultado.getInt("id"));
                pro.setDescricao(resultado.getString("descricao"));
                pro.setPrecoPadrao(resultado.getDouble("precoPadrao"));
                pro.setAtivo(resultado.getBoolean("ativo"));
                prods.add(pro);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return prods;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Produto> listar(String filtro) {
        List<Produto> prods = new ArrayList<Produto>();
        String sql = "select * from Produto where descricao like '%"+filtro+"%'";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Produto pro = new Produto();
                pro.setId(resultado.getInt("id"));
                pro.setDescricao(resultado.getString("descricao"));
                pro.setPrecoPadrao(resultado.getDouble("precoPadrao"));
                pro.setAtivo(resultado.getBoolean("ativo"));
                prods.add(pro);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return prods;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    
}
