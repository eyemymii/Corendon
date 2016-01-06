/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corendon;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author warie_000
 */
public class KofferToevoegenController implements Initializable {
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
    private TextField overige;
    @FXML
    private TextField kleur;
    @FXML
    private TextField materiaal;
    @FXML
    private TextField merk;
    @FXML
    private Button voegKofferToe;
    @FXML
    private Label errorToevoegen, statusKoffer;

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
* void toevoegenGebruiker(ActionEvent event) Voegt nieuwe koffer toe aan database.
* author Warisra
* @param event Als het op de knop wordt gedrukt, wordt de actie geïnitialiseerd
*/
    @FXML
    private void toevoegenKoffer(ActionEvent event) throws SQLException, IOException {
        if (kleur.getText().equals("") || merk.getText().equals("") || materiaal.getText().equals("") || statusKoffer.getText().equals("")) {
            errorToevoegen.setText("Please fill in the required fields.");
        }
        else {
            errorToevoegen.setText("");
            Koffer koffer = new Koffer();
            koffer.setKleur(kleur.getText());
            koffer.setMerk(merk.getText());
            koffer.setMateriaal(materiaal.getText());
            koffer.setOverige(overige.getText());
            koffer.setStatusKoffer(statusKoffer.getText());
            
            //close previous window
            ((Node) event.getSource()).getScene().getWindow().hide();             
              
            //load new screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/corendon/KoffersIndex.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene((Pane) loader.load()));
            stage.setTitle("Case");
            stage.show();
        
            try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost/corendon", "root", "Torenhoog1!")) {            
            String insertDatabase = ("INSERT INTO corendon.users (Brand,Material,Color,Other,Status) VALUES (?,?,?,?,?)");
            PreparedStatement preparedStatement = c.prepareStatement(insertDatabase);;
            preparedStatement.setString(1, koffer.merk);
            preparedStatement.setString(2, koffer.materiaal);
            preparedStatement.setString(3, koffer.kleur);
            preparedStatement.setString(4, koffer.overige);
            preparedStatement.setString(5, koffer.statusKoffer);
            preparedStatement.executeUpdate();
            
            }
        }
    }
    
}
