package com.agungsetiawan.smsbroadcaster.entity;

/**
 *
 * @author blinkawan
 */
public class Kontak {
    
    private Long id;
    private String nama;
    private String nomor;
    private Grup grup=new Grup();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }
    
    @Override
    public String toString(){
        return this.nama;
    }
    
}
