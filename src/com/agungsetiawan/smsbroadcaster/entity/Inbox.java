
package com.agungsetiawan.smsbroadcaster.entity;

/**
 *
 * @author blinkawan
 */
public class Inbox {
    
    private Long id;
    private String senderNumber;
    private String textDecoded;
    private Kontak kontak;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getTextDecoded() {
        return textDecoded;
    }

    public void setTextDecoded(String textDecoded) {
        this.textDecoded = textDecoded;
    }

    public Kontak getKontak() {
        return kontak;
    }

    public void setKontak(Kontak kontak) {
        this.kontak = kontak;
    }
    
}
