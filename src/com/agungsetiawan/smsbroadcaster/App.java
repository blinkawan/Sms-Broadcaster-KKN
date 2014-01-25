package com.agungsetiawan.smsbroadcaster;

import com.agungsetiawan.smsbroadcaster.service.GrupService;
import com.agungsetiawan.smsbroadcaster.service.InboxService;
import com.agungsetiawan.smsbroadcaster.service.KontakService;
import com.agungsetiawan.smsbroadcaster.service.OutboxService;
import com.agungsetiawan.smsbroadcaster.service.SentItemService;
import com.agungsetiawan.smsbroadcaster.ui.FormUtama;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Hello world!
 *
 */
public class App {
    
    private static GrupService grupService;
    private static InboxService inboxService;
    private static KontakService kontakService;
    private static OutboxService outboxService;
    private static  SentItemService sentItemService;

    public static GrupService getGrupService() {
        return grupService;
    }

    public static InboxService getInboxService() {
        return inboxService;
    }

    public static KontakService getKontakService() {
        return kontakService;
    }

    public static OutboxService getOutboxService() {
        return outboxService;
    }

    public static SentItemService getSentItemService() {
        return sentItemService;
    }
    
    public static void main( String[] args ){
        
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("sms");
        
        try{
            grupService=new GrupService();
            grupService.setDataSource(dataSource);

            inboxService=new InboxService();
            inboxService.setDataSource(dataSource);

            kontakService=new KontakService();
            kontakService.setDataSource(dataSource);

            outboxService=new OutboxService();
            outboxService.setDataSource(dataSource);

            sentItemService=new SentItemService();
            sentItemService.setDataSource(dataSource);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error : \n"+ex);
            return;
        }
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

                    new FormUtama().setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
