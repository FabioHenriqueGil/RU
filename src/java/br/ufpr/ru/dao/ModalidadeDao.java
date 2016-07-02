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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabio
 */

@Repository
public class ModalidadeDao implements IDao<Modalidade> {

    private Connection connection;

    @Autowired
    public ModalidadeDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ModalidadeDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void inserir(Modalidade obj) {
        String sql = "insert into Modalidade (descricao) values(?)";
        String sqlVB = "insert into VinculosBloqueados (Vinculo_id, Modalidade_id) values (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getDescricao());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            int idMod = 0;
            if (rs.next()) {
                idMod = rs.getInt(1);

            }
            obj.setId(idMod);
            stmt.close();
            PreparedStatement stmtVB = connection.prepareStatement(sqlVB);
            if (obj.getVinculosBloqueados() != null) {
                for (Vinculo vb : obj.getVinculosBloqueados()) {
                    stmtVB.setInt(1, vb.getId());
                    stmtVB.setInt(2, obj.getId());
                    stmtVB.execute();
                }
            }
            stmtVB.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona modalidade");
            throw new RuntimeException(e);
        
        }

    }

    @Override
    public void alterar(Modalidade obj) {
        String sqlVBDel = "DELETE FROM VinculosBloqueados WHERE modalidade_id=" + obj.getId();
        String sqlVB = "insert into VinculosBloqueados (Vinculo_id, Modalidade_id) values (?, ?)";
        String sql = "update Modalidade set descricao=?, ativo=? where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setBoolean(2, obj.isAtivo());
            stmt.execute();
            stmt.close();
            PreparedStatement stmtVBDel = connection.prepareStatement(sqlVBDel);
            stmtVBDel.execute();
            stmtVBDel.close();
            PreparedStatement stmtVB = connection.prepareStatement(sqlVB);
            if (obj.getVinculosBloqueados() != null) {
                for (Vinculo vb : obj.getVinculosBloqueados()) {
                    stmtVB.setInt(1, vb.getId());
                    stmtVB.setInt(2, obj.getId());
                    System.out.println("br.ufpr.ru.dao.ModalidadeDao.alterar()" + sqlVB + " " + vb.getId() + " " + obj.getId());
                    stmtVB.execute();
                }
            }
            stmtVB.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona modalidade");
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deletar(Modalidade obj) {
        String sqlVBDel = "delete from VinculosBloqueados where Modalidade_id=" + obj.getId();
        String sql = "delete from Modalidade where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            PreparedStatement stmtVBDel = connection.prepareStatement(sqlVBDel);
            stmtVBDel.execute();
            stmtVBDel.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar modalidade");
            throw new RuntimeException(e);
        }
    }

    private List<Vinculo> VinculosBloqueados(int id) {
        List<Vinculo> vinculosBloqueados = new ArrayList<>();
        String sqlVB = "select * from VinculosBloqueados where Modalidade_id=" + id
                + " AND vinculo_id NOT IN (select id from Vinculo where ativo = '0')";
        try {
            PreparedStatement stmtVB = connection.prepareStatement(sqlVB);
            ResultSet resultadoVB = stmtVB.executeQuery();
            // alimenta a lista
            while (resultadoVB.next()) {
                Vinculo vin = new Vinculo();
                VinculoDao vbDao = new VinculoDao(connection);
                vin.setId(resultadoVB.getInt("Vinculo_id"));
                vin.setAtivo(vbDao.buscar(vin.getId()).isAtivo());
                vin.setDescricao(vbDao.buscar(vin.getId()).getDescricao());
                vinculosBloqueados.add(vin);
            }
            stmtVB.close();
             return vinculosBloqueados;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

             
        

    }

    @Override
    public Modalidade buscar(int id) {

        Modalidade mod = new Modalidade();
        String sql = "select * from Modalidade where id =" + id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                mod.setId(resultado.getInt("id"));
                mod.setDescricao(resultado.getString("descricao"));
                mod.setAtivo(resultado.getBoolean("ativo"));
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            mod.setVinculosBloqueados(VinculosBloqueados(id));
            return mod;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Modalidade> listar() {

        List<Modalidade> mods = new ArrayList<Modalidade>();
        String sql = "select * from Modalidade";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Modalidade mod = new Modalidade();
                mod.setId(resultado.getInt("id"));
                mod.setDescricao(resultado.getString("descricao"));
                mod.setVinculosBloqueados(VinculosBloqueados(mod.getId()));
                mod.setAtivo(resultado.getBoolean("ativo"));
                mods.add(mod);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return mods;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Modalidade> listarAtivos() {

        List<Modalidade> mods = new ArrayList<Modalidade>();
        String sql = "SELECT * FROM `Modalidade` WHERE ativo = '1'";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Modalidade mod = new Modalidade();
                mod.setId(resultado.getInt("id"));
                mod.setDescricao(resultado.getString("descricao"));
                mod.setVinculosBloqueados(VinculosBloqueados(mod.getId()));
                mod.setAtivo(resultado.getBoolean("ativo"));
                mods.add(mod);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return mods;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Modalidade> listar(String filtro) {
        List<Modalidade> mods = new ArrayList<Modalidade>();
        String sql = "select * from Modalidade where descricao like'%" + filtro + "%'";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Modalidade mod = new Modalidade();
                mod.setId(resultado.getInt("id"));
                mod.setDescricao(resultado.getString("descricao"));
                mod.setVinculosBloqueados(VinculosBloqueados(mod.getId()));
                mod.setAtivo(resultado.getBoolean("ativo"));
                mods.add(mod);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return mods;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
