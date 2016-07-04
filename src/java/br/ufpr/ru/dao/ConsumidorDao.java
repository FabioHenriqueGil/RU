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
import br.ufpr.ru.modelo.Consumidor;
import br.ufpr.ru.modelo.Credito;
import br.ufpr.ru.modelo.Modalidade;
import br.ufpr.ru.modelo.Vinculo;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabio
 */
@Repository
public class ConsumidorDao implements IDao<Consumidor> {

    private Connection connection;

    @Autowired
    public ConsumidorDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ConsumidorDao(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public void inserir(Consumidor obj) {

        String sql = "insert into Consumidor " + "(nome,grr,Modalidade_id,Vinculo_id,Credito_id)" + "values(?,?,?,?,?)";

        try {

            CreditoDao crd = new CreditoDao(connection);
            crd.inserir(obj.getCredito());

            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getGrr());
            stmt.setInt(3, obj.getModalidade().getId());
            stmt.setInt(4, obj.getVinculo().getId());
            stmt.setInt(5, obj.getCredito().getId());
            stmt.execute();
            ResultSet rs2 = stmt.getGeneratedKeys();
            int idConsumidor = 0;
            if (rs2.next()) {
                idConsumidor = rs2.getInt(1);
            }
            stmt.close();
            obj.setId(idConsumidor);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona consumidor");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(Consumidor obj) {
        String sql = "update Consumidor set nome=?, grr=?, ativo=?, Modalidade_id=?, Vinculo_id=? where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getGrr());
            stmt.setBoolean(3, obj.isAtivo());
            stmt.setInt(4, obj.getModalidade().getId());
            stmt.setInt(5, obj.getVinculo().getId());
            CreditoDao crd = new CreditoDao(connection);
            crd.alterar(obj.getCredito());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no adiciona consumidor");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Consumidor obj) {

        String sql = "delete from Consumidor where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no deletar Consumidor");
            throw new RuntimeException(e);
        }

    }

    @Override
    public Consumidor buscar(int id) {

        Consumidor consumidor = new Consumidor();
        String sql = "select * from Consumidor where id =" + id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                consumidor.setId(resultado.getInt("id"));
                consumidor.setNome(resultado.getString("nome"));
                consumidor.setGrr(resultado.getString("grr"));
                consumidor.setAtivo(resultado.getBoolean("ativo"));

                ModalidadeDao md = new ModalidadeDao(connection);
                Modalidade mod = md.buscar(resultado.getInt("Modalidade_id"));
                consumidor.setModalidade(mod);

                VinculoDao vd = new VinculoDao(connection);
                Vinculo vin = vd.buscar(resultado.getInt("Vinculo_id"));
                consumidor.setVinculo(vin);

                CreditoDao crd = new CreditoDao(connection);
                Credito cre = crd.buscar(resultado.getInt("Credito_id"));
                consumidor.setCredito(cre);

            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return consumidor;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Consumidor> listar() {
        List<Consumidor> consumidores = new ArrayList<Consumidor>();
        String sql = "select * from Consumidor";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Consumidor consumidor = new Consumidor();
                consumidor.setId(resultado.getInt("id"));
                consumidor.setNome(resultado.getString("nome"));
                consumidor.setGrr(resultado.getString("grr"));
                consumidor.setAtivo(resultado.getBoolean("ativo"));

                ModalidadeDao md = new ModalidadeDao(connection);
                Modalidade mod = md.buscar(resultado.getInt("Modalidade_id"));
                consumidor.setModalidade(mod);

                VinculoDao vd = new VinculoDao(connection);
                Vinculo vin = vd.buscar(resultado.getInt("Vinculo_id"));
                consumidor.setVinculo(vin);

                CreditoDao crd = new CreditoDao(connection);
                Credito cre = crd.buscar(resultado.getInt("Credito_id"));
                consumidor.deposita(cre.getSaldo());

                consumidores.add(consumidor);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return consumidores;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Consumidor> listarAtivos() {
        List<Consumidor> consumidores = new ArrayList<Consumidor>();
        String sql = "select * from Consumidor where ativo= '1'";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Consumidor consumidor = new Consumidor();
                consumidor.setId(resultado.getInt("id"));
                consumidor.setNome(resultado.getString("nome"));
                consumidor.setGrr(resultado.getString("grr"));
                consumidor.setAtivo(resultado.getBoolean("ativo"));

                ModalidadeDao md = new ModalidadeDao(connection);
                Modalidade mod = md.buscar(resultado.getInt("Modalidade_id"));
                consumidor.setModalidade(mod);

                VinculoDao vd = new VinculoDao(connection);
                Vinculo vin = vd.buscar(resultado.getInt("Vinculo_id"));
                consumidor.setVinculo(vin);

                CreditoDao crd = new CreditoDao(connection);
                Credito cre = crd.buscar(resultado.getInt("Credito_id"));
                consumidor.deposita(cre.getSaldo());

                consumidores.add(consumidor);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return consumidores;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Consumidor> listar(String filtro) {
        List<Consumidor> consumidores = new ArrayList<Consumidor>();
        String sql = "select * from Consumidor where ativo= '1' and (nome like'%" + filtro + "%' or id = '"+filtro+"')";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Consumidor consumidor = new Consumidor();
                consumidor.setId(resultado.getInt("id"));
                consumidor.setNome(resultado.getString("nome"));
                consumidor.setGrr(resultado.getString("grr"));
                consumidor.setAtivo(resultado.getBoolean("ativo"));

                ModalidadeDao md = new ModalidadeDao(connection);
                Modalidade mod = md.buscar(resultado.getInt("Modalidade_id"));
                consumidor.setModalidade(mod);

                VinculoDao vd = new VinculoDao(connection);
                Vinculo vin = vd.buscar(resultado.getInt("Vinculo_id"));
                consumidor.setVinculo(vin);

                CreditoDao crd = new CreditoDao(connection);
                Credito cre = crd.buscar(resultado.getInt("Credito_id"));
                consumidor.deposita(cre.getSaldo());

                consumidores.add(consumidor);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return consumidores;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
