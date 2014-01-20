
package com.agungsetiawan.smsbroadcaster.repository;

import com.agungsetiawan.smsbroadcaster.entity.Kontak;
import com.agungsetiawan.smsbroadcaster.entity.SentItem;
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
public class SentItemRepository {
    private Connection connection;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public SentItem findOne(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("SELECT s.ID,s.DestinationNumber,s.TextDecoded,k.ID as kID,k.Name,k.Number"
                                                         + " from sentitems s LEFT JOIN pbk k on(s.DestinationNumber=k.Number)"
                                                          + " WHERE s.ID=?");
        ps.setLong(1, id);
        ResultSet rs=ps.executeQuery();
        
        SentItem item=new SentItem();
        Kontak kontak=new Kontak();
        
        while(rs.next()){
            item.setId(rs.getLong("ID"));
            item.setDestinationNumber(rs.getString("DestinationNumber"));
            item.setTextDecoded(rs.getString("TextDecoded"));
            
            kontak.setId(rs.getLong("kID"));
            kontak.setNama(rs.getString("Name"));
            kontak.setNomor(rs.getString("Number"));
            
            item.setKontak(kontak);
        }
        
        return item;
    }
    
    public List<SentItem> findAll() throws SQLException{
        PreparedStatement ps=connection.prepareStatement("SELECT s.ID,s.DestinationNumber,s.TextDecoded,k.ID as kID,k.Name,k.Number"
                                                         + " from sentitems s LEFT JOIN pbk k on(s.DestinationNumber=k.Number)"
                                                         +"ORDER BY ID DESC" );
        ResultSet rs=ps.executeQuery();
        
        List<SentItem> items=new ArrayList<SentItem>();
        
        while(rs.next()){
             SentItem item=new SentItem();
             Kontak kontak=new Kontak();
            
            item.setId(rs.getLong("ID"));
            item.setDestinationNumber(rs.getString("DestinationNumber"));
            item.setTextDecoded(rs.getString("TextDecoded"));
            
            kontak.setId(rs.getLong("kID"));
            kontak.setNama(rs.getString("Name"));
            kontak.setNomor(rs.getString("Number"));
            
            item.setKontak(kontak);
            
            items.add(item);
        }
        
        return items;
    }
    
    public void delete(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("DELETE FROM sentitems WHERE ID=?");
        ps.setLong(1, id);
        ps.executeUpdate();
    }
}
