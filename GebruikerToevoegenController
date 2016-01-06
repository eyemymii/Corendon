
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rene
 */
public class GebruikerToevoegenController implements Initializable {

    @FXML
    private Label lblEmail, errorToevoegen;

//    Menu knoppen
    @FXML
    private Button gaatNaarHome, gaatNaarKlanten, gaatNaarKoffers, gaatNaarGebruikers, gaatNaarHelp, logtUit;

//    Gebruiker toevoegen
    @FXML
    private Button toevoegGebruiker;
    @FXML
    private TextField gebruikersemail, gebruikersrol;
    @FXML
    private PasswordField gebruikerswachtwoord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /*
     We moeten de "on action" van de knoppen in scene builder veranderen naar "gaNaarPaginaActie", anders werkt niet. 
    Die van menubalk moet sws ********************************
     */
    @FXML
    private void gaNaarPaginaActie(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource() == gaatNaarHome) {
            //Home knop drukken         
            stage = (Stage) gaatNaarHome.getScene().getWindow();
            //Home pagina wordt geopend
            root = FXMLLoader.load(getClass().getResource("ThuisPagina.fxml"));
        } else if (event.getSource() == gaatNaarKlanten) {
            //Customers knop drukken         
            stage = (Stage) gaatNaarKlanten.getScene().getWindow();
            //Customers pagina wordt geopened
            root = FXMLLoader.load(getClass().getResource("KlantenIndex.fxml"));
        } else if (event.getSource() == gaatNaarKoffers) {
            //Lost Case knop drukken         
            stage = (Stage) gaatNaarKoffers.getScene().getWindow();
            //Lost Case pagina wordt geopend
            root = FXMLLoader.load(getClass().getResource("Koffers.fxml"));
        } else if (event.getSource() == gaatNaarGebruikers) {
            //Found Case knop drukken         
            stage = (Stage) gaatNaarGebruikers.getScene().getWindow();
            //Found Case pagina wordt geopend
            root = FXMLLoader.load(getClass().getResource("GebruikersIndex.fxml"));
        } else if (event.getSource() == gaatNaarHelp) {
            //Match Case knop drukken         
            stage = (Stage) gaatNaarHelp.getScene().getWindow();
            //Match Case pagina wordt geopend
            root = FXMLLoader.load(getClass().getResource("Help.fxml"));
        } else if (event.getSource() == logtUit) {
            //Help knop drukken         
            stage = (Stage) logtUit.getScene().getWindow();
            //Help pagina wordt geopend
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        }
    }

    /*
    De oude venster wisseling ********************************
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
     */
    
    /**
     * void toevoegenGebruiker(ActionEvent event) Voegt nieuwe gebruiker toe aan
     * database.
     *
     * @param event Als het op de knop wordt gedrukt, wordt de actie
     * geïnitialiseerd
     */
    
    @FXML
    private void toevoegenGebruiker(ActionEvent event) throws IOException, SQLException {
        if (gebruikersemail.getText().equals("") || gebruikerswachtwoord.getText().equals("") || gebruikersrol.getText().equals("")) {
            errorToevoegen.setText("Please fill in the required fields.");
        } else {
            errorToevoegen.setText("");
            User account = new User();
            account.setEmail(gebruikersemail.getText());
            account.setPassword(gebruikerswachtwoord.getText());
            account.setRole(gebruikersrol.getText());

            Stage stage;
            Parent root;
            if (event.getSource() == toevoegGebruiker) {       
            stage = (Stage) toevoegGebruiker.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("GebruikersIndex.fxml"));
        }
            
            /*
            Oude code ********************************
            //close previous window
            ((Node) event.getSource()).getScene().getWindow().hide();

            //load new screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/corendon/GebruikersIndex.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene((Pane) loader.load()));
            stage.setTitle("User");
            stage.show();
                    */

            try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost/corendon", "root", "Torenhoog1!")) {
                System.out.println("hoi");
                String insertDatabase = ("INSERT INTO corendon.users (Email,Password,UserRole) VALUES (?,?,?)");
                PreparedStatement preparedStatement = c.prepareStatement(insertDatabase);;
                preparedStatement.setString(1, account.email);
                preparedStatement.setString(2, account.wachtwoord);
                preparedStatement.setString(3, account.rol);
                preparedStatement.executeUpdate();

            }
        }
    }
}
