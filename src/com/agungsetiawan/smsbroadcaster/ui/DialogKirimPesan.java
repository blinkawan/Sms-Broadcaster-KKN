package com.agungsetiawan.smsbroadcaster.ui;

import com.agungsetiawan.smsbroadcaster.App;
import com.agungsetiawan.smsbroadcaster.entity.Outbox;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.agungsetiawan.smsbroadcaster.custom.JButtonTransparant;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author blinkawan
 */
public class DialogKirimPesan extends javax.swing.JDialog {

    /**
     * Creates new form DialogKirimPesan
     */
    public JTextField getjTextFieldNomorTujuan() {
        return jTextFieldNomorTujuan;
    }
    
    DialogPilihNomor dialogPilihNomor;
    public DialogKirimPesan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        jProgressBarKirim.setIndeterminate(true);
                
        setLocationRelativeTo(null);
        
        
        JLabel jLabelBackground=new JLabel();
        jLabelBackground.setIcon(new ImageIcon(FormUtama.class.getResource("wood2.jpg")));
        jLabelBackground.setBounds(0, -95, 723, 477);
        jPanel1.add(jLabelBackground);
        
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
        
        busy(false);
        
    }
    
    private void busy(boolean bool){
        jTextFieldNomorTujuan.setEnabled(!bool);
        jTextAreaPesan.setEnabled(!bool);
        jProgressBarKirim.setVisible(bool);
        jButtonKirim.setEnabled(!bool);
        jButtonKirimKe.setEnabled(!bool);
        jButtonTutup.setEnabled(!bool);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonKirimKe = new javax.swing.JButton();
        jTextFieldNomorTujuan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaPesan = new javax.swing.JTextArea();
        jButtonKirim = new JButtonTransparant();
        jButtonTutup = new JButtonTransparant();
        jProgressBarKirim = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kirim Pesan");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jButtonKirimKe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonKirimKe.setForeground(new java.awt.Color(0, 102, 102));
        jButtonKirimKe.setText("Kirim Ke");
        jButtonKirimKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKirimKeActionPerformed(evt);
            }
        });

        jTextAreaPesan.setColumns(20);
        jTextAreaPesan.setRows(5);
        jScrollPane1.setViewportView(jTextAreaPesan);

        jButtonKirim.setText("Kirim");
        jButtonKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKirimActionPerformed(evt);
            }
        });

        jButtonTutup.setText("Tutup");
        jButtonTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jProgressBarKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButtonKirim)
                .addGap(5, 5, 5)
                .addComponent(jButtonTutup)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonKirimKe, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldNomorTujuan)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarKirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonKirim)
                        .addComponent(jButtonTutup)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNomorTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonKirimKe))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTutupActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonTutupActionPerformed

    private void jButtonKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKirimActionPerformed
      
        if(jTextFieldNomorTujuan.getText().trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Nomor Tidak Boleh Kosong");
            return;
        }
        
        if(jTextAreaPesan.getText().trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Pesan Tidak Boleh Kosong");
            return;
        }
        
        SwingWorker<String,String> swingWorker=new SwingWorker<String, String>() {

            @Override
            protected String doInBackground() throws Exception {
                busy(true);
                String[] nomors=jTextFieldNomorTujuan.getText().split(";");

                try{
                    Outbox outbox;
                    for(int i=0;i<nomors.length;i++){
                        outbox=new Outbox();
                        outbox.setDestinationNumber(nomors[i]);
                        outbox.setTextDecoded(jTextAreaPesan.getText());
                        App.getOutboxService().save(outbox);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, "Gagal Mengirim Pesan");
                }
                
                return "Pesan Berhasil Dikirim";
            }
            
            @Override
            public void done(){
                try{
                    String pesan=get();
                    JOptionPane.showMessageDialog(rootPane, pesan);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, "Pesan Gagal Dikirim");
                }finally{
                    busy(false);
                }
            }
        };
        
        swingWorker.execute();        
      
    }//GEN-LAST:event_jButtonKirimActionPerformed

    private void jButtonKirimKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKirimKeActionPerformed
        try{
            getRootPane().getGlassPane().setVisible(true);
            dialogPilihNomor=new DialogPilihNomor(null, true);
            dialogPilihNomor.setDialogKirimPesan(this);
            dialogPilihNomor.setVisible(true);
            getRootPane().getGlassPane().setVisible(false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Gagal Memuat Data Kontak");
        }finally{
            getRootPane().getGlassPane().setVisible(false);
        }
    }//GEN-LAST:event_jButtonKirimKeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogKirimPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogKirimPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogKirimPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogKirimPesan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogKirimPesan dialog = new DialogKirimPesan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonKirim;
    private javax.swing.JButton jButtonKirimKe;
    private javax.swing.JButton jButtonTutup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBarKirim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaPesan;
    private javax.swing.JTextField jTextFieldNomorTujuan;
    // End of variables declaration//GEN-END:variables
}
