package com.agungsetiawan.smsbroadcaster.service;

import com.agungsetiawan.smsbroadcaster.entity.Outbox;
import com.agungsetiawan.smsbroadcaster.repository.OutboxRepository;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author blinkawan
 */
public class OutboxService {
    
    private OutboxRepository outboxRepository;
    private Connection connection;
    
    public void setDataSource(DataSource dataSource) throws SQLException{
        try{
            connection=dataSource.getConnection();
            outboxRepository=new OutboxRepository();
            outboxRepository.setConnection(connection);
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new SQLException(ex.toString());
        }
    }
    
    public void save(Outbox outbox){
        try{
            connection.setAutoCommit(false);
            outboxRepository.save(outbox);
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
}
