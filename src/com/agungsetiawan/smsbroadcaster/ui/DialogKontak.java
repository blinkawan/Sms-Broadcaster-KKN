
package com.agungsetiawan.smsbroadcaster.ui;

import com.agungsetiawan.smsbroadcaster.App;
import com.agungsetiawan.smsbroadcaster.custom.JButtonTransparant;
import com.agungsetiawan.smsbroadcaster.entity.Kontak;
import com.agungsetiawan.smsbroadcaster.tablemodel.KontakTableModel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author blinkawan
 */
public class DialogKontak extends javax.swing.JDialog {

    /**
     * Creates new form DialogKontak
     */
    KontakTableModel kontakTableModel;

    public KontakTableModel getKontakTableModel() {
        return kontakTableModel;
    }

    public JTable getjTable1() {
        return jTable1;
    }
    
    public DialogKontak(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        
       try{
            kontakTableModel=new KontakTableModel(App.getKontakService().findAll());
            jTable1.setModel(kontakTableModel);
       }catch(Exception ex){
           ex.printStackTrace();
           throw new Exception(ex.toString());
       }
       
        setLocationRelativeTo(null);
        
        JLabel jLabel=new JLabel();
        jLabel.setIcon(new ImageIcon(FormUtama.class.getResource("wood1.jpg")));
        jLabel.setBounds(0, 0, 723, 477);
        this.add(jLabel);
        
        jScrollPane1.setOpaque(false);
         jScrollPane1.getViewport().setOpaque(false);
        jTable1.setShowGrid(false);
        
        getRootPane().setGlassPane(new JComponent()
		{
            @Override
            public void paintComponent(Graphics g) 
            {
                g.setColor(new Color(0, 0, 0, 100));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonTambah = new JButtonTransparant();
        jButtonUbah = new JButtonTransparant();
        jButtonHapus = new JButtonTransparant();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Kontak");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonTambah.setText("Tambah");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jButtonUbah.setText("Ubah");
        jButtonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUbahActionPerformed(evt);
            }
        });

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHapus))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTambah)
                    .addComponent(jButtonUbah)
                    .addComponent(jButtonHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        // TODO add your handling code here:
        
        if(jTable1.getSelectedRowCount()<1){
            getRootPane().getGlassPane().setVisible(true);
            JOptionPane.showMessageDialog(rootPane, "Pilih Data yang Akan dihapus Terlebih Dahulu");
            getRootPane().getGlassPane().setVisible(false);
            return;
        }
        
        int row=jTable1.getSelectedRow();     
        Kontak kontak=kontakTableModel.findOne(row);
                
        getRootPane().getGlassPane().setVisible(true);
        int jawab=JOptionPane.showConfirmDialog(rootPane, "Yakin Akan Menghapus Data "+kontak.getNama()+" ?");
        if(jawab==JOptionPane.YES_OPTION){
            try{
                App.getKontakService().delete(kontak.getId());
                kontakTableModel.delete(row);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil dihapus");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Data Gagal dihapus");
            }
        }
        getRootPane().getGlassPane().setVisible(false);
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
        try{
            getRootPane().getGlassPane().setVisible(true);
            DialogTambahKontak dialogTambahKontak=new DialogTambahKontak(null, true);
            dialogTambahKontak.setDialogKontak(this);
            dialogTambahKontak.setVisible(true);
            getRootPane().getGlassPane().setVisible(false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Gagal Memuat Data Grup");

        }finally{
            getRootPane().getGlassPane().setVisible(false);
        }
    }//GEN-LAST:event_jButtonTambahActionPerformed

    private void jButtonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUbahActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount()<1){
            getRootPane().getGlassPane().setVisible(true);
            JOptionPane.showMessageDialog(rootPane, "Pilih Terlebih Dahulu Data yang Akan diubah");
            getRootPane().getGlassPane().setVisible(false);
            return;
        }
        
        
        try{
            getRootPane().getGlassPane().setVisible(true);    
            DialogEditKontak dialogEditKontak=new DialogEditKontak(null, true);
            dialogEditKontak.setDialogKontak(this);
            dialogEditKontak.setVisible(true);
            getRootPane().getGlassPane().setVisible(false);
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Gagal Memuat Data Grup");
        }finally{
            getRootPane().getGlassPane().setVisible(false);
        }
        
        
        
    }//GEN-LAST:event_jButtonUbahActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JButton jButtonUbah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
