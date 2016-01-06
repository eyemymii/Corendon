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
 * @author Rene
 */
public class KlantenToevoegenController implements Initializable {

    @FXML
    private Label lblEmail, errorToevoegen;
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
    private Button voegKlantToe;
    @FXML
    private TextField klantPostcode;
    @FXML
    private TextField klantAdres;
    @FXML
    private TextField klantEmail;
    @FXML
    private TextField klantTel;
    @FXML
    private TextField klantAchternaam;
    @FXML
    private TextField klantVoorletter;
    @FXML
    private TextField klantStad;

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
    private void toevoegenKlant(ActionEvent event) throws SQLException, IOException {
        if (klantVoorletter.getText().equals("") || klantAchternaam.getText().equals("") || klantTel.getText().equals("") || klantEmail.getText().equals("") || klantAdres.getText().equals("") || klantPostcode.getText().equals("") || klantStad.getText().equals("")) {
            errorToevoegen.setText("Please fill in the required fields.");
        } else {
            errorToevoegen.setText("");
            Klanten klant = new Klanten();
            klant.setVoorletter(klantVoorletter.getText());
            klant.setAchternaam(klantAchternaam.getText());
            klant.setTel(klantTel.getText());
            klant.setKlantEmail(klantEmail.getText());
            klant.setAdres(klantAdres.getText());
            klant.setPostcode(klantPostcode.getText());
            klant.setStad(klantStad.getText());

            //close previous window
            ((Node) event.getSource()).getScene().getWindow().hide();

            //load new screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/corendon/KlantenIndex.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene((Pane) loader.load()));
            stage.setTitle("Klanten");
            stage.show();

            try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost/corendon", "root", "Torenhoog1!")) {
                String insertDatabase = ("INSERT INTO corendon.customers (Initial,Surname,Phonenumber1, Email, Adress, Zipcode, City) VALUES (?,?,?,?,?,?,?)");
                PreparedStatement preparedStatement = c.prepareStatement(insertDatabase);
                preparedStatement.setString(1, klant.voorletter);
                preparedStatement.setString(2, klant.achternaam);
                preparedStatement.setString(3, klant.klantEmail);
                preparedStatement.setString(4, klant.tel);
                preparedStatement.setString(5, klant.adres);
                preparedStatement.setString(6, klant.postcode);
                preparedStatement.setString(7, klant.stad);
                preparedStatement.executeUpdate();

            }
        }

    }
}
