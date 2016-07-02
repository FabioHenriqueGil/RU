/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.ru.dao;

import br.ufpr.ru.jdbc.ConnectionFactory;
import br.ufpr.ru.modelo.Checkin;
import br.ufpr.ru.modelo.Vinculo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabio
 */

@Repository
public class CheckinDao implements IDao<Checkin> {

    private Connection connection;

    @Autowired
    public CheckinDao(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public CheckinDao(Connection connection) {
        this.connection = connection;
    }

    
    @Override
    public void inserir(Checkin obj) {
        String sql = "insert into Checkin (Consumidor_id, data) values(?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getConsumidor().getId());
            stmt.setDate(2, new java.sql.Date(obj.getData().getTimeInMillis()));
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
            System.out.println("erro no adiciona checkin");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(Checkin obj) {
        String sql = "update Checkin set Consumidor_id=?, data=? where id=" + obj.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, obj.getConsumidor().getId());
            stmt.setDate(2, new java.sql.Date(obj.getData().getTimeInMillis()));
            if (obj.getId() != 0) {
                stmt.execute();
            }
            stmt.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("erro no altera checkin");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Checkin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Checkin buscar(int id) {
        Checkin checkin = new Checkin();
        ConsumidorDao cd = new ConsumidorDao(connection);
        String sql = "select * from Checkin where id =" + id;

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                checkin.setId(resultado.getInt("id"));
                checkin.setConsumidor(cd.buscar(resultado.getInt("Consumidor_id")));
                Date data = resultado.getDate("data");
                Calendar dataC = Calendar.getInstance();

                dataC.setTime(data);
                checkin.setData(dataC);
            }

            // fecha conexão
            resultado.close();
            stmt.close();
            return checkin;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Checkin> listar() {
        List<Checkin> checkins = new ArrayList<Checkin>();
        ConsumidorDao cd = new ConsumidorDao(connection);
        String sql = "select * from Checkin";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            // executa
            ResultSet resultado = stmt.executeQuery();
            // alimenta a lista
            while (resultado.next()) {
                Checkin checkin = new Checkin();
                checkin.setId(resultado.getInt("id"));
                checkin.setConsumidor(cd.buscar(resultado.getInt("Consumidor_id")));
                Date data = resultado.getDate("data");
                Calendar dataC = Calendar.getInstance();

                dataC.setTime(data);
                checkin.setData(dataC);
                checkins.add(checkin);
            }
            // fecha conexão
            resultado.close();
            stmt.close();
            return checkins;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Checkin> listarAtivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Checkin> listar(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
