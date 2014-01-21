
package com.agungsetiawan.smsbroadcaster.service;

import com.agungsetiawan.smsbroadcaster.App;
import com.agungsetiawan.smsbroadcaster.entity.Kontak;
import com.agungsetiawan.smsbroadcaster.repository.KontakRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author blinkawan
 */
public class KontakService {
    
    private KontakRepository kontakRepository;
    private Connection connection;
    
    public void setDataSource(DataSource dataSource) throws SQLException{
        try {
            connection=dataSource.getConnection();
            kontakRepository=new KontakRepository();
            kontakRepository.setConnection(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
    }
    
    public void save(Kontak kontak){
        try{
            connection.setAutoCommit(false);
            kontakRepository.save(kontak);
            connection.commit();
            connection.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                connection.rollback();
                throw new SQLException(ex.toString());
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void update(Kontak kontak){
        try{
            connection.setAutoCommit(false);
            kontakRepository.update(kontak);
            connection.commit();
            connection.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                connection.rollback();
                throw new SQLException(ex.toString());
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void delete(Long id){
        try{
            connection.setAutoCommit(false);
            kontakRepository.delete(id);
            connection.commit();
            connection.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                connection.rollback();
                throw new SQLException(ex.toString());
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public Kontak findOne(Long id) throws SQLException{
        try{
            return kontakRepository.findOne(id);
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
        
    }
    
    public Kontak findOneByNumber(String number) throws SQLException{
        try{
            return kontakRepository.findOneByNumber(number);
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
        
    }
    
    public List<Kontak> findByGrup(Long id) throws SQLException{
        try{
            return kontakRepository.findByGrup(id);
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
        
    }
    
    public List<Kontak> findAll() throws SQLException{
        try{
            return kontakRepository.findAll();
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
    }
}
