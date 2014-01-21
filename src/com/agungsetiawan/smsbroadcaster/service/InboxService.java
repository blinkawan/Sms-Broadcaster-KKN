
package com.agungsetiawan.smsbroadcaster.service;

import com.agungsetiawan.smsbroadcaster.entity.Inbox;
import com.agungsetiawan.smsbroadcaster.repository.InboxRepository;
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
public class InboxService {
    
    private InboxRepository inboxRepository;
    private Connection connection;
    
    public void setDataSource(DataSource dataSource) throws SQLException{
        try {
            connection=dataSource.getConnection();
            inboxRepository=new InboxRepository();
            inboxRepository.setConnection(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
    }
    
    public Inbox findOne(Long id) throws SQLException{
        try{
            return inboxRepository.findOne(id);
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
        
    }
    
    public List<Inbox> findAll() throws SQLException{
        try{
            return inboxRepository.findAll();
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
        
    }
}
