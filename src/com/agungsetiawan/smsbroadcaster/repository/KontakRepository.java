package com.agungsetiawan.smsbroadcaster.repository;

import com.agungsetiawan.smsbroadcaster.entity.Grup;
import com.agungsetiawan.smsbroadcaster.entity.Kontak;
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
public class KontakRepository {
    
    private Connection connection;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public void save(Kontak kontak) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("INSERT into pbk(Name,Number,GroupID)"
                + "values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, kontak.getNama());
        ps.setString(2, kontak.getNomor());
        ps.setLong(3, kontak.getGrup().getId());
        int id=ps.executeUpdate();
        Long idKontak=new Long(id);
        kontak.setId(idKontak);
    }
    
    public void update(Kontak kontak) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("UPDATE pbk SET Name=?, Number=?, GroupID=? where ID=?");
        ps.setString(1, kontak.getNama());
        ps.setString(2, kontak.getNomor());
        ps.setLong(3, kontak.getGrup().getId());
        ps.setLong(4, kontak.getId());
        ps.executeUpdate();
    }
    
    public void delete(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("DELETE from pbk where ID=?");
        ps.setLong(1, id);
        ps.executeUpdate();
    }
    
    public Kontak findOne(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("select pbk.ID,pbk.Name,pbk.Number,pbk_groups.ID as idGrup,pbk_groups.Name as grupName from pbk "
                + "inner join pbk_groups on(pbk.GroupID=pbk_groups.ID) where pbk.ID=?");
        ps.setLong(1, id);
        ResultSet rs=ps.executeQuery();
        
        Kontak kontak=new Kontak();
        Grup grup=new Grup();
        while(rs.next()){
            kontak.setId(rs.getLong("ID"));
            kontak.setNama(rs.getString("Name"));
            kontak.setNomor(rs.getString("Number"));
            
            grup.setId(rs.getLong("idGrup"));
            grup.setNama(rs.getString("grupName"));
            
            kontak.setGrup(grup);
        }
        
        return kontak;
    }
    
    public Kontak findOneByNumber(String number) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("select pbk.ID,pbk.Name,pbk.Number,pbk_groups.ID as idGrup,pbk_groups.Name as grupName from pbk "
                + "inner join pbk_groups on(pbk.GroupID=pbk_groups.ID) where pbk.Number=?");
        ps.setString(1, number);
        ResultSet rs=ps.executeQuery();
        
        Kontak kontak=new Kontak();
        Grup grup=new Grup();
        while(rs.next()){
            kontak.setId(rs.getLong("ID"));
            kontak.setNama(rs.getString("Name"));
            kontak.setNomor(rs.getString("Number"));
            
            grup.setId(rs.getLong("idGrup"));
            grup.setNama(rs.getString("grupName"));
            
            kontak.setGrup(grup);
        }
        
        return kontak;
    }
    
    public List<Kontak> findByGrup(Long id) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("select pbk.ID,pbk.Name,pbk.Number,pbk_groups.ID as idGrup,pbk_groups.Name as grupName from pbk inner join pbk_groups on(pbk.GroupID=pbk_groups.ID)WHERE pbk_groups.ID=? ORDER BY pbk.Name");
        ps.setLong(1, id);
        ResultSet rs=ps.executeQuery();
        
        List<Kontak> listKontak=new ArrayList<Kontak>();
        
        while(rs.next()){
            
            Kontak kontak=new Kontak();
            Grup grup=new Grup();
            kontak.setId(rs.getLong("ID"));
            kontak.setNama(rs.getString("Name"));
            kontak.setNomor(rs.getString("Number"));
            
            grup.setId(rs.getLong("idGrup"));
            grup.setNama(rs.getString("grupName"));
            
            kontak.setGrup(grup);
            
            listKontak.add(kontak);
        }
        
        return listKontak;
    }
    
    public List<Kontak> findAll() throws SQLException{
        PreparedStatement ps=connection.prepareStatement("select pbk.ID,pbk.Name,pbk.Number,pbk_groups.ID as idGrup,pbk_groups.Name as grupName from pbk "
                + "inner join pbk_groups on(pbk.GroupID=pbk_groups.ID)"
                + "ORDER BY pbk.Name");
        ResultSet rs=ps.executeQuery();
        
        List<Kontak> listKontak=new ArrayList<Kontak>();
        
        while(rs.next()){
            
            Kontak kontak=new Kontak();
            Grup grup=new Grup();
            kontak.setId(rs.getLong("ID"));
            kontak.setNama(rs.getString("Name"));
            kontak.setNomor(rs.getString("Number"));
            
            grup.setId(rs.getLong("idGrup"));
            grup.setNama(rs.getString("grupName"));
            
            kontak.setGrup(grup);
            
            listKontak.add(kontak);
        }
        
        return listKontak;
    }
}
