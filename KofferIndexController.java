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
 * @author Rene
 */
public class KlantenIndexController implements Initializable {
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
    private Button logtUit, toevoegKlanten;
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
    
    @FXML
    private void toevoegenKlanten(ActionEvent event) throws IOException {
          ((Node) event.getSource()).getScene().getWindow().hide();             
              
                //load new screen
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/corendon/KlantenToevoegen.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene((Pane) loader.load()));
                stage.setTitle("Add Customer");
                stage.show();
    }
    
    
    
}
