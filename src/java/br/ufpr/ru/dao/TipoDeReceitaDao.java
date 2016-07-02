/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import br.ufpr.ru.modelo.TipoDeReceita;
import br.ufpr.ru.modelo.Vinculo;
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
public class TipoDeReceitaDao implements IDao<TipoDeReceita> {

    private Connection connection;

    @Autowired
    public TipoDeReceitaDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public TipoDeReceitaDao(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public void inserir(TipoDeReceita obj) {
        String sql = "insert into TipoDeReceita ( descricao, credito) values(?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getDescricao());
            stmt.setBoolean(2, obj.isCredito());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int idTipo = 0;
            if (rs.next()) {
                idTipo = rs.getInt(1);
            }
            obj.setId(idTipo);

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona tipo de receita");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(TipoDeReceita obj) {
        String sql = "update TipoDeReceita set descricao=?,credito=? where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setBoolean(2, obj.isCredito());
            if (obj.getId() != 0) {
                stmt.execute();
            }
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no altera tipo de receita");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(TipoDeReceita obj) {

        String sql = "delete from TipoDeReceita where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar tipo de receita");
            throw new RuntimeException(e);
        }

    }

    @Override
    public TipoDeReceita buscar(int id) {
        TipoDeReceita tipo = new TipoDeReceita();
        String sql = "select * from TipoDeReceita where id =" + id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                tipo.setId(resultado.getInt("id"));
                tipo.setDescricao(resultado.getString("descricao"));
                tipo.setCredito(resultado.getBoolean("credito"));
            }

            // fecha conexão
            resultado.close();
            stmt.close();
            return tipo;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<TipoDeReceita> listar() {
        List<TipoDeReceita> tipos = new ArrayList<TipoDeReceita>();
        String sql = "select * from TipoDeReceita";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                TipoDeReceita tipo = new TipoDeReceita();
                tipo.setId(resultado.getInt("id"));
                tipo.setDescricao(resultado.getString("descricao"));
                tipo.setCredito(resultado.getBoolean("credito"));
                tipos.add(tipo);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return tipos;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TipoDeReceita> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDeReceita> listar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
