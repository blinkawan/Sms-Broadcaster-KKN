package com.agungsetiawan.smsbroadcaster.service;

import com.agungsetiawan.smsbroadcaster.entity.Grup;
import com.agungsetiawan.smsbroadcaster.repository.GrupRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author blinkawan
 */
public class GrupService {
    
    private GrupRepository grupRepository;
    private Connection connection;
    
    public void setDataSource(DataSource dataSource) throws SQLException{
        try{
            connection=dataSource.getConnection();
            grupRepository=new GrupRepository();
            grupRepository.setConnection(connection);
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
    }
    
    public void save(Grup grup) throws SQLException{
        try{
            connection.setAutoCommit(false);
            grupRepository.save(grup);
            connection.commit();
            connection.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                connection.rollback();
            }catch(SQLException e){
                e.printStackTrace();
            }
            throw new SQLException(ex.toString());
        }
    }
    
    public void update(Grup grup) throws SQLException{
        try{
            connection.setAutoCommit(false);
            grupRepository.update(grup);
            connection.commit();
            connection.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                connection.rollback();
            }catch(SQLException e){
                e.printStackTrace();
            }
            throw new SQLException(ex.toString());
        }
    }
    
    public Grup findOne(Long id) throws SQLException{
        try{
            return grupRepository.findOne(id);
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
        
    }
    
    public List<Grup> findAll() throws SQLException{
        try{
            return grupRepository.findAll();
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
        
    }
    
    public void delete(Long id) throws SQLException{
        try{
            connection.setAutoCommit(false);
            grupRepository.delete(id);
            connection.commit();
            connection.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                connection.rollback();
            }catch(SQLException e){
                e.printStackTrace();
            }                
            throw new SQLException(ex.toString());
        }
    }
}
