package org.lila_systems.mypet.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    Button btnCerrar;

    @FXML
    Button btnIngresar;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContrasenia;

    public void cerrar() {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void ingresar(ActionEvent event) throws IOException {
        String usuario = "admin";
        String contrasenia = "admin";

        if (txtUsuario.getText().equals(usuario) && txtContrasenia.getText().equals(contrasenia)) {

            Parent root = FXMLLoader.load(getClass().getResource("/org/lila_systems/mypet/gui/fxml/Principal.fxml"));
            Scene scene2 = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene2);

            stage.setTitle("Sistema MyPet");
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error!");
            alert.setTitle("ERROR");
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
        }
    }
}
