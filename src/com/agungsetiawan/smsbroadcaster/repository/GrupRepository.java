package com.agungsetiawan.smsbroadcaster.repository;

import com.agungsetiawan.smsbroadcaster.entity.Grup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blinkawan
 */
public class GrupRepository {
    
    private Connection connection;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public void save(Grup grup) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("INSERT INTO pbk_groups(Name) values(?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, grup.getNama());
        int id=ps.executeUpdate();
        Long idGrup=new Long(id);
        grup.setId(idGrup);
    }
    
    public void update(Grup grup) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("UPDATE pbk_groups SET Name=? where ID=?");
        ps.setString(1, grup.getNama());
        ps.setLong(2, grup.getId());
        ps.executeUpdate();
    }
    
    public Grup findOne(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("SELECT * FROM pbk_groups WHERE ID=?");
        ps.setLong(1, id);
        ResultSet rs=ps.executeQuery();
        
        Grup grup=new Grup();
        
        while(rs.next()){
            grup.setId(rs.getLong("ID"));
            grup.setNama(rs.getString("Name"));
        }
        
        return grup;
    }
    
    public List<Grup> findAll() throws SQLException{
        PreparedStatement ps=connection.prepareStatement("SELECT * FROM pbk_groups");
        ResultSet rs=ps.executeQuery();
        List<Grup> grups=new ArrayList<Grup>();
        
        while(rs.next()){
            Grup grup=new Grup();
            grup.setId(rs.getLong("ID"));
            grup.setNama(rs.getString("Name"));
            
            grups.add(grup);
        }
        
        return grups;
    }
    
//    public List<Grup> findAllWithKontak() throws SQLException{
//        PreparedStatement ps=connection.prepareStatement("SELECT g.*,k.Name,k.Number"
//                + "FROM pbk_groups g INNER JOIN pbk k"
//                + "on(g.ID=k.GroudID) ORDER BY g.Name");
//        ResultSet rs=ps.executeQuery();
//        
//        
//    }
    
    public void delete(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("DELETE FROM pbk_groups WHERE ID=?");
        ps.setLong(1, id);
        ps.executeUpdate();
    }
}
