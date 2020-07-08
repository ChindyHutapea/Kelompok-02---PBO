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
public class Pengguna {
     @SerializedName("id")
    private int id;
    
    @SerializedName("nik")
    private String nik;
    
    @SerializedName("nama")
    private String nama;
    
    @SerializedName("gender")
    private String gender;
    
    @SerializedName("tanggal_lahir")
    private String tanggal_lahir;
    
    @SerializedName("email")
    private String email;
    
    @SerializedName("password")
    private String password;
    
      
    @SerializedName("alamat")
    private String alamat;
    
    @SerializedName("peran")
    private String peran;

    public Pengguna(int id, String nik, String nama, String gender, String tanggal_lahir, String email, String password, String alamat, String peran) {
        this.id = id;
        this.nik = nik;
        this.nama = nama;
        this.gender = gender;
        this.tanggal_lahir = tanggal_lahir;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.peran = peran;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    
   
    
}
