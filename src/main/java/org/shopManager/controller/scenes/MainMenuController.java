package org.shopManager.controller.scenes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.shopManager.controller.SessionManager;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private Button manageProductsButton;

    @FXML
    private Label messageLabel;

    public void openManageProductsScreen() {
        System.out.println("Suck my dick!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String labelMessage = messageLabel.getText().replace("@{user}", SessionManager.getProfile().getFirstName());
        messageLabel.setText(labelMessage);
    }
}
