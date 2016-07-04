/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import br.ufpr.ru.modelo.Produto;
import br.ufpr.ru.modelo.Venda;
import br.ufpr.ru.modelo.VendaItem;
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
public class VendaItemDao implements IDao<VendaItem> {

    private Connection connection;

    @Autowired
    public VendaItemDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public VendaItemDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserir(VendaItem obj) {
        String sql = "insert into VendaItem (Venda_id, Produto_id, qtd, precoUnit) values(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getPrecoUnit());
            stmt.execute();

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona item da venda");
            throw new RuntimeException(e);
        }

    }

    public void inserir(List<Produto> list, Venda venda) {
        for (Produto produto : list) {
            VendaItem vi = new VendaItem(venda, produto, produto.getQtd(), produto.getPrecoVenda());
            this.inserir(vi);
        }
    }

    @Override
    public void alterar(VendaItem obj) {
        String sql = "update VendaItem set Produto_id=?, qtd=?, precoUnit=? where Venda_id=" + obj.getVenda().getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, obj.getProduto().getId());
            stmt.setInt(2, obj.getQtd());
            stmt.setDouble(3, obj.getPrecoUnit());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no alterar item da venda");
            throw new RuntimeException(e);
        }
    }

    public void alterar(List<Produto> list, Venda venda) {
        this.deletar(venda);
        this.inserir(list, venda);
    }

    @Override
    public void deletar(VendaItem obj) {
        String sql = "delete from VendaItem where Venda_id="
                + obj.getVenda().getId() + " and where Produto_id=" + obj.getProduto().getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar item da venda");
            throw new RuntimeException(e);
        }

    }

    public void deletar(Venda venda) {
        String sql = "delete from VendaItem where Venda_id=" + venda.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar item da venda");
            throw new RuntimeException(e);
        }
    }

    @Override
    public VendaItem buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public List<VendaItem> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Produto> listar(Venda venda) {
        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "select * from VendaItem where Venda_id=" + venda.getId();
        ProdutoDao pd = new ProdutoDao(connection);
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {                
                Produto produto = pd.buscar(resultado.getInt("Produto_id"));
                produto.setPrecoVenda(resultado.getDouble("precoUnit"));
                produto.setQtd(resultado.getInt("qtd"));
                produtos.add(produto);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return produtos;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<VendaItem> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VendaItem> listar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
