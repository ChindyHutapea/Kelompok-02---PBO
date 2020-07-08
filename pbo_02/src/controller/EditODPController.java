/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.Api;
import api.RetrofitClient;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author ITD
 */
public class EditODPController implements Initializable {
    
      @FXML
    private Label lbOut;

    @FXML
    private Label lbExit;
    int id;

    @FXML
    void menuExitClick(MouseEvent event) throws IOException {
            
        lbExit.setBackground(new Background(new BackgroundFill(Color.valueOf("#29B6F6"), CornerRadii.EMPTY, Insets.EMPTY)));
        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Select");
        alert1.setHeaderText("Apakah anda hendak keluar dari aplikasi ini?");
        Optional<ButtonType> option = alert1.showAndWait();
        
            if (option.get() == ButtonType.OK) {
                      System.exit(0);;
             } 
            else if (option.get() == ButtonType.CANCEL) {
                   FXMLLoader ganti9=new FXMLLoader(getClass().getResource("/view/Dashboard_Masyarakat.fxml"));
                   Parent utama9=ganti9.load();
                   Stage stage9=(Stage)((Node)event.getSource()).getScene().getWindow();
                   Scene scene9=new Scene(utama9);
                   stage9.setScene(scene9);
                   stage9.show();
      } 
    }

    @FXML
    void menuOutClick(MouseEvent event) throws IOException {
        lbOut.setBackground(new Background(new BackgroundFill(Color.valueOf("#48D1CC"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("Apakah anda yakin ingin logout?");
        Optional<ButtonType> option = alert.showAndWait();
        
     if (option.get() == ButtonType.OK) {
            FXMLLoader ganti5=new FXMLLoader(getClass().getResource("/view/login.fxml"));
            Parent utama5=ganti5.load();
            Stage stage5=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene5=new Scene(utama5);
            stage5.setScene(scene5);
            stage5.show();
      } else if (option.get() == ButtonType.CANCEL) {
            FXMLLoader ganti8=new FXMLLoader(getClass().getResource("/view/Dashboard_Masyarakat.fxml"));
            Parent utama8=ganti8.load();
            Stage stage8=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene8=new Scene(utama8);
            stage8.setScene(scene8);
            stage8.show();
      } 
    }

    @FXML
    void onClickDashboard(ActionEvent event) throws IOException {
        FXMLLoader pindah3=new FXMLLoader(getClass().getResource("/view/Dashboard_Masyarakat.fxml"));
        Parent root=pindah3.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickKelolaInformasi(ActionEvent event) throws IOException {
        FXMLLoader pindah4=new FXMLLoader(getClass().getResource("/view/Kelola_Informasi.fxml"));
        Parent root=pindah4.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickKelolaKasusODP(ActionEvent event) throws IOException {
        FXMLLoader pindah6=new FXMLLoader(getClass().getResource("/view/Kelola_kasusODP.fxml"));
        Parent root=pindah6.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    void onClickKelolaKasusPDP(ActionEvent event) throws IOException {
        FXMLLoader pindah7=new FXMLLoader(getClass().getResource("/view/Kelola_kasusPDP.fxml"));
        Parent root=pindah7.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onClickKelolaMasyarakat(ActionEvent event) throws IOException {
        FXMLLoader pindah5=new FXMLLoader(getClass().getResource("/view/Kelola_Masyarakat.fxml"));
        Parent root=pindah5.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();

    }
    

    @FXML
    private TextField tf_tanggal;

    @FXML
    private TextField tf_jumlah;



    @FXML
    void onClickEditODP(ActionEvent event) {
     Api api = RetrofitClient.getRetrofit().create(Api.class);
           System.out.println(id);
           Preferences preferences = Preferences.userRoot(); 
    
            api.updateOdp(id, tf_tanggal.getText().toString(), tf_jumlah.getText().toString())
                .enqueue(new Callback<ResponseBody>(){
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            preferences.remove("id");
                            preferences.remove("jumlah");

                            Platform.runLater(() -> {   
                                try{
                                    FXMLLoader pinda2 = new FXMLLoader(getClass().getResource("/view/Kelola_kasusODP.fxml"));
                                    Parent root = pinda2.load();

                                    Scene scene = new Scene(root);
                                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    stage.setScene(scene);
                                    stage.centerOnScreen();
                                    stage.show();
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            });
                        }
                        else{
                            System.out.println(response.message());
                        }
                    }
                    
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable thrwbl) {
                        System.out.println("Error message: "+ thrwbl.getMessage());
                    }                     
                 });  
    }




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Preferences preferences = Preferences.userRoot();
       tf_tanggal.setText(getTanggal());
       tf_jumlah.setText(preferences.get("jumlah", null));
  
        id = preferences.getInt("id", 0);
    
    }  
    
       private String getTanggal() {  
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        Date date = new Date();  
        return dateFormat.format(date);  
    }
    
}
