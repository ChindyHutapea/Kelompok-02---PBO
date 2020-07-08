/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author gabri
 */
public class Informasi {
    
    @SerializedName("id")
    private int id;
     
    @SerializedName("tanggal")
    private String tanggal;
      
    @SerializedName("judul")
    private String judul;
       
    @SerializedName("isi_info")
    private String isi_info;

    public Informasi(int id, String tanggal, String judul, String isi_info) {
        this.id = id;
        this.tanggal = tanggal;
        this.judul = judul;
        this.isi_info = isi_info;
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

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi_info() {
        return isi_info;
    }

    public void setIsi_info(String isi_info) {
        this.isi_info = isi_info;
    }
    
    
    
    
}
