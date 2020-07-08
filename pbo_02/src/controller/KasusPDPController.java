/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Response.PDPResponse;
import api.Api;
import api.RetrofitClient;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.PDP;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author ITD
 */
public class KasusPDPController implements Initializable {
    
    @FXML
    private Label lbOut;

    @FXML
    private Label lbExit;
    
    @FXML
    private TableView<PDP> tablePDP;

    @FXML
    private TableColumn<PDP, String> col_id;

    @FXML
    private TableColumn<PDP, String> col_tanggal;

    @FXML
    private TableColumn<PDP, String> col_jumlah;
    
    ObservableList<PDP> observableList = FXCollections.observableArrayList(); 
    

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
    void onClickInformasi(ActionEvent event) throws IOException {
        FXMLLoader pindah4=new FXMLLoader(getClass().getResource("/view/Informasi.fxml"));
        Parent root=pindah4.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickKasusODP(ActionEvent event) throws IOException {
        FXMLLoader pindah6=new FXMLLoader(getClass().getResource("/view/KasusODP.fxml"));
        Parent root=pindah6.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    void onClickKasusPDP(ActionEvent event) throws IOException {
        FXMLLoader pindah7=new FXMLLoader(getClass().getResource("/view/KasusPDP.fxml"));
        Parent root=pindah7.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        tampilPDP();
    }
    
         private void tampilPDP() {
         Api api=RetrofitClient.getRetrofit().create(Api.class);
        
        Call<PDPResponse> call=api.allPdp();
        call.enqueue(new Callback<PDPResponse>(){
            @Override
            public void onResponse(Call<PDPResponse> call, Response<PDPResponse> response) {
                if(response.isSuccessful()){
                    int size=response.body().getPDP().size();
                    List<PDP> listPDP=response.body().getPDP();
                    
                    for(int i=0; i<size; i++){
                      
                        observableList.add(new PDP(listPDP.get(i).getId(), listPDP.get(i).getTanggal(), listPDP.get(i).getJumlah()));                         
                    }
                    
                    col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    col_tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
                    col_jumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
                 
                    tablePDP.setItems(observableList);
                }
                else{
                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<PDPResponse> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
}
