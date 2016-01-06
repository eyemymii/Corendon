/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corendon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author warie_000
 */
public class KofferIndexController implements Initializable {
    @FXML
    private Label lblEmail;
    @FXML
    private Button gaatNaarHome;
    @FXML
    private Button gaatNaarKlanten;
    @FXML
    private Button gaatNaarKoffers;
    @FXML
    private Button gaatNaarGebruikers;
    @FXML
    private Button gaatNaarHelp;
    @FXML
    private Button logtUit;
    @FXML
    private Button gaatNaarKofferToevoegen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gaNaarHome(ActionEvent event) {
    }

    @FXML
    private void gaNaarKlanten(ActionEvent event) {
    }

    @FXML
    private void gaNaarKoffers(ActionEvent event) {
    }

    @FXML
    private void gaNaarIndexGebruikers(ActionEvent event) {
    }

    @FXML
    private void gaNaarHelp(ActionEvent event) {
    }

    @FXML
    private void logUit(ActionEvent event) {
    }

/**
* void gaNaarKofferToevoegen(ActionEvent event) Gaat naar de pagina om koffer toe te voegen. 
* author Warisra
* @param event Als het op de knop wordt gedrukt, wordt de actie geïnitialiseerd
*/    
    @FXML
    private void gaNaarKofferToevoegen(ActionEvent event) throws IOException {
        //close previous window
            ((Node) event.getSource()).getScene().getWindow().hide();             
              
            //load new screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/corendon/KofferToevoegen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene((Pane) loader.load()));
            stage.setTitle("User");
            stage.show();
    }
    
}
