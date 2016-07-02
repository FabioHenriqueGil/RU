/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import br.ufpr.ru.modelo.TaxaDeSubsidio;
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
public class TaxaDeSubsidioDao implements IDao<TaxaDeSubsidio> {

    private Connection connection;

    @Autowired
    public TaxaDeSubsidioDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public TaxaDeSubsidioDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void inserir(TaxaDeSubsidio obj) {
        String sql = "insert into TaxaSubsidio (Modalidade_id,Produto_id, taxaSubsidio) values(?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, obj.getModalidade().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setDouble(3, obj.getDesconto());
            stmt.execute();

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona subsidio");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(TaxaDeSubsidio obj) {
        String sql = "update TaxaSubsidio set taxaSubsidio=? where Modalidade_id="
                + obj.getModalidade().getId() + " and Produto_id ="
                + obj.getProduto().getId();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, obj.getDesconto());
            stmt.execute();

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no altera subsidio");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(TaxaDeSubsidio obj) {
        String sql = "delete from TaxaSubsidio where Modalidade_id="
                + obj.getModalidade().getId() + " and Produto_id ="
                + obj.getProduto().getId();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar subsidio");
            throw new RuntimeException(e);
        }
    }

    public TaxaDeSubsidio buscar(int Modalidade_id, int Produto_id) {
        TaxaDeSubsidio tsb = new TaxaDeSubsidio();
        ModalidadeDao md = new ModalidadeDao(connection);
        ProdutoDao pd = new ProdutoDao(connection);

        String sql = "select * from TaxaSubsidio where Modalidade_id="
                + Modalidade_id + " and Produto_id =" + Produto_id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                tsb.setModalidade(md.buscar(resultado.getInt("Modalidade_id")));
                tsb.setProduto(pd.buscar(resultado.getInt("Produto_id")));
                tsb.setDesconto(resultado.getDouble("taxaSubsidio"));
            }

            // fecha conexão
            resultado.close();
            stmt.close();
            return tsb;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaxaDeSubsidio> listar() {
        List<TaxaDeSubsidio> listaDeTaxas = new ArrayList<TaxaDeSubsidio>();
        String sql = "select * from TaxaSubsidio";
        ModalidadeDao md = new ModalidadeDao(connection);
        ProdutoDao pd = new ProdutoDao(connection);

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                TaxaDeSubsidio tsb = new TaxaDeSubsidio();
                tsb.setModalidade(md.buscar(resultado.getInt("Modalidade_id")));
                tsb.setProduto(pd.buscar(resultado.getInt("Produto_id")));
                tsb.setDesconto(resultado.getDouble("taxaSubsidio"));
                listaDeTaxas.add(tsb);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return listaDeTaxas;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaxaDeSubsidio> listarAtivos() {
        List<TaxaDeSubsidio> listaDeTaxas = new ArrayList<TaxaDeSubsidio>();
        String sql = "select * from TaxaSubsidio where Modalidade_id not in "
                + "(select id from Modalidade where ativo = 0) and Produto_id not in "
                + "(select id from Produto where ativo = 0)";
        System.out.println("br.ufpr.ru.dao.TaxaDeSubsidioDao.listarAtivos()  "+sql);
        ModalidadeDao md = new ModalidadeDao(connection);
        ProdutoDao pd = new ProdutoDao(connection);

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                TaxaDeSubsidio tsb = new TaxaDeSubsidio();
                tsb.setModalidade(md.buscar(resultado.getInt("Modalidade_id")));
                tsb.setProduto(pd.buscar(resultado.getInt("Produto_id")));
                tsb.setDesconto(resultado.getDouble("taxaSubsidio"));
                listaDeTaxas.add(tsb);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return listaDeTaxas;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<TaxaDeSubsidio> listar(String filtro) {
        System.out.println("br.ufpr.ru.dao.TaxaDeSubsidioDao.buscar() função obsoleta sendo chamada");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public TaxaDeSubsidio buscar(int id) {
        System.out.println("br.ufpr.ru.dao.TaxaDeSubsidioDao.buscar() função obsoleta sendo chamada");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
