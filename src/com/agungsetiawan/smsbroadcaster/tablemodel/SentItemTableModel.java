
package com.agungsetiawan.smsbroadcaster.tablemodel;

import com.agungsetiawan.smsbroadcaster.entity.SentItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author blinkawan
 */
public class SentItemTableModel extends AbstractTableModel{
    
    List<SentItem> sentItems=new ArrayList<SentItem>();
    
    private String[] header={"Tujuan","Nomor","Pesan"};
    
    public SentItemTableModel(List<SentItem> sentItems){
        this.sentItems=sentItems;
    }
    
    public void delete(int index){
        sentItems.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public SentItem findOne(int index){
        return sentItems.get(index);
    }

    public int getRowCount() {
        return sentItems.size();
    }

    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        SentItem sentItem=sentItems.get(rowIndex);
        
        switch(columnIndex){
            case 0: return sentItem.getKontak().getNama();
            case 1: return sentItem.getDestinationNumber();
            case 2: return sentItem.getTextDecoded();
            default: return null;
        }
    }
    
}
