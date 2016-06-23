/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;

/**
 *
 * @author fabio
 */
public class VinculoDao implements IDao<Vinculo> {

    private Connection connection;

    public VinculoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    @Override
    public void inserir(Vinculo obj) {
        String sql = "insert into Vinculo (descricao) values(?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getDescricao());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int idVin = 0;
            if (rs.next()) {
                idVin = rs.getInt(1);

            }
            obj.setId(idVin);

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona vinculo");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(Vinculo obj) {

        String sql = "update Vinculo set descricao=?,ativo=? where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setBoolean(2, obj.isAtivo());
            if (obj.getId() != 0) {
                stmt.execute();
            }
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona vinculo");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(Vinculo obj) {

        String sql = "delete from Vinculo where id=" + obj.getId();
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
    public Vinculo buscar(int id) {
        Vinculo vin = new Vinculo();
        String sql = "select * from Vinculo where id =" + id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                vin.setId(resultado.getInt("id"));
                vin.setDescricao(resultado.getString("descricao"));
                vin.setAtivo(resultado.getBoolean("ativo"));
            }
            
            // fecha conexão
            resultado.close();
            stmt.close();
            return vin;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Vinculo> listar() {
        List<Vinculo> vins = new ArrayList<Vinculo>();
        String sql = "select * from Vinculo";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Vinculo vin = new Vinculo();
                vin.setId(resultado.getInt("id"));
                vin.setDescricao(resultado.getString("descricao"));
                vin.setAtivo(resultado.getBoolean("ativo"));
                vins.add(vin);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return vins;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vinculo> listarAtivos() {
        List<Vinculo> vins = new ArrayList<Vinculo>();
        String sql = "select * from Vinculo where ativo = '1'";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Vinculo vin = new Vinculo();
                vin.setId(resultado.getInt("id"));
                vin.setDescricao(resultado.getString("descricao"));
                vin.setAtivo(resultado.getBoolean("ativo"));
                vins.add(vin);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return vins;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Vinculo> listarAtivos(Modalidade mod) {
        List<Vinculo> vins = new ArrayList<Vinculo>();
        String sql = "select * from Vinculo where ativo= '1' and id not in(select Vinculo_id "
                + "from VinculosBloqueados where Modalidade_id =" + mod.getId() + ")";
        System.out.println(sql);
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Vinculo vin = new Vinculo();
                vin.setId(resultado.getInt("id"));
                vin.setDescricao(resultado.getString("descricao"));
                vin.setAtivo(resultado.getBoolean("ativo"));
                vins.add(vin);
            }
            // fecha conexão
            resultado.close();
            stmt.close();

            return vins;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Vinculo> listar(String filtro) {
        List<Vinculo> vins = new ArrayList<Vinculo>();
        String sql = "select * from Vinculo where descricao like'%" + filtro + "%'";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Vinculo vin = new Vinculo();
                vin.setId(resultado.getInt("id"));
                vin.setDescricao(resultado.getString("descricao"));
                vin.setAtivo(resultado.getBoolean("ativo"));
                vins.add(vin);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return vins;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public List<Vinculo> listar(Modalidade mod) {
        List<Vinculo> vins = new ArrayList<Vinculo>();
        String sql = "select * from Vinculo where id not in(select Vinculo_id "
                + "from VinculosBloqueados where Modalidade_id =" + mod.getId() + ")";
        System.out.println(sql);
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Vinculo vin = new Vinculo();
                vin.setId(resultado.getInt("id"));
                vin.setDescricao(resultado.getString("descricao"));
                vin.setAtivo(resultado.getBoolean("ativo"));
                vins.add(vin);
            }
            // fecha conexão
            resultado.close();
            stmt.close();

            return vins;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
