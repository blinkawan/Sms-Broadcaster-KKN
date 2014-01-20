
package com.agungsetiawan.smsbroadcaster.service;

import com.agungsetiawan.smsbroadcaster.entity.SentItem;
import com.agungsetiawan.smsbroadcaster.repository.SentItemRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author blinkawan
 */
public class SentItemService {
    
    private SentItemRepository sentItemRepository;
    private Connection connection;
    
    public void setDataSource(DataSource dataSource){
        try{
            connection=dataSource.getConnection();
            sentItemRepository=new SentItemRepository();
            sentItemRepository.setConnection(connection);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public SentItem findOne(Long id){
        try{
            return sentItemRepository.findOne(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public List<SentItem> findAll(){
        try{
            return sentItemRepository.findAll();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void delete(Long id){
        try{
            connection.setAutoCommit(false);
            sentItemRepository.delete(id);
            connection.commit();
            connection.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                connection.rollback();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
