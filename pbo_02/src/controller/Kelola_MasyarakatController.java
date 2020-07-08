/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Response.PenggunaResponse;
import api.Api;
import api.RetrofitClient;
import java.io.IOException;
import java.net.URL;
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
import model.Pengguna;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class Kelola_MasyarakatController implements Initializable {
    
      @FXML
    private Label lbOut;

    @FXML
    private Label lbExit;
    
     @FXML
    private TableView<Pengguna> tableMasyarakat;

    @FXML
    private TableColumn<Pengguna, Integer> col_id;

    @FXML
    private TableColumn<Pengguna, String> col_nik;

    @FXML
    private TableColumn<Pengguna, String> col_nama;

    @FXML
    private TableColumn<Pengguna, String> col_gender;

    @FXML
    private TableColumn<Pengguna, String> col_tglLahir;

    @FXML
    private TableColumn<Pengguna, String> col_email;

    @FXML
    private TableColumn<Pengguna, String> col_password;

    @FXML
    private TableColumn<Pengguna, String> col_alamat;
    
    @FXML
    private TableColumn<Pengguna, String> col_peran;


    @FXML
    private TextField tf_nik;

    @FXML
    private TextField tf_nama;

    @FXML
    private TextField tf_gender;

    @FXML
    private TextField tf_tglLahir;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_alamat;
    
     @FXML
    private TextField tf_peran;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    ObservableList<Pengguna> observableList=FXCollections.observableArrayList();
    

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
                   FXMLLoader ganti9=new FXMLLoader(getClass().getResource("/view/Dashboard_Admin.fxml"));
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
            FXMLLoader ganti8=new FXMLLoader(getClass().getResource("/view/Dashboard_Admin.fxml"));
            Parent utama8=ganti8.load();
            Stage stage8=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene8=new Scene(utama8);
            stage8.setScene(scene8);
            stage8.show();
      } 
    }

    @FXML
    void onClickDashboard(ActionEvent event) throws IOException {
        FXMLLoader pindah3=new FXMLLoader(getClass().getResource("/view/Dashboard_Admin.fxml"));
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
    void onClickButtonDelete(ActionEvent event) {
        if(tableMasyarakat.getSelectionModel().getSelectedItem()!= null){
            Pengguna preferences = tableMasyarakat.getSelectionModel().getSelectedItem();
            System.out.println(preferences.getEmail());
            Api api = RetrofitClient.getRetrofit().create(Api.class);
            
            api.deleteUser(preferences.getId()).enqueue(new Callback<ResponseBody>(){
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                            Platform.runLater(() -> {
                                try{
                                    FXMLLoader pindahPengguna = new FXMLLoader(getClass().getResource("/view/Kelola_Masyarakat.fxml"));
                                    Parent parent1 = pindahPengguna.load();

                                    Scene scene = new Scene(parent1);
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
                public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                    System.out.println("Error: "+ throwable.getMessage());
                }
            });
        }
    }

    @FXML
    void onClickButtonReset(ActionEvent event) {
        tf_nik.setText("");
        tf_nama.setText("");
        tf_gender.setText("");
        tf_tglLahir.setText("");
        tf_email.setText("");
        tf_password.setText("");
        tf_alamat.setText("");
        tf_peran.setText("");
    }

    @FXML
    void onClickButtonTambah(ActionEvent event) {
        Preferences preferences=Preferences.userRoot();
        
        String nik=tf_nik.getText().toString();
        String nama=tf_nama.getText().toString();
        String gender=tf_gender.getText().toString();
        String tanggal_lahir=tf_tglLahir.getText().toString();
        String email=tf_email.getText().toString();
        String password=tf_password.getText().toString();
        String alamat=tf_alamat.getText().toString();
        String peran=tf_peran.getText().toString();
        
        Api api=RetrofitClient.getRetrofit().create(Api.class);
        api.createUser(nik, nama, gender, tanggal_lahir, email, password, alamat, peran).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Platform.runLater(() -> {   
                    try{
                        FXMLLoader pindahPengguna = new FXMLLoader(getClass().getResource("/view/Kelola_Masyarakat.fxml"));
                        Parent parents = pindahPengguna.load();
                        Scene scene = new Scene(parents);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();
                    }
                    catch(Exception e){
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        

    }

     @FXML
    void onClickButtonUpdate(ActionEvent event) {
           if(tableMasyarakat.getSelectionModel().getSelectedItem()!=null){
           Pengguna listPengguna = tableMasyarakat.getSelectionModel().getSelectedItem();
            
            Preferences preferences = Preferences.userRoot(); 
            preferences.putInt("id",listPengguna.getId());
            preferences.put("nik",listPengguna.getNik());
            preferences.put("nama",listPengguna.getNama());
            preferences.put("gender",listPengguna.getGender());
            preferences.put("tanggal_lahir",listPengguna.getTanggal_lahir());
            preferences.put("email",listPengguna.getEmail());
            preferences.put("password",listPengguna.getPassword());
            preferences.put("alamat",listPengguna.getAlamat());
            preferences.put("peran",listPengguna.getPeran());
            
            try{
                FXMLLoader pindaEdit = new FXMLLoader(getClass().getResource("/view/EditMasyarakat.fxml"));
                Parent parent11 = pindaEdit.load();

                Scene scene = new Scene(parent11);
                Stage myStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                myStage1.setScene(scene);
                myStage1.centerOnScreen();
                myStage1.show();
            }catch(Exception e){
                e.printStackTrace();
            }
            
         
        }
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Preferences loginPreferences = Preferences.userRoot();
        String info = loginPreferences.get("email",null);
        tampilPengguna();
    }    

    private void tampilPengguna() {
         Api api=RetrofitClient.getRetrofit().create(Api.class);
        
        Call<PenggunaResponse> call=api.allPengguna();
        call.enqueue(new Callback<PenggunaResponse>(){
            @Override
            public void onResponse(Call<PenggunaResponse> call, Response<PenggunaResponse> response) {
                if(response.isSuccessful()){
                    int size=response.body().getPengguna().size();
                    List<Pengguna> listPengguna=response.body().getPengguna();
                    
                    for(int i=0; i<size; i++){
                      
                        observableList.add(new Pengguna(listPengguna.get(i).getId(), listPengguna.get(i).getNik(), listPengguna.get(i).getNama(), listPengguna.get(i).getGender(), listPengguna.get(i).getTanggal_lahir(), listPengguna.get(i).getEmail(), listPengguna.get(i).getPassword(), listPengguna.get(i).getAlamat(), listPengguna.get(i).getPeran()));                         
                    }
                    
                    col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    col_nik.setCellValueFactory(new PropertyValueFactory<>("nik"));
                    col_nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
                    col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
                    col_tglLahir.setCellValueFactory(new PropertyValueFactory<>("tanggal_lahir"));
                    col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
                    col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                    col_alamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
                    col_peran.setCellValueFactory(new PropertyValueFactory<>("peran"));
                   
                    tableMasyarakat.setItems(observableList);
                }
                else{
                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<PenggunaResponse> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
    
}
