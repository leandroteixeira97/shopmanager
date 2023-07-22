package org.shopManager.controller.scenes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.shopManager.controller.SceneHandler;
import org.shopManager.controller.SessionManager;
import org.shopManager.model.entity.User;
import org.shopManager.model.enumeration.SceneType;
import org.shopManager.model.service.UserService;
import org.shopManager.model.utils.DatabaseUtils;

import java.net.URL;
import java.sql.SQLException;
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

    private UserService userService;

    public void authenticateUser() throws SQLException {
        labelArea.setText("");

        String username = usernameInput.getText();
        String password = passwordInput.getText();

        if (username.isEmpty() || password.isEmpty()) {
            labelArea.setText("Ambos os campos devem ser preenchidos!");
        } else {
            try {
                User user = userService.authenticateUser(username, password);
                if (user.getId() != null || user.getId() != 0) {
                    SessionManager.setLoggedUser(user);
                    SceneHandler.handleScenes(SceneType.MAIN_MENU);
                } else {
                    throw new Exception("Null user!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                labelArea.setText("Não foi possível realizar o login. Usuário e/ou senha estão incorretos!");
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.userService = new UserService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
