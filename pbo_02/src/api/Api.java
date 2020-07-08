/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import Response.ODPResponse;
import Response.PDPResponse;
import Response.InformasiResponse;
import Response.PenggunaResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author gabri
 */
public interface Api {
    
       //Pengguna
    @FormUrlEncoded
    @POST("userLogin")
    Call<ResponseBody> userlogin(
            @Field("email") String email,
            @Field("password") String password);
    
    @GET("allUser")
    Call<PenggunaResponse> allPengguna();
    
    @FormUrlEncoded
    @POST("createUser")
    Call<ResponseBody> createUser(
            @Field("nik") String nik,
            @Field("nama") String nama,
            @Field("gender") String gender,
            @Field("tanggal_lahir") String tanggal_lahir,
            @Field("email") String email,
            @Field("password") String password,
            @Field("alamat") String alamat,
            @Field("peran") String peran);
    
    
    @FormUrlEncoded
    @POST("updateUser")
    Call<ResponseBody> updateUser(
            @Field("id") int id,
            @Field("nik") String nik,
            @Field("nama") String nama,
            @Field("gender") String gender,
            @Field("tanggal_lahir") String tanggal_lahir,
            @Field("email") String email,
            @Field("password") String password,
            @Field("alamat") String alamat,
            @Field("peran") String peran);
   
    
    @GET("deleteUser/{id}")
    Call<ResponseBody> deleteUser(@Path("id") int id);
    
    //Informasi
      
    @GET("allInfo")
    Call<InformasiResponse> allInformasi();
    
    @FormUrlEncoded
    @POST("createInfo")
    Call<ResponseBody> createInfo(
            @Field("tanggal") String tanggal,
            @Field("judul") String judul,
            @Field("isi_info") String isi_info);
    
    
    @FormUrlEncoded
    @POST("updateInfo")
    Call<ResponseBody> updateInfo(
            @Field("id") int id,
            @Field("tanggal") String tanggal,
            @Field("judul") String judul,
            @Field("isi_info") String isi_info);
   
    
    @GET("deleteInfo/{id}")
    Call<ResponseBody> deleteInfo(@Path("id") int id);
    
    //ODP
      
    @GET("allOdp")
    Call<ODPResponse> allOdp();
    
    @FormUrlEncoded
    @POST("createOdp")
    Call<ResponseBody> createOdp(
            @Field("tanggal") String tanggal,
            @Field("jumlah") String jumlah);
    
    
    @FormUrlEncoded
    @POST("updateOdp")
    Call<ResponseBody> updateOdp(
            @Field("id") int id,
            @Field("tanggal") String tanggal,
            @Field("jumlah") String jumlah);
   
    
    @GET("deleteOdp/{id}")
    Call<ResponseBody> deleteOdp(@Path("id") int id);
    
    //PDP
      
    @GET("allPdp")
    Call<PDPResponse> allPdp();
    
    @FormUrlEncoded
    @POST("createPdp")
    Call<ResponseBody> createPdp(
            @Field("tanggal") String tanggal,
            @Field("jumlah") String jumlah);
    
    
    @FormUrlEncoded
    @POST("updatePdp")
    Call<ResponseBody> updatePdp(
            @Field("id") int id,
            @Field("tanggal") String tanggal,
            @Field("jumlah") String jumlah);
   
    
    @GET("deletePdp/{id}")
    Call<ResponseBody> deletePdp(@Path("id") int id);
}
