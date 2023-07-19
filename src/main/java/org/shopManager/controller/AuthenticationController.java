package org.shopManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthenticationController implements Initializable {

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Label labelArea;

    @FXML
    private Button loginButton;

    private void authenticateUser() {
        String username = usernameInput.getText();
        String password = passwordInput.getText();

        if (username.isEmpty() || password.isEmpty()) {
            labelArea.setText("Ambos os campos devem ser preenchidos!");
        } else {

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
