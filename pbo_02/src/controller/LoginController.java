/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.RetrofitClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import pbo_02.Pbo_02;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import api.Api;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField tfEmailLogin;

    @FXML
    private PasswordField tfPasswordLogin;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane root;
    
    @FXML
    void onClickButtonReset(ActionEvent event) {
        tfEmailLogin.setText("");
        tfPasswordLogin.setText("");
     

    }

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          if(!Pbo_02.isSplashLoaded){
           loadSplashScreen();
       }
    }

 private void loadSplashScreen(){
        try {
            Pbo_02.isSplashLoaded=true;            
             
            StackPane pane = FXMLLoader.load(getClass().getResource("/view/splashscreen.fxml"));
            root.getChildren().setAll(pane);
            
            FadeTransition fadeIn=new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            
            FadeTransition fadeOut=new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);
            
            fadeIn.play();
            
              fadeIn.setOnFinished((e)->{
                fadeOut.play();
            });
            
            fadeOut.setOnFinished((e)->{
                try {
                    AnchorPane parentContext=FXMLLoader.load(getClass().getResource("/view/login.fxml"));
                    root.getChildren().setAll(parentContext);
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   


   @FXML
   void onClickLogin(ActionEvent event) {
       Preferences loginPreferences=Preferences.userRoot();
        Api api=RetrofitClient.getRetrofit().create(Api.class);
        
        api.userlogin(tfEmailLogin.getText().toString(), tfPasswordLogin.getText().toString())
                .enqueue(new Callback<ResponseBody>(){
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try{
                        JSONObject result=new JSONObject(response.body().string());
                        if(result.getString("status").equals("Admin Login succesfully")){
                            loginPreferences.put("email", result.getString("email"));
                            loginPreferences.put("password", result.getString("password"));
                            Platform.runLater(() -> {   
                                    try{
                                        FXMLLoader pindah = new FXMLLoader(getClass().getResource("/view/Dashboard_Admin.fxml"));
                                        Parent root = pindah.load();

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
                        
                        else if(result.getString("status").equals("Masyarakat Login succesfully")){
                            loginPreferences.put("email", result.getString("email"));
                            loginPreferences.put("password", result.getString("password"));
                            Platform.runLater(() -> {   
                                    try{
                                        FXMLLoader pindah = new FXMLLoader(getClass().getResource("/view/Dashboard_Masyarakat.fxml"));
                                        Parent root = pindah.load();

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
                            JOptionPane.showMessageDialog(null, "Email atau password salah", "WARNING", JOptionPane.WARNING_MESSAGE);
                        }
                        
                    } catch (JSONException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                System.out.println("error"+throwable.getMessage());            }
                    
                });
    } 
    
}
