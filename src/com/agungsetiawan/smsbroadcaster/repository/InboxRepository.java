
package com.agungsetiawan.smsbroadcaster.repository;

import com.agungsetiawan.smsbroadcaster.entity.Inbox;
import com.agungsetiawan.smsbroadcaster.entity.Kontak;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blinkawan
 */
public class InboxRepository {
     
    private Connection connection;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public Inbox findOne(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("SELECT i.ID,i.SenderNumber,i.TextDecoded,k.ID as kID,k.Name,k.Number"
                                                         + " from inbox i LEFT JOIN pbk k on(i.SenderNumber=k.Number)"
                                                          + " WHERE i.ID=?");
        ps.setLong(1, id);
        ResultSet rs=ps.executeQuery();
        
        Inbox inbox=new Inbox();
        Kontak kontak=new Kontak();
        
        while(rs.next()){
            inbox.setId(rs.getLong("ID"));
            inbox.setSenderNumber(rs.getString("SenderNumber"));
            inbox.setTextDecoded(rs.getString("TextDecoded"));
            
            kontak.setId(rs.getLong("kID"));
            kontak.setNomor(rs.getString("Number"));
            kontak.setNama(rs.getString("Name"));
            
            inbox.setKontak(kontak);
        }
        
        return inbox;
    }
    
    public List<Inbox> findAll() throws SQLException{
        PreparedStatement ps=connection.prepareStatement("SELECT i.ID,i.SenderNumber,i.TextDecoded,k.ID as kID,k.Name,k.Number"
                                                         + " from inbox i LEFT JOIN pbk k on(i.SenderNumber=k.Number)"
                                                          );
        ResultSet rs=ps.executeQuery();
        List<Inbox> inboxes=new ArrayList<Inbox>();
        while(rs.next()){
            Inbox inbox=new Inbox();
            Kontak kontak=new Kontak();
        
            inbox.setId(rs.getLong("ID"));
            inbox.setSenderNumber(rs.getString("SenderNumber"));
            inbox.setTextDecoded(rs.getString("TextDecoded"));
            
            kontak.setId(rs.getLong("kID"));
            kontak.setNomor(rs.getString("Number"));
            kontak.setNama(rs.getString("Name"));
            
            inbox.setKontak(kontak);
            
            inboxes.add(inbox);
        }
        
        return inboxes;
    }
}
