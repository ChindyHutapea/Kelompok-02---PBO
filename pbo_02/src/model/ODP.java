/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author ITD
 */
public class ODP {
    
    @SerializedName("id")
    private int id;
     
    @SerializedName("tanggal")
    private String tanggal;
      
    @SerializedName("jumlah")
    private String jumlah;

    public ODP(int id, String tanggal, String jumlah) {
        this.id = id;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
}
