package com.agungsetiawan.smsbroadcaster.entity;

/**
 *
 * @author blinkawan
 */
public class Outbox {
    
    private Long id;
    private String destinationNumber;
    private String textDecoded;
    private Kontak kontak;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kontak getKontak() {
        return kontak;
    }

    public void setKontak(Kontak kontak) {
        this.kontak = kontak;
    }
    
    public String getDestinationNumber() {
        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    public String getTextDecoded() {
        return textDecoded;
    }

    public void setTextDecoded(String textDecoded) {
        this.textDecoded = textDecoded;
    }
    
}
