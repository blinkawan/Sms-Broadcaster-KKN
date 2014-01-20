
package com.agungsetiawan.smsbroadcaster.tablemodel;

import com.agungsetiawan.smsbroadcaster.entity.Kontak;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author blinkawan
 */
public class KontakTableModel extends AbstractTableModel{
    private List<Kontak> kontaks=new ArrayList<Kontak>();
    private String[] header={"Nama","Nomor","Grup"};
    
    public KontakTableModel(List<Kontak> kontaks){
        this.kontaks=kontaks;
    }
    
    public void save(Kontak kontak){
        kontaks.add(kontak);
        fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
    }
    
    public void update(int index,Kontak kontak){
        kontaks.set(index, kontak);
        fireTableRowsUpdated(index, index);
    }
    
    public void delete(int index){
        kontaks.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public Kontak findOne(int index){
        return kontaks.get(index);
    }

    public int getRowCount() {
        return kontaks.size();
    }

    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int index){
        return header[index];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Kontak kontak=kontaks.get(rowIndex);
        
        switch(columnIndex){
            case 0: return kontak.getNama();
            case 1: return kontak.getNomor();
            case 2: return kontak.getGrup().getNama();
            default: return null;
        }
    }
}
