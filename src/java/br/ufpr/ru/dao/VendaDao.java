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
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabio
 */

@Repository
public class VendaDao implements IDao<Venda> {

    private Connection connection;

    @Autowired
    public VendaDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public VendaDao(Connection connection) {
        this.connection = connection;
    }
    
    


    @Override
    public void inserir(Venda obj) {
        String sql = "insert into Venda (Checkin_id, TipoDeReceita_id, Caixa_id, ativo) values(?,?,?,?)";
        VendaItemDao vi = new VendaItemDao(connection);
        CheckinDao chdao = new CheckinDao(connection);
        chdao.inserir(obj.getCheckin());
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getCheckin().getId());
            stmt.setInt(2, obj.getTipoDeReceita().getId());
            stmt.setInt(3, obj.getCaixa().getId());
            stmt.setBoolean(4, obj.isAtivo());
            
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            int idVenda = 0;
            if (rs.next()) {
                idVenda = rs.getInt(1);

            }
            obj.setId(idVenda);
            vi.inserir(obj.getListaDeProdutos(), obj);

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona venda");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(Venda obj) {
        String sql = "update Venda set Checkin_id=?, TipoDeReceita_id=?, Caixa_id=?, ativo=? where id=" + obj.getId();
        VendaItemDao vi = new VendaItemDao(connection);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getCheckin().getId());
            stmt.setInt(2, obj.getTipoDeReceita().getId());
            stmt.setInt(3, obj.getCaixa().getId());
            stmt.setBoolean(4, obj.isAtivo());
            stmt.execute();
            vi.alterar(obj.getListaDeProdutos(), obj);

            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no alterar venda");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(Venda obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda buscar(int id) {
        Venda ven = new Venda();
        String sql = "select * from Venda where id =" + id;
        CaixaDao cd = new CaixaDao(connection);
        CheckinDao chd = new CheckinDao(connection);
        TipoDeReceitaDao trd = new TipoDeReceitaDao(connection);
        VendaItemDao vid = new VendaItemDao(connection);
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                ven.setId(resultado.getInt("id"));
                ven.setCheckin(chd.buscar(resultado.getInt("Checkin_id")));
                ven.setTipoDeReceita(trd.buscar(resultado.getInt("TipoDeReceita_id")));
                ven.setCaixa(cd.buscar(resultado.getInt("Caixa_id"))); 
                ven.setAtivo(resultado.getBoolean("ativo"));
                ven.setListaDeProdutos(vid.listar(ven));
                
            }
            
            // fecha conexão
            resultado.close();
            stmt.close();
            return ven;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Venda> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> listar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
