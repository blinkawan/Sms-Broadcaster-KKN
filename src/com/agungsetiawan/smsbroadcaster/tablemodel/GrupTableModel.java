
package com.agungsetiawan.smsbroadcaster.tablemodel;

import com.agungsetiawan.smsbroadcaster.entity.Grup;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author blinkawan
 */
public class GrupTableModel extends AbstractTableModel{
    
    private List<Grup> grups=new ArrayList<Grup>();
    private String[] header={"Nama Grup"};
    
    public GrupTableModel(List<Grup> grups){
        this.grups=grups;
    }
    
    public void save(Grup grup){
        grups.add(grup);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public void update(int index,Grup grup){
        grups.set(index, grup);
        fireTableRowsUpdated(index, index);
    }
    
    public void delete(int index){
        grups.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public Grup findOne(int index){
        return grups.get(index);
    }

    public int getRowCount() {
        return grups.size();
    }

    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int index){
        return header[index];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Grup grup=grups.get(rowIndex);
        
        switch(columnIndex){
            case 0: return grup.getNama();
            default: return null;
        }
    }
    
}
