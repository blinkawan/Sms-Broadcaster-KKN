
package com.agungsetiawan.smsbroadcaster.repository;

import com.agungsetiawan.smsbroadcaster.entity.Outbox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author blinkawan
 */
public class OutboxRepository {
    
    private Connection connection;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public void save(Outbox outbox) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("INSERT INTO outbox(DestinationNumber,TextDecoded,CreatorID)"
                + " values(?,?,?)");
        ps.setString(1, outbox.getDestinationNumber());
        ps.setString(2, outbox.getTextDecoded());
        ps.setString(3, "Agung Setiawan");
        ps.executeUpdate();
    }
}
