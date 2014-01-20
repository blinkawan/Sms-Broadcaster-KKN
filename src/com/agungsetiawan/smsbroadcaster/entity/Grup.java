package com.agungsetiawan.smsbroadcaster.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blinkawan
 */
public class Grup {
    
    private Long id;
    private String nama;
    private List<Kontak> listKontak=new ArrayList<Kontak>();

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

    public List<Kontak> getListKontak() {
        return listKontak;
    }

    public void setListKontak(List<Kontak> listKontak) {
        this.listKontak = listKontak;
    }
    
    @Override
    public String toString(){
        return this.nama;
    }

}
